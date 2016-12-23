package mod.upcraftlp.ancientarts.blocks;

import mod.upcraftlp.ancientarts.blocks.util.BasicLeaves;
import mod.upcraftlp.ancientarts.init.AncientBlocks;
import net.minecraft.item.ItemStack;

public class BlockDeadWoodLeaves extends BasicLeaves {

	public BlockDeadWoodLeaves() {
		super("deadwood");
	}

	@Override
	public ItemStack getSapling() {
		return new ItemStack(AncientBlocks.DEADWOOD_SAPLING);
	}

	@Override
	public int getSaplingChance() {
		return 20;
	}

}
