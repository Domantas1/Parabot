package strategies;


import data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;


public class Cutting implements Strategy{

    @Override
    public boolean activate() {
        return Players.getMyPlayer().getAnimation() == -1 && Inventory.getCount(Constants.CHISEL) == 1 && Inventory.isFull() && Inventory.getCount(Constants.UNCUT_DIAMOND) >= 24;
    }

    @Override
    public void execute() {
    Menu.sendAction(447, 1755, 27, 3214);
    Time.sleep(250);
        Menu.sendAction(870, 1617, 26, 3214);
        System.out.println("Cutting");
        Menu.sendAction(315,128,133,2498);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Inventory.getCount(Constants.UNCUT_DIAMOND) == 0;
            }
        },2500);
    Time.sleep(500);
    }
}
