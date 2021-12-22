package finality.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.graphics.*;

public class FinalityFx {
    public static Effect

    cryoBeam = new Effect(60, e -> {
        Draw.z(Layer.bullet - 1);
        Draw.blend(Blending.additive);

        Lines.stroke(4 * e.fout(Interp.pow5In), Liquids.cryofluid.color);

        if(e.data instanceof Vec2 v){
            Lines.line(e.x, e.y, v.x, v.y);
        }

        Draw.blend();
    }),

    cryoShot = new Effect(30, e -> {
        Draw.color(Liquids.cryofluid.color);
        float w = 10 * e.fout(Interp.pow5In);

        Drawf.tri(e.x, e.y, w, 50, e.rotation);
        Drawf.tri(e.x, e.y, w, 10, e.rotation - 180);

        Draw.z(Layer.effect + 0.1f);
        Draw.blend(Blending.additive);

        Drawf.tri(e.x, e.y, w * 1.5f, 55, e.rotation);
        Drawf.tri(e.x, e.y, w * 1.5f, 15, e.rotation - 180);

        Draw.blend();
    }),

    cryoDespawn = new Effect(60, e -> {
        Draw.z(Layer.bullet - 0.1f);
        Draw.blend(Blending.additive);

        Tmp.c1.set(Liquids.cryofluid.color).a(e.fout(Interp.pow5In));
        Fill.light(e.x, e.y, 10, 20, Tmp.c1, Color.clear);

        Draw.blend();
    }),

    cryoSplash = new Effect(60, e -> {
        float rad = 40 * e.fin(Interp.pow5Out);
        Draw.z(Layer.bullet - 0.1f);
        Draw.blend(Blending.additive);

        Tmp.c1.set(Liquids.cryofluid.color).a(e.fout(Interp.pow5In));
        Fill.light(e.x, e.y, Lines.circleVertices(rad), rad, Color.clear, Tmp.c1);

        Draw.blend();
    });
}
