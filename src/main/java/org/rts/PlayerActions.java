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
         double origX = playerLocation.getX();
         double origY = playerLocation.getY();
         double origZ = playerLocation.getZ();
         
         // Height Loop
         for(double yIndex = origY + 5; yIndex <= origY + 10; yIndex += 2)
         {
            playerLocation.setY(yIndex);
            tnt = world.spawn(playerLocation, TNTPrimed.class);
            ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
            
            // Forward/Backward Loop
            for(double zIndex = origZ - 1; zIndex <= origZ + 1; zIndex += 1)
            {
               playerLocation.setZ(zIndex);
               tnt = world.spawn(playerLocation, TNTPrimed.class);
               ((TNTPrimed)tnt).setFuseTicks(fuseTicks);

               // Left/Right Loop
               for(double xIndex = origX - 1; xIndex <= origX + 1; xIndex += 1)
               {
                  playerLocation.setX(xIndex);
                  tnt = world.spawn(playerLocation, TNTPrimed.class);
                  ((TNTPrimed)tnt).setFuseTicks(fuseTicks);
               }
            }
         }                
      }
      
      else player.sendMessage("Player could not be found.");
   }
}