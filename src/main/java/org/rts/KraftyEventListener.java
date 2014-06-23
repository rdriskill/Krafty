package org.rts;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 * @author rdriskill
 */
public class KraftyEventListener implements Listener
{
   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent evt) 
   {
      Player player = evt.getPlayer(); // The player who joined
      PlayerInventory inventory = player.getInventory(); // The player's inventory
      
      ItemStack potatoStack = new ItemStack(Material.BAKED_POTATO, 10);
      ItemStack woodSwordStack = new ItemStack(Material.WOOD_SWORD, 1);
      ItemStack helmetStack = new ItemStack(Material.LEATHER_HELMET, 1);
      ItemStack chestplateStack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
      ItemStack leggingsStack = new ItemStack(Material.LEATHER_LEGGINGS, 1);
      ItemStack bootsStack = new ItemStack(Material.LEATHER_BOOTS, 1);
      
      if(inventory.contains(potatoStack))
      {
         inventory.addItem(potatoStack);
      }
      
      if(inventory.contains(woodSwordStack))
      {
         inventory.addItem(woodSwordStack);
      }
      
      if(inventory.contains(helmetStack))
      {
         inventory.addItem(helmetStack);
      }
      
      if(inventory.contains(chestplateStack))
      {
         inventory.addItem(chestplateStack);
      }
      
      if(inventory.contains(leggingsStack))
      {
         inventory.addItem(leggingsStack);
      }
      
      if(inventory.contains(bootsStack))
      {
         inventory.addItem(bootsStack);
      }
      
      player.sendMessage("Welcome! We've added items to your inventory to get you started!");
  }
}