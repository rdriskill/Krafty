package org.rts;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * @author rdriskill
 */
public class WorldActions
{
   // TODO Ideas = { "Create explostions", "Build a structure", "Spawn creatures" }
   public static void createFireworks(World world, Location location)
   {
      // Spawn the Firework, get the FireworkMeta.
      Firework firework = (Firework) world.spawnEntity(location, EntityType.FIREWORK);
      FireworkMeta fireworkMeta = firework.getFireworkMeta();

      // Our random generator
      Random r = new Random();

      // Get the type
      int rt = r.nextInt(4) + 1;
      Type type = Type.BALL;
      
      if (rt == 1)
         type = Type.BALL;
      if (rt == 2)
         type = Type.BALL_LARGE;
      if (rt == 3)
         type = Type.BURST;
      if (rt == 4)
         type = Type.CREEPER;
      if (rt == 5)
         type = Type.STAR;

      // Get our random colours
      int r1i = r.nextInt(17) + 1;
      int r2i = r.nextInt(17) + 1;
      Color c1 = BukkitUtils.getColor(r1i);
      Color c2 = BukkitUtils.getColor(r2i);

      // Create our effect with this
      FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

      // Then apply the effect to the meta
      fireworkMeta.addEffect(effect);

      // Generate some random power and set it
      int rp = r.nextInt(2) + 1;
      fireworkMeta.setPower(rp);

      // Then apply this to our rocket
      firework.setFireworkMeta(fireworkMeta);
   }
   
   public static void createLightning(World world, Location location)
   {
      world.strikeLightning(location);
   }
   
   /**
    * @see <a href="http://jd.bukkit.org/rb/apidocs/org/bukkit/entity/EntityType.html">org.bukkit.entity.EntityType</a>
    * 
    * @param world instance of the world of the player
    * @param location location that the entity should be spawned
    * @param entityName name of entity to be spawned. Valid entity 
    *    names include bat, cave_spider, chicken, cow, creeper, ghast, horse, pig_zombie, snowman, zombie
    */
   public static void spawnEntity(World world, Location location, String entityName)
   {
      world.spawn(location, EntityType.valueOf(entityName).getEntityClass());
   }
   
   public static void killEntity(World world, String entityName)
   {
      Class<? extends Entity> entityClass = EntityType.valueOf(entityName).getEntityClass();
      
      for (Entity entity : world.getEntities())
      {
         if (entity.getClass().equals(entityClass) && entity instanceof Damageable)
         {
            ((Damageable)entity).damage(1000000000);
         }
      }
   }
}