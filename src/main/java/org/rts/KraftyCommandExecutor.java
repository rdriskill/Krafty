package org.rts;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author rdriskill
 */
public class KraftyCommandExecutor implements CommandExecutor
{
   private final JavaPlugin plugin;
   public static final String PLUGIN_COMMAND_PREFIX = "krafty";
   public static final String COMMAND_SEPARATOR = ".";
   public static final String FIREWORKS = PLUGIN_COMMAND_PREFIX + COMMAND_SEPARATOR + "fireworks";
   public static final String LIGHTNING = PLUGIN_COMMAND_PREFIX + COMMAND_SEPARATOR + "lightning";
   public static final String SPAWN = PLUGIN_COMMAND_PREFIX + COMMAND_SEPARATOR + "spawn";
   
   // TODO Untested commands added
   public static final String KILL_ENTITY = PLUGIN_COMMAND_PREFIX + COMMAND_SEPARATOR + "killEntity";
   public static final String ENCHANT_INVENTORY = PLUGIN_COMMAND_PREFIX + COMMAND_SEPARATOR + "enchantInventory";
   
   public KraftyCommandExecutor(JavaPlugin plugin)
   {
      this.plugin = plugin;
   }
   
   public void register()
   {
      plugin.getCommand(FIREWORKS).setExecutor(this);
      plugin.getCommand(LIGHTNING).setExecutor(this);
      plugin.getCommand(SPAWN).setExecutor(this);
      plugin.getCommand(KILL_ENTITY).setExecutor(this);
      plugin.getCommand(ENCHANT_INVENTORY).setExecutor(this);
   }
   
   /**
    * Method called when a command is executed.
    * @param CommandSender sender - who sent the command
    * @param Command cmd - the command that was executed 
    * @param String commandLabel - the command alias that was used
    * @param String[] args - an array of additional arguments, e.g. typing /hello abc def would put abc in args[0], and def in args[1] 
    */
   @Override
   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {
      if(cmd.getName().equalsIgnoreCase(FIREWORKS))
      { 
         return this.handleFireworksCmd(sender, cmd, commandLabel, args);
      }
      
      if(cmd.getName().equalsIgnoreCase(LIGHTNING))
      { 
         return this.handleLightningCmd(sender, cmd, commandLabel, args);
      }
      
      if(cmd.getName().equalsIgnoreCase(SPAWN))
      { 
         return this.handleSpawnCmd(sender, cmd, commandLabel, args);
      }
      
      if(cmd.getName().equalsIgnoreCase(KILL_ENTITY))
      { 
         return this.handleKillEntityCmd(sender, cmd, commandLabel, args);
      }
      
      if(cmd.getName().equalsIgnoreCase(ENCHANT_INVENTORY))
      { 
         return this.handleEnchantInventoryCmd(sender, cmd, commandLabel, args);
      }
      
      return false; 
   }
   
   private Boolean handleFireworksCmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {
      if(sender instanceof Player)
      {
         Player player = (Player) sender;
         
         Location location1 = player.getLocation();
         location1.setZ(location1.getZ() + 10); // X = Left or Right, Y = Height, Z = Forward or Backward   
         WorldActions.createFireworks(player.getWorld(), location1);
         
         Location location2 = player.getLocation();
         location2.setZ(location2.getZ() + 10);
         location2.setY(location2.getY() + 1);
         WorldActions.createFireworks(player.getWorld(), location2);
         
         Location location3 = player.getLocation();
         location3.setZ(location3.getZ() + 10);
         location3.setY(location3.getY() + 2);
         WorldActions.createFireworks(player.getWorld(), location3);
      }
      
      else 
      {
         sender.sendMessage("This command can only be run by a player.");
      }
      
      return Boolean.TRUE;
   }
   
   private Boolean handleLightningCmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {
      if(sender instanceof Player)
      {
         Player player = (Player) sender;
         Location location = player.getLocation();
         location.setZ(location.getZ() + 10);
         WorldActions.createLightning(player.getWorld(), location);
      }
      
      else 
      {
         sender.sendMessage("This command can only be run by a player.");
      }
      
      return Boolean.TRUE;
   }
   
   private Boolean handleSpawnCmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {
      if(args.length < 1)
      {
         sender.sendMessage("Command needs an arguement!");
         return Boolean.FALSE;
      } 
      
      if(sender instanceof Player)
      {
         Player player = (Player) sender;
         Location location = player.getLocation();
         location.setZ(location.getZ() + 5);
         String entityName = args[0].trim().toUpperCase();
         WorldActions.spawnEntity(player.getWorld(), location, entityName);
      }
      
      else 
      {
         sender.sendMessage("This command can only be run by a player.");
      }
      
      return Boolean.TRUE;
   }
   
   private Boolean handleKillEntityCmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {
      if(args.length < 1)
      {
         sender.sendMessage("Command needs an arguement!");
         return Boolean.FALSE;
      } 
      
      if(sender instanceof Player)
      {
         Player player = (Player) sender;
         String entityName = args[0].trim().toUpperCase();
         WorldActions.killEntity(player.getWorld(), entityName);
      }
      
      else 
      {
         sender.sendMessage("This command can only be run by a player.");
      }
      
      return Boolean.TRUE;
   }
   
   private Boolean handleEnchantInventoryCmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
   {      
      if(sender instanceof Player)
      {
         PlayerActions.enchantInventory((Player) sender);
      }
      
      else 
      {
         sender.sendMessage("This command can only be run by a player.");
      }
      
      return Boolean.TRUE;
   }
}