package me.sirantony.battlefield;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class EventListener implements Listener{
	
	private Battlefield pl;
	public EventListener(Battlefield instance){
		pl = instance;
	}	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent evt){
		Action a = evt.getAction();
		Player p = evt.getPlayer();
		if (a == Action.RIGHT_CLICK_BLOCK){
			Block b = evt.getClickedBlock();
			if (b.getType() == Material.WALL_SIGN || b.getType() == Material.SIGN_POST){
				String game = null;
				p.setMetadata("select", new FixedMetadataValue(pl, game));
			}
		} else if (a == Action.LEFT_CLICK_BLOCK){
			
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent evt){
		Player p = evt.getPlayer();
		if (p.hasMetadata("select")){
			String s = p.getMetadata("select").get(0).toString();
			
		}
	}
}
