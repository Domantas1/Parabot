package main;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import strategies.Buying;
import strategies.Cutting;
import strategies.Tipping;

import java.util.ArrayList;


@ScriptManifest(author = "Domantas1",
        category = Category.CRAFTING,
        description = "Cuts Diamonds Into Tips",
        name = "Diamond Cutter",
        servers = { "PKHonor" },
        version = 1)

public class Core extends Script{
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();


    @Override
    public boolean onExecute() {
        System.out.println("Strats");
        strategies.add(new Buying());
        strategies.add(new Cutting());
        strategies.add(new Tipping());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }

}
