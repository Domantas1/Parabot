package strategies;

import org.parabot.core.reflect.RefClass;
import org.parabot.core.reflect.RefMethod;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

public class banking implements Strategy{

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    public static void walkTo(Tile to) {
        RefClass refClass = new RefClass(Loader.getClient());
        RefMethod method = refClass.getMethod("walkTo");
        method.invoke(false,false,0, 0, 0, 0, Players.getMyPlayer().getLocation().getRegionY(), 0, 0, to.getRegionY(), Players.getMyPlayer().getLocation().getRegionX(), true, to.getRegionX());
    }

    @Override
    public void execute() {
        walkTo(new Tile(3043,9746,0));
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