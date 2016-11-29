package mod.upcraftlp.ancientarts.blocks;

import core.upcraftlp.craftdev.API.templates.Block;
import mod.upcraftlp.ancientarts.init.AncientConfig;
import mod.upcraftlp.ancientarts.world.dimension.lost.DimTeleporterLost;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class BlockMirror extends Block {

	public static IProperty<EnumMirrorHalf> HALF = PropertyEnum.<EnumMirrorHalf>create("half", EnumMirrorHalf.class);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockMirror() {
		super("mirror", Material.GLASS, true);
		this.setDefaultState(this.getBlockState().getBaseState());
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) && super.canPlaceBlockAt(worldIn, pos.up());
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer, null);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if(state.getValue(HALF) == EnumMirrorHalf.LOWER) worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, state.getValue(HALF).getOpposite()).withProperty(FACING, state.getValue(FACING)));
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if(state.getValue(HALF) == EnumMirrorHalf.UPPER) worldIn.setBlockToAir(pos.down());
		else worldIn.setBlockToAir(pos.up());
	}
		
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn == null || entityIn.isDead) return;
		if(entityIn.isRiding()) entityIn.getRidingEntity().dismountRidingEntity();
		if(entityIn.isBeingRidden()) entityIn.dismountRidingEntity();
		if(entityIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) entityIn;
				int dimID = AncientConfig.dimIdLost;
				if(player.dimension == AncientConfig.dimIdLost) dimID = 0; //TODO: get last dim!
				
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setTag("pos", NBTUtil.createPosTag(player.getPosition()));
				nbt.setInteger("dim", player.dimension);
				player.getServer().getPlayerList().transferPlayerToDimension(player, dimID, new DimTeleporterLost(DimensionManager.getWorld(dimID)));
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.Plane.HORIZONTAL.facings()[meta & 0b0011];
		EnumMirrorHalf half = EnumMirrorHalf.byIndex(meta >>> 2);
		return this.getDefaultState().withProperty(FACING, facing).withProperty(HALF, half);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int facing = state.getValue(FACING).getHorizontalIndex();
		int half = state.getValue(HALF).index();
		return half << 2 | facing;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{FACING, HALF});
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	public static enum EnumMirrorHalf implements IStringSerializable
	{
		LOWER(0),
        UPPER(1);

	 	private int index;
	 	
	 	private EnumMirrorHalf(int index) {
	 		this.index = index;
		}
	 
        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == UPPER ? "upper" : "lower";
        }
        
        public int index() {
        	return this.index;
        }
        
        public static EnumMirrorHalf byIndex(int index) {
        	if(index == 1) return EnumMirrorHalf.UPPER;
        	return EnumMirrorHalf.LOWER;
        }
        
        public EnumMirrorHalf getOpposite() {
        	if(this == EnumMirrorHalf.UPPER) return EnumMirrorHalf.LOWER;
        	return EnumMirrorHalf.UPPER;
        }
	}

}
