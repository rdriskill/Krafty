package org.rts;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
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
   
   public static void enchantInventory(Player player)
   {
      ItemStack[] itemStack = player.getInventory().getContents();
      Enchantment[] enchantments = Enchantment.values();
      
      for(ItemStack item: itemStack)
      {
         if(item != null)
         {
            for(Enchantment enchantment: enchantments)
            {
               if(enchantment != null)
               {
                  try
                  {
                     item.addEnchantment(enchantment, enchantment.getMaxLevel());
                  }
                  
                  catch(Exception ex) { } // Ignore
               }
            }
         }
      }
   }
   
   public static void createNuke(World world, Player player, String nukePlayerName)
   {
      List<Player> players = world.getPlayers();
      Location playerLocation = null;
      TNTPrimed tnt = null;
      int fuseTicks = 13;
      
      for(Player worldPlayer: players)
      {
         if(worldPlayer.getDisplayName().equals(nukePlayerName))
         {
            playerLocation = player.getLocation();
            break;
         }
      }
      
      if(playerLocation != null)
      {
         // 20 block wide
         // 20 block height
         // X = Left or Right, Y = Height, Z = Forward or Backward
         playerLocation.setY(playerLocation.getY() + 5);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setX(playerLocation.getX() + 1);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setX(playerLocation.getX() + 1);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setX(playerLocation.getX() - 3);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setX(playerLocation.getX() - 1);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setZ(playerLocation.getZ() + 1);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setZ(playerLocation.getZ() + 1);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setZ(playerLocation.getZ() - 3);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
         playerLocation.setZ(playerLocation.getZ() - 1);
         tnt = world.spawn(playerLocation, TNTPrimed.class);
         ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
         
      }
      
      else player.sendMessage("Player could not be found.");
   }
}