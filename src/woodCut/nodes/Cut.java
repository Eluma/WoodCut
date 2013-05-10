package woodCut.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.methods.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import woodCut.misc.*;

public class Cut extends Node 
{

	@Override
	public boolean activate() 
	{
		// TODO Auto-generated method stub
		return !Inventory.isFull()&&Players.getLocal().getAnimation()==-1;
	}

	@Override
	public void execute() 
	{
		Variables.status = "Finding Tree";
		final SceneObject selectedTree = SceneEntities.getNearest(Variables.treeIds);
		
		if(selectedTree != null)
		{
			if(!selectedTree.isOnScreen())
			{
				Camera.turnTo(selectedTree);
			}
			if(selectedTree.interact("Chop down"))
			{
				Variables.status = "Cutting";
				sleep(700,1200);
			}
		}
			
	}

}
