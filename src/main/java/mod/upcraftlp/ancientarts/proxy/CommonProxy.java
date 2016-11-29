package mod.upcraftlp.ancientarts.proxy;

import core.upcraftlp.craftdev.API.common.ModRegistry;
import mod.upcraftlp.ancientarts.init.AncientBlocks;
import mod.upcraftlp.ancientarts.init.AncientConfig;
import mod.upcraftlp.ancientarts.init.AncientDimensions;
import mod.upcraftlp.ancientarts.init.AncientItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		AncientConfig.init(event);
		AncientBlocks.init();
		AncientItems.init();
		//FIXME:May change, test custom itemBlocks!
		ModRegistry.registerBlocks(AncientBlocks.blockMap);
		ModRegistry.registerItems(AncientItems.itemMap);
		AncientDimensions.init();
	}
	
	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
