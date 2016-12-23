package mod.upcraftlp.ancientarts.items;

import mod.upcraftlp.ancientarts.items.util.ItemOrb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemFireOrb extends ItemOrb {

	public ItemFireOrb() {
		super("fire");
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(worldIn.isRemote) return;
		if(entityIn.isBurning()) entityIn.extinguish();
		if(entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 20));
		}
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(facing != EnumFacing.UP) return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		if(!worldIn.isRemote) {
			worldIn.setBlockState(pos.up(), Blocks.FIRE.getDefaultState());
			player.getHeldItem(hand).damageItem(1, player);
		}
		return EnumActionResult.SUCCESS;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote) {
			Vec3d lookVec = playerIn.getLookVec();
			EntityLargeFireball fireBall = new EntityLargeFireball(worldIn, playerIn, lookVec.xCoord, lookVec.yCoord, lookVec.zCoord) {
				
				@Override
				protected void onImpact(RayTraceResult result) {
					if(result.entityHit != null && result.entityHit == this.shootingEntity) return;
					BlockPos pos = result.getBlockPos() != null ? result.getBlockPos() : this.getPosition();
					this.world.createExplosion(this.shootingEntity, pos.getX(), pos.getY(), pos.getZ(), 3.5f, true);
					this.setDead();
				}
			};
			fireBall.setRotationYawHead(playerIn.cameraYaw);
			worldIn.spawnEntity(fireBall);
			stack.damageItem(1, playerIn);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

}
