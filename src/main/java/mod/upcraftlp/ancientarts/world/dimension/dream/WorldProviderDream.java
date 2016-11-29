package mod.upcraftlp.ancientarts.world.dimension.dream;

import mod.upcraftlp.ancientarts.init.AncientDimensions;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.BiomeProvider;

public class WorldProviderDream extends WorldProviderSurface {

	@Override
	public DimensionType getDimensionType() {
		return AncientDimensions.DREAM;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		return DimensionType.OVERWORLD.getId();
	}
	
	@Override
	public BiomeProvider getBiomeProvider() {
		// TODO Custom BiomeProvider
		return super.getBiomeProvider();
	}
	
}
