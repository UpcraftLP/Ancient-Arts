package mod.upcraftlp.ancientarts.items;

import mod.upcraftlp.ancientarts.items.util.ItemOrb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWaterOrb extends ItemOrb {

	public static int MAX_AIR  = 300;
	
	public ItemWaterOrb() {
		super("water");
		this.setMaxDamage(512);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(worldIn.isRemote) return;
		if(entityIn instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) entityIn;
			if(entity.isInWater() && entity.getAir()  < 5) {
				//TODO: respiration(enchantment)-sensitive!
				entity.setAir(MAX_AIR);
				stack.attemptDamageItem(1, itemRand);
				if(stack.getCount() <= 0) stack = null;
				entity.replaceItemInInventory(itemSlot, stack);
			}
		}
		
	}

}
