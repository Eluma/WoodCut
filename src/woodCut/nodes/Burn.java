package woodCut.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.SceneObject;

import woodCut.misc.Variables;

public class Burn extends Node {

	@Override
	public boolean activate() {
		
		return Inventory.isFull() && Variables.burn;
	}

	@Override
	public void execute() 
	{
		Variables.status="BURN!";
		
		final SceneObject fire = SceneEntities.getNearest(Variables.fireId);
		
		if(fire == null)
			if(Inventory.getItem(Variables.logId).getWidgetChild().interact("Light"))//light one prevent running far away if others set a fire.
			{
				sleep(Random.nextInt(3000,4500));

			}
		
		if(Inventory.getItem(Variables.logId).getWidgetChild().interact("Use"))
		{
			if(fire.interact("Use"))
				sleep(Random.nextInt(2000, 3000)*Inventory.getCount(Variables.logId));

		}
		
		
		
	}


}
