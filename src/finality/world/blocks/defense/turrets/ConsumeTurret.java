package finality.world.blocks.defense.turrets;

import arc.struct.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.logic.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;

public class ConsumeTurret extends Turret {
    public BulletType shootType;

    public ConsumeTurret(String name){
        super(name);
        envEnabled |= Env.space;
    }

    public boolean valid(Building b){
        return false;
    }

    @Override
    public void setStats(){
        super.setStats();
        stats.add(Stat.ammo, StatValues.ammo(ObjectMap.of(this, shootType)));
    }

    public class ConsumeTurretBuild extends TurretBuild {
        @Override
        public void updateTile() {
            unit.ammo(consValid() ? unit.type().ammoCapacity : 0);
            super.updateTile();
        }

        @Override
        public boolean consValid() {
            return super.consValid() && valid(this);
        }

        @Override
        public double sense(LAccess sensor){
            return switch(sensor){
                case ammo -> consValid() ? unit.type().ammoCapacity : 0;
                case ammoCapacity -> 1;
                default -> super.sense(sensor);
            };
        }

        @Override
        public BulletType useAmmo(){
            //nothing used directly
            return shootType;
        }

        @Override
        public boolean hasAmmo(){
            //you can always rotate, but never shoot if there's no power
            return true;
        }

        @Override
        public BulletType peekAmmo(){
            return shootType;
        }
    }
}
