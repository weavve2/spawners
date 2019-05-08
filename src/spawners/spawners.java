package spawners;
import org.bukkit.World;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class spawners implements Listener {
	public spawners(main plugin) {
		// TODO Auto-generated constructor stub
	}
	@EventHandler
	public void onPlayerMinesSpawner(BlockBreakEvent e) {
		Player p = e.getPlayer();
		World w = p.getWorld();
		Block b = e.getBlock();
		if (p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)){
			if (b.getType() == Material.SPAWNER) {
				CreatureSpawner spawner = (CreatureSpawner) b.getState(); 
				ItemStack item = new ItemStack(e.getBlock().getType());
				ItemMeta m = item.getItemMeta();
				m.setDisplayName(spawner.getSpawnedType().toString());
				item.setItemMeta(m);
				w.dropItem(b.getLocation(),item);
			}		
		}
	}
	@EventHandler
	public void onPlayerPlaceeSpawner(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (b.getType() == Material.SPAWNER) {
			ItemStack i = p.getInventory().getItemInMainHand();
			ItemMeta m = i.getItemMeta();
			String name = m.getDisplayName();
			BlockState bs = b.getState();
			CreatureSpawner spawner = (CreatureSpawner) bs; 
			spawner.setSpawnedType(EntityType.valueOf(name));
			bs.update();
		}	
	}
}
