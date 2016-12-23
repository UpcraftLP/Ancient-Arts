package mod.upcraftlp.ancientarts.blocks.tile;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

public class TileEntityAltar extends TileBasicInventory implements ITickable {

	private static final int INFUSION_TICKS_DEFAULT = 100;
	private int infusionTicks = 0;
	
	@Override
	public int getSlots() {
		return 8;
	}

	@Override
	public boolean canInsertStackToSlot(int slot, ItemStack stack) {
		return true;
	}

	@Override
	public void updateContents() {
		if(this.containsStack(new ItemStack(Items.APPLE)));
		this.clearInventory();
	}

	@Override
	public void update() {
		if(this.infusionTicks > 0) {
			if(--this.infusionTicks == 0) {
				
			}
		}
		
	}
	
}
