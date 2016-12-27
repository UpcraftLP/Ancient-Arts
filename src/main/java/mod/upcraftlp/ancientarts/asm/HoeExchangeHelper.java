package mod.upcraftlp.ancientarts.asm;

import mod.upcraftlp.ancientarts.Main;
import mod.upcraftlp.ancientarts.init.AncientItems;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class HoeExchangeHelper {

	public static void init() {
		try {
			GameRegistry.addSubstitutionAlias("minecraft:wooden_hoe", GameRegistry.Type.ITEM, AncientItems.WOODEN_HOE);
			GameRegistry.addSubstitutionAlias("minecraft:stone_hoe", GameRegistry.Type.ITEM, AncientItems.STONE_HOE);
			GameRegistry.addSubstitutionAlias("minecraft:iron_hoe", GameRegistry.Type.ITEM, AncientItems.IRON_HOE);
			GameRegistry.addSubstitutionAlias("minecraft:golden_hoe", GameRegistry.Type.ITEM, AncientItems.GOLDEN_HOE);
			GameRegistry.addSubstitutionAlias("minecraft:diamond_hoe", GameRegistry.Type.ITEM, AncientItems.DIAMOND_HOE);
		} catch (ExistingSubstitutionException e) {
			Main.getLogger().println("Couldn't overwrite hoe enchantability for hoes!");
			Main.getLogger().println(e.getMessage());
		}
		
		
	}
}
