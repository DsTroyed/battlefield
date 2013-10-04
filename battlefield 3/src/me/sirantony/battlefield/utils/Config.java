package me.sirantony.battlefield.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import me.sirantony.battlefield.Battlefield;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private Battlefield pl;
	public Config(Battlefield instance){
		pl = instance;
	}
	
	private FileConfiguration config = null;
	private File configFile = null;
	
	public void reloadConfig() {
	    if (configFile == null) {
	   configFile = new File(pl.getDataFolder(), "config.yml");
	    }
	    config = YamlConfiguration.loadConfiguration(configFile);
	 
	    InputStream defConfigStream = pl.getResource("config.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        config.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getConfig() {
	    if (config == null) {
	        reloadConfig();
	    }
	    return config;
	}
	
	public void saveConfig() {
	    if (config == null || configFile == null) {
	        return;
	    }
	    try {
	        getConfig().save(configFile);
	    } catch (IOException ex) {
	        pl.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
	    }
	}
	
	//THIS IS WRONG, NEED TO CODE FURTHER
	public void reloadGame(String s) {
	    if (configFile == null) {
	   configFile = new File(pl.getDataFolder(), "config.yml");
	    }
	    config = YamlConfiguration.loadConfiguration(configFile);
	 
	    InputStream defConfigStream = pl.getResource("config.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        config.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getGame(String s) {
	    if (config == null) {
	        reloadGame(s);
	    }
	    return config;
	}
	
	public void saveGame(String s) {
	    if (config == null || configFile == null) {
	        return;
	    }
	    try {
	        getConfig().save(configFile);
	    } catch (IOException ex) {
	        pl.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
	    }
	}
	//WRONG PART ENDS HERE
	
	
}
