package woodCut;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.util.SkillData.Rate;

import woodCut.misc.*;
import woodCut.nodes.*;

@Manifest(authors = {"K"}, name = "K.WoodCutting", description = "Cut trees", version = 0.4 )
public class WoodCutting extends ActiveScript implements PaintListener 
{
	private static Tree jobContainer = null;
	private final static ArrayList<Node> jobs = new ArrayList<Node>();
	private final static Timer runTime = new Timer(0);
	private final SkillData sd = new SkillData(runTime);
	

	@Override
	public void onStart()
	{
		WoodCutGUI frame = new WoodCutGUI();
		frame.setVisible(true); 
		Variables.status = "Initialising.";
	}
	
	@Override
	public int loop() 
	{
		if (jobContainer != null) 
		{
			final Node job = jobContainer.state();
			if (job != null) 
			{
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		} 
		else 
		{
			jobs.add(new AntiBan());
			jobs.add(new Drop());
			jobs.add(new Burn());
			jobs.add(new Cut());
			
			jobContainer = new Tree(jobs.toArray(new Node[jobs.size()]));
		}
		return Random.nextInt(300, 600);
	}
	
	@Override
	public void onRepaint(Graphics graphics) 
	{
	     final Graphics2D g = (Graphics2D) graphics;
	     final Point p = Mouse.getLocation();
	     
	     
	     g.setColor(new Color(0, 0, 0, 99));
	     g.fillRect(1, 338, 517, 83);
	     
	     g.setColor(Color.WHITE);
	     g.drawString("Run Time         :" + runTime.toElapsedString(), 21, 360);
	     g.drawString("Experience Gained:" + sd.experience(Skills.WOODCUTTING)+"("+sd.experience(Rate.HOUR, Skills.WOODCUTTING)+")", 21, 375);
	     g.drawString("Level (gained)   :" + Skills.getLevel(Skills.WOODCUTTING)+"(+"+ sd.level(Skills.WOODCUTTING)+")", 21, 390);
	     g.drawString("Status           :" + Variables.status,21,405);
	     g.setColor(Color.GRAY);
	     g.drawString("made by K.", 400, 420);
	     
	     g.setColor(Mouse.isPressed()?Color.WHITE:Color.RED);
	     g.drawOval(p.x-3, p.y-2, 3, 3);
		
	}
	

}
