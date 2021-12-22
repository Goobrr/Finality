package finality.content;

import finality.type.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;

public class FinalityBlocks {
    // screw ContentLists
    public static Block snowfall, winter;

    public static void load(){
        snowfall = new PowerTurret("snowfall"){{
            buildVisibility = BuildVisibility.shown;
            size = 2;
            reloadTime = 150f;
            range = 120f;
            health = 200 * size * size;

            shootType = new BeamBulletType(){{
                damage = 150;
                status = StatusEffects.freezing;
                statusDuration = 60 * 5f;

                trailEffect = FinalityFx.cryoBeam;
            }};

            consumes.liquid(Liquids.cryofluid, 0.3f).update(false);
        }};

        winter = new PowerTurret("winter"){{
            buildVisibility = BuildVisibility.shown;
            size = 3;
            reloadTime = 400f;
            range = 200f;
            health = 300 * size * size;

            shootType = new BeamBulletType(){{
                damage = 250;
                status = StatusEffects.freezing;
                statusDuration = 60 * 10f;

                trailEffect = FinalityFx.cryoBeam;
            }};

            consumes.liquid(Liquids.cryofluid, 0.5f).update(false);
        }};
    }
}
