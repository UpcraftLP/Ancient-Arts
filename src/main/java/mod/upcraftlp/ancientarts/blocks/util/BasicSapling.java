package mod.upcraftlp.ancientarts.blocks.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import core.upcraftlp.craftdev.API.structures.ITreeMapping;
import core.upcraftlp.craftdev.API.structures.TreeType;
import core.upcraftlp.craftdev.API.templates.Block;
import core.upcraftlp.craftdev.API.world.DecorationHelper;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public abstract class BasicSapling extends Block implements IGrowable, IPlantable {

	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	public static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	public static final List<net.minecraft.block.Block> SOIL = Arrays.asList(new net.minecraft.block.Block[]{Blocks.DIRT, Blocks.GRASS});
	
	public BasicSapling(String name) {
		super("sapling_" + name, Material.PLANTS, true);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
		this.setDefaultState(this.getDefaultState().withProperty(STAGE, 0));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{STAGE});
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) && SOIL.contains(worldIn.getBlockState(pos.down()).getBlock());
	}
	
	private void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
		if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }
	
	@SuppressWarnings("deprecation")
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, net.minecraft.block.Block blockIn,
			BlockPos fromPos) {
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		this.checkAndDropBlock(worldIn, pos, state);
	}
	
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
		IBlockState soil = worldIn.getBlockState(pos.down());
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        {
            return soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
        }
        return SOIL.contains(soil);
    }
	
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE, meta);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(STAGE);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);
            this.checkAndDropBlock(worldIn, pos, state);
            if(worldIn.getBlockState(pos).getBlock() != this) return;
            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, rand, pos, state);
            }
        }
	}
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
        	DecorationHelper.generateTree(worldIn, pos, this.getTreeMapping(), this.getTreeType());
        }
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}
	
	@Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }

	private TreeType getTreeType() {
		return TreeType.NORMAL;
	}

	public abstract ITreeMapping getTreeMapping();
	
	

}
