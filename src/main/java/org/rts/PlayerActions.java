package org.rts;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 * @author rdriskill
 */
public class PlayerActions
{
   // TODO Ideas = { "Make invincible" }
   public static void setInitialInventory(Player player)
   {
      PlayerInventory inventory = player.getInventory();

      if(!inventory.contains(Material.BAKED_POTATO))
      {
         inventory.addItem(new ItemStack(Material.BAKED_POTATO, 10));
      }
      
      if(!inventory.contains(Material.WOOD_SWORD))
      {
         inventory.addItem(new ItemStack(Material.WOOD_SWORD, 1));
      }
      
      if(!inventory.contains(Material.LEATHER_HELMET))
      {
         inventory.addItem(new ItemStack(Material.LEATHER_HELMET, 1));
      }
      
      if(!inventory.contains(Material.LEATHER_CHESTPLATE))
      {
         inventory.addItem(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
      }
      
      if(!inventory.contains(Material.LEATHER_LEGGINGS))
      {
         inventory.addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));
      }
      
      if(!inventory.contains(Material.LEATHER_BOOTS))
      {
         inventory.addItem(new ItemStack(Material.LEATHER_BOOTS, 1));
      }
   }
}