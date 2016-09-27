package strategies;

import data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.wrappers.Npc;

public class Buying implements Strategy {
    Npc[] CRAFTS = Npcs.getNearest(Constants.STOREID);

    @Override
    public boolean activate() {
        return CRAFTS != null && CRAFTS.length > 0 && Inventory.getCount(Constants.CUT_DIAMOND) == 0 && Inventory.getCount(Constants.UNCUT_DIAMOND) == 0 && CRAFTS[0].distanceTo() < 20;
    }

    @Override
    public void execute() {
    CRAFTS[0].interact(Npcs.Option.SECOND);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Game.getOpenInterfaceId() == 3824 ;
            }
        },2500);
        Menu.sendAction(53, 1617, 6, 3900);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Inventory.isFull();
            }
        },2500);
        Menu.clickButton(200);
    }
}

