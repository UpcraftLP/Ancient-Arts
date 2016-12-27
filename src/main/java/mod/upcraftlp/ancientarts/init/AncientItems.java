package mod.upcraftlp.ancientarts.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.upcraftlp.ancientarts.items.ItemFireOrb;
import mod.upcraftlp.ancientarts.items.ItemHoeCustomEnchantability;
import mod.upcraftlp.ancientarts.items.ItemTest;
import mod.upcraftlp.ancientarts.items.ItemWaterOrb;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class AncientItems {

	public static Map<Item, CreativeTabs> itemMap;
	
	/**Orbs**/
	public static final Item WATER_ORB = new ItemWaterOrb();
	public static final Item FIRE_ORB = new ItemFireOrb();
	
	public static final Item TEST = new ItemTest();
	
	/**HOES**/
	public static final Item WOODEN_HOE = new ItemHoeCustomEnchantability(ToolMaterial.WOOD);
	public static final Item STONE_HOE = new ItemHoeCustomEnchantability(ToolMaterial.STONE);
	public static final Item IRON_HOE = new ItemHoeCustomEnchantability(ToolMaterial.IRON);
	public static final Item GOLDEN_HOE = new ItemHoeCustomEnchantability(ToolMaterial.GOLD);
	public static final Item DIAMOND_HOE = new ItemHoeCustomEnchantability(ToolMaterial.DIAMOND);
	
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
	
	public static void postInit() {
		itemMap.put(WOODEN_HOE, CreativeTabs.TOOLS);
		itemMap.put(STONE_HOE, CreativeTabs.TOOLS);
		itemMap.put(IRON_HOE, CreativeTabs.TOOLS);
		itemMap.put(GOLDEN_HOE, CreativeTabs.TOOLS);
		itemMap.put(DIAMOND_HOE, CreativeTabs.TOOLS);
	}
}
