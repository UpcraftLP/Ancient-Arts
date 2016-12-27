package mod.upcraftlp.ancientarts.init;

import com.google.common.base.Predicate;

import mod.upcraftlp.ancientarts.Reference;
import mod.upcraftlp.ancientarts.enchantments.EnchantmentHarvesting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AncientMisc {

	static {
		
		try {
//			Field f = ReflectionHelper.getField(Items.class, "IRON_HOE");
//			Field modifiers = Field.class.getDeclaredField("modifiers");
//			modifiers.setAccessible(true);
//			modifiers.setInt(f, f.getModifiers() & ~Modifier.FINAL);
//			Item IRON_HOE = (Item) f.get(null);
//			f.set(IRON_HOE, proxy$IRON_HOE);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void init() {
		Enchantments.init();
	}
	
	public static class Enchantments {
		
		public static final EnumEnchantmentType ENUM_HOE;
		static {
			
			
			
			
			ENUM_HOE = EnumHelper.addEnchantmentType(Reference.MODID.toUpperCase() + "." + "HOE", new Predicate<Item>() {

				@Override
				public boolean apply(Item input) {
					return input instanceof ItemHoe || input.getToolClasses(new ItemStack(input)).contains("hoe");
				}
				
			});
		}
		
		public static final Enchantment HARVESTING = new EnchantmentHarvesting();
		
		public static void init() {
			GameRegistry.register(HARVESTING);
		}
		
		
		
	}
}
