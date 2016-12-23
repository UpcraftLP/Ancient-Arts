package mod.upcraftlp.ancientarts.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.upcraftlp.ancientarts.items.ItemFireOrb;
import mod.upcraftlp.ancientarts.items.ItemTest;
import mod.upcraftlp.ancientarts.items.ItemWaterOrb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AncientItems {

	public static Map<Item, CreativeTabs> itemMap;
	
	/**Orbs**/
	public static final Item WATER_ORB = new ItemWaterOrb();
	public static final Item FIRE_ORB = new ItemFireOrb();
	
	public static Item TEST = new ItemTest();
	
	public static void init() {
		itemMap = new HashMap<Item, CreativeTabs>();
		List<Item> items = new ArrayList<Item>();
		
		/**Orbs**/
		items.add(WATER_ORB);
		items.add(FIRE_ORB);
		
		items.add(TEST);
		
		for (Item item : items) {
			itemMap.put(item, AncientTabs.tabAncientArts);
		}
	}
}
