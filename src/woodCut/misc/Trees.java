package woodCut.misc;

public enum Trees 
{
	NORMAL(1,1,"Normal",new int [] {38760,38785},1511),
	OAK(2,15,"Oak",new int [] {38731,38732},1521),
	WILLOW(3,30,"Willow",new int [] {58006,38627,38616,38725},1519 );
	
	private final String NAME;
	private final int GUI_NO,LEVEL,LOG_ID;
	private final int [] TREE_ID;
	
	Trees(int guiNo, int level, String name,int [] tId,int logID)
	{
		this.NAME  = name;
		this.LEVEL = level;
		this.GUI_NO = guiNo;
		this.TREE_ID = tId;
		this.LOG_ID = logID;
	}
	
	public String getName()
	{
		return NAME;
	}
	
	public int getGuiNo()
	{
		return GUI_NO;
	}
	
	public int getLevel()
	{
		return LEVEL;
	}
	
	public int [] getTreeIds()
	{
		return TREE_ID;
	}
	
	public int getLogID()
	{
		return LOG_ID;
	}
	
}
