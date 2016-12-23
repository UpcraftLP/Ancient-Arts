package mod.upcraftlp.ancientarts.init;

import mod.upcraftlp.ancientarts.enchantments.EnchantmentHarvesting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AncientMisc {

	public static void init() {
		Enchantments.init();
	}
	
	public static class Enchantments {
		
		
		public static final Enchantment HARVESTING = new EnchantmentHarvesting(Enchantment.Rarity.RARE, new EntityEquipmentSlot[]{});
		
		public static void init() {
			register(HARVESTING);
			GameRegistry.register(HARVESTING);
		}
		
		public static void register(Enchantment ench) {
			Enchantment.REGISTRY.register(Enchantment.REGISTRY.getIDForObject(ench), new ResourceLocation(ench.getName().substring(12)), ench);
		}
		
	}
}
