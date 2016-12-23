package mod.upcraftlp.ancientarts.blocks.util.trees;

import core.upcraftlp.craftdev.API.structures.ITreeMapping;
import mod.upcraftlp.ancientarts.blocks.util.BasicLeaves;
import mod.upcraftlp.ancientarts.blocks.util.BasicLog;
import mod.upcraftlp.ancientarts.init.AncientBlocks;
import net.minecraft.block.BlockLog;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeMappingDeadWood implements ITreeMapping {

	@Override
	public void placeLeaves(World world, BlockPos pos) {
		world.setBlockState(pos, AncientBlocks.DEADWOOD_LEAVES.getDefaultState().withProperty(BasicLeaves.DECAYABLE, true));
	}

	@Override
	public void placeLog(World world, BlockPos pos, Axis axis) {
		world.setBlockState(pos, AncientBlocks.DEADWOOD_LOG.getDefaultState().withProperty(BasicLog.AXIS, BlockLog.EnumAxis.values()[axis.ordinal()]));
	}

}
