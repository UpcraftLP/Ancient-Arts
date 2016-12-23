package mod.upcraftlp.ancientarts.items;

import java.util.List;

import core.upcraftlp.craftdev.API.templates.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;

public class ItemCrystalInfused extends Item {

	public static final String KEY_INFUSED = "infused";
	
	public ItemCrystalInfused() {
		super("crystal_infused");
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		if(stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if(nbt.hasKey(KEY_INFUSED)) {
				tooltip.add(TextFormatting.BOLD + "Infused with:");
				String infusedDecrypted = nbt.getString(KEY_INFUSED);
				for(String s : infusedDecrypted.split("-")) {
					String info = s.substring(0, 1).toUpperCase() + s.substring(1);
					tooltip.add(info);
				}
			}
		}
	}

}
