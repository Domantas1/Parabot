package strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class banking implements Strategy{

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        SceneObject[] BANKBOOTH = SceneObjects.getNearest(9398);
        if(BANKBOOTH.length > 0) {
            BANKBOOTH[0].interact(SceneObjects.Option.DEPOSIT);
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Game.getOpenInterfaceId() == 23350;
                }
            },3000);}
        Menu.sendAction(646 , 447 , 13 , 23412);
        Time.sleep(1200);
        Menu.clickButton(200);
    }
}