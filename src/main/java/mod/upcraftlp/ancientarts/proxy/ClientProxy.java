package mod.upcraftlp.ancientarts.proxy;

import core.upcraftlp.craftdev.API.common.ModRegistry;
import mod.upcraftlp.ancientarts.init.AncientBlocks;
import mod.upcraftlp.ancientarts.init.AncientItems;
import mod.upcraftlp.ancientarts.init.AncientTabs;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModRegistry.registerBlockRenders(AncientBlocks.blockMap);
		AncientItems.postInit();
		ModRegistry.registerItemRenders(AncientItems.itemMap);
		AncientTabs.setIcons();
		//FIXME Check for offline player and crash!
		/**mcmod.info**/
		ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		//TODO: metadata!
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
