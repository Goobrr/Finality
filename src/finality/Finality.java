package finality;

import arc.*;
import arc.util.*;
import finality.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class Finality extends Mod{

    public Finality(){
    }

    @Override
    public void loadContent(){
        FinalityBlocks.load();
    }

}
