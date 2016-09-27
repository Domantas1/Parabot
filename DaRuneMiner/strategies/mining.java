package strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class mining implements Strategy{
    SceneObject runite;
    @Override
    public boolean activate() {
        runite = runerock();
        return Players.getMyPlayer().getAnimation() == -1 && Inventory.getCount() < 28 && runite != null;
    }

    @Override
    public void execute() {
    runite.interact(SceneObjects.Option.MINE);
        Time.sleep(1800);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Players.getMyPlayer().getAnimation() == -1;}
        },3000);
    }

    private SceneObject runerock() {
        for(SceneObject runerock : SceneObjects.getNearest(2106, 2107)){
            if(runerock != null){
                return runerock;
            }
        }
        return null;
    }
}
