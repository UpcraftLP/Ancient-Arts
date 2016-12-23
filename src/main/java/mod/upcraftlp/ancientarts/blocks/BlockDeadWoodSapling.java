package mod.upcraftlp.ancientarts.blocks;

import core.upcraftlp.craftdev.API.structures.ITreeMapping;
import mod.upcraftlp.ancientarts.blocks.util.BasicSapling;
import mod.upcraftlp.ancientarts.blocks.util.TreeMappings;

public class BlockDeadWoodSapling extends BasicSapling {

	public BlockDeadWoodSapling() {
		super("deadwood");
	}

	@Override
	public ITreeMapping getTreeMapping() {
		return TreeMappings.DEADWOOD_TREE;
	}

}
