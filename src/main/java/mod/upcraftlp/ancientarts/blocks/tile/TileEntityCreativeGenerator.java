package mod.upcraftlp.ancientarts.blocks.tile;

import mod.upcraftlp.ancientarts.util.energy.ICrystalEnergyProvider;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCreativeGenerator extends TileEntity implements ICrystalEnergyProvider {

	@Override
	public long requestEnergy(long requestedAmount, boolean simulated) {
		return requestedAmount;
	}

}
