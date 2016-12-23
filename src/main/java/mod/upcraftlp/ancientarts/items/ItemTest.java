package mod.upcraftlp.ancientarts.items;

import core.upcraftlp.craftdev.API.templates.Item;
import mod.upcraftlp.ancientarts.init.AncientConfig;
import mod.upcraftlp.ancientarts.world.dimension.lost.DimTeleporterLost;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ItemTest extends Item {

	public ItemTest() {
		super("test");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(playerIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) playerIn;
			int dimID = AncientConfig.dimIdDream;
			if(playerIn.dimension == dimID) dimID = 0;
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			server.getPlayerList().transferPlayerToDimension(player, dimID, new DimTeleporterLost(server.worldServerForDimension(dimID)));
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

}
