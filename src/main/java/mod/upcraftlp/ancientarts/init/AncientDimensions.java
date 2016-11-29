package mod.upcraftlp.ancientarts.init;

import mod.upcraftlp.ancientarts.world.dimension.dream.WorldProviderDream;
import mod.upcraftlp.ancientarts.world.dimension.lost.WorldProviderLost;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class AncientDimensions {

	public static DimensionType DREAM;
	public static DimensionType LOST;
	
	public static void init() {
		DREAM = DimensionType.register("Dream", "_dream", AncientConfig.dimIdDream, WorldProviderDream.class, false);
		LOST = DimensionType.register("Lost", "_lost", AncientConfig.dimIdLost, WorldProviderLost.class, false);
		
		registerDimension(DREAM);
		registerDimension(LOST);
	}
	
	public static void registerDimension(DimensionType dimension) {
		DimensionManager.registerDimension(dimension.getId(), dimension);
	}
}
