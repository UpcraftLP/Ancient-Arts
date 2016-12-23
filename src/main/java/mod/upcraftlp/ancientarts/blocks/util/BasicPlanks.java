package mod.upcraftlp.ancientarts.blocks.util;

import core.upcraftlp.craftdev.API.templates.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BasicPlanks extends Block {

	public BasicPlanks(String name) {
		super("planks_" + name, Material.WOOD, true);
		this.setSoundType(SoundType.WOOD);
	}
	
}
