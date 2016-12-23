package mod.upcraftlp.ancientarts.blocks.util;

import java.util.Iterator;

import core.upcraftlp.craftdev.API.templates.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BasicLog extends Block { //TODO: import into core!

	public static final PropertyEnum<BlockLog.EnumAxis> AXIS = PropertyEnum.create("axis", BlockLog.EnumAxis.class);
	
	public BasicLog(String name) {
		super("log_" + name, Material.WOOD, true);
		this.setDefaultState(this.getDefaultState().withProperty(AXIS, BlockLog.EnumAxis.Y));
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{AXIS});
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(AXIS, BlockLog.EnumAxis.values()[facing.getAxis().ordinal()]);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AXIS, BlockLog.EnumAxis.values()[meta]);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockLog.EnumAxis) state.getValue(AXIS)).ordinal();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		int b0 = 4;
		int i = b0 - 1;
		if (worldIn.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i)))
		{
			Iterator<BlockPos> iterator = BlockPos.getAllInBox(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)).iterator();

			while (iterator.hasNext())
			{
				BlockPos blockpos1 = (BlockPos)iterator.next();
				IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

				if (iblockstate1.getBlock().isLeaves(iblockstate1, worldIn, blockpos1))
				{
					iblockstate1.getBlock().beginLeavesDecay(iblockstate1, worldIn, blockpos1);
				}
			}
		}
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}
	
	@Override
	public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public boolean isWood(IBlockAccess world, BlockPos pos) {
		return true;
	}

}
