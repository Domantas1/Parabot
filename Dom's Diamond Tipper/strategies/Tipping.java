package strategies;


import data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;

public class Tipping implements Strategy {

    @Override
    public boolean activate() {
        return Inventory.getCount(Constants.UNCUT_DIAMOND)==0 && Players.getMyPlayer().getAnimation() == -1 && Inventory.getCount(Constants.CUT_DIAMOND) >= 21;
    }

    @Override
    public void execute() {
        Time.sleep(500);
        if (Players.getMyPlayer().getAnimation() == -1) {
            Menu.sendAction(447, 1755, 27, 3214);
            Time.sleep(250);
            Menu.sendAction(870, 1601, 26, 3214);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Game.getOpenBackDialogId() == 2469;
                }
            }, 1500);
            clickOption(0);
            Time.sleep(800);
            clickOption(1);
        }
        Time.sleep(1000);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Players.getMyPlayer().getAnimation() == -1;
            }
        },2500);
    }

    private void clickOption(int option) {

        int optionAction = 2494;
        switch (option) {
            case 0:
                optionAction = 2472;
                break;
            case 1:
                optionAction = 2498;
                break;
            case 2:
                optionAction = 2496;
                break;
            case 3:
                optionAction = 2497;
                break;
            case 4:
                optionAction = 2498;
                break;
            case 5:
                optionAction = 2472;
        }
        Menu.sendAction(315, 0, 0, optionAction, 0);
        Time.sleep(500);
    }
}
