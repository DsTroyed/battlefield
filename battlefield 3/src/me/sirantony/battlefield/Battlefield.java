package me.sirantony.battlefield;

import org.bukkit.plugin.java.JavaPlugin;

public class Battlefield extends JavaPlugin{
	
	public Battlefield pl;
	
	public void onEnable(){
		//load configs
		
		//load modules
		
		//load games
		
		//load weapons...
		pl = this;
	}
	public void onDisable(){
		pl = null;
	}
	
	public Battlefield getInstance(){
		return pl;
	}
}
