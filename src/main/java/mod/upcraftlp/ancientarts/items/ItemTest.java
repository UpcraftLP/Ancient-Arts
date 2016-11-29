package mod.upcraftlp.ancientarts.items;

import core.upcraftlp.craftdev.API.templates.Item;
import mod.upcraftlp.ancientarts.init.AncientConfig;
import mod.upcraftlp.ancientarts.world.dimension.dream.DimTeleporterDream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class ItemTest extends Item {

	public ItemTest() {
		super("test");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(playerIn instanceof EntityPlayerMP) {
			int dimID = AncientConfig.dimIdDream;
			if(playerIn.dimension == dimID) dimID = 0;
			playerIn.getServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn, dimID, new DimTeleporterDream(DimensionManager.getWorld(dimID)));
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

}
