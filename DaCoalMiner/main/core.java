package main;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import strategies.banking;
import strategies.mining;

import java.util.ArrayList;


@ScriptManifest(author = "Domantas1",
        category = Category.MINING,
        description = "Mines Coal at Mining Guild and Banks",
        name = "DaCoalMiner",
        servers = { "PKHonor" },
        version = 1)

public class core extends Script{
    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    @Override
    public boolean onExecute() {
        System.out.println("strategies");
        strategies.add(new mining());
        strategies.add(new banking());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {
        System.out.println("Script Stopped");
    }
}


