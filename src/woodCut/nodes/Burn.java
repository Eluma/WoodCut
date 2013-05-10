package woodCut.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Timer;
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
		
		SceneObject fire = SceneEntities.getNearest(Variables.fireId);
		Timer t = new Timer(140000); 
		if(fire == null)
			fire = lightFire();
		
		if(Inventory.getItem(Variables.logId).getWidgetChild().interact("Use"))
		{
			if(fire.interact("Use"))
				while(t.isRunning())
				{
					fire = SceneEntities.getNearest(Variables.fireId);
					if(fire == null)
						break;// can change to lightFire(). but when the fire goes off most likely most of the logs are gone.
					else if(Inventory.getCount(Variables.logId)==0)
						break;
						sleep(2000);
				}
		}
		
	}
	
	public SceneObject lightFire()
	{
		SceneObject fire = SceneEntities.getNearest(Variables.fireId);
		Timer t = new Timer(10000);
		if(Inventory.getItem(Variables.logId).getWidgetChild().interact("Light"))//light one prevent running far away if others set a fire.
		{	
			while(t.isRunning())
			{
				fire = SceneEntities.getNearest(Variables.fireId);
				if(fire != null)
					break;
			}
			
		}
		return fire;
	}

}
