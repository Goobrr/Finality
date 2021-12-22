package finality.content;

import arc.graphics.g2d.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;

public class FinalityFx {
    public static Effect

    cryoBeam = new Effect(60, e -> {
        Lines.stroke(3 * e.fout(), Liquids.cryofluid.color);
        if(e.data instanceof Vec2 v){
            Lines.line(e.x, e.y, v.x, v.y);
        }
    });
}
