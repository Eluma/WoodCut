package woodCut.nodes;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;

import woodCut.misc.Variables;

public class Drop extends Node 
{

	@Override
	public boolean activate() 
	{
		return Inventory.isFull() && Variables.drop;
	}

	@Override
	public void execute() 
	{
		Variables.status="Dropping Logs";
		while(Inventory.contains(Variables.logId))
		{
			if(Inventory.getItem(Variables.logId).getWidgetChild().interact("Drop"))
			sleep(300);
		}
		
	}


}
