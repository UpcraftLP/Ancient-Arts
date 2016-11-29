package mod.upcraftlp.ancientarts.init;

import core.upcraftlp.craftdev.API.templates.CreativeTab;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class AncientTabs {

	public static CreativeTab tabAncientArts = new CreativeTab("tabAncientArts", false);
	
	public static void setIcons() {
		tabAncientArts.setIconStack(new ItemStack(Blocks.DIAMOND_BLOCK));
	}
}
