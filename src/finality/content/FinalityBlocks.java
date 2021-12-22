package finality.content;

import finality.type.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
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
            reloadTime = 75f;
            range = 120f;
            health = 200 * size * size;

            inaccuracy = 0;
            velocityInaccuracy = 0;

            shootSound = Sounds.spark;

            shootType = new BeamBulletType(){{
                damage = 150;
                status = StatusEffects.freezing;
                statusDuration = 60 * 5f;

                splashDamage = 20;
                splashDamageRadius = 30;

                trailEffect = FinalityFx.cryoBeam;
                shootEffect = FinalityFx.cryoShot;

                hitEffect = Fx.none;
                despawnEffect = FinalityFx.cryoDespawn;
            }};

            consumes.liquid(Liquids.cryofluid, 0.3f).update(false);
        }};

        winter = new PowerTurret("winter"){{
            buildVisibility = BuildVisibility.shown;
            size = 3;
            reloadTime = 200f;
            range = 200f;
            health = 300 * size * size;

            inaccuracy = 0;
            velocityInaccuracy = 0;

            shootSound = Sounds.shotgun;

            shootType = new BeamBulletType(){{
                damage = 250;
                status = StatusEffects.freezing;
                statusDuration = 60 * 10f;

                splashDamage = 50;
                splashDamageRadius = 40;

                trailEffect = FinalityFx.cryoBeam;
                shootEffect = FinalityFx.cryoShot;

                hitEffect = FinalityFx.cryoSplash;
                despawnEffect = FinalityFx.cryoDespawn;
            }};

            consumes.liquid(Liquids.cryofluid, 0.5f).update(false);
        }};
    }
}
