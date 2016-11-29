package mod.upcraftlp.ancientarts.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.upcraftlp.ancientarts.blocks.BlockMirror;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class AncientBlocks {

	public static Map<Block, CreativeTabs> blockMap;
	
	public static Block MIRROR = new BlockMirror();
	
	public static void init() {
		blockMap = new HashMap<Block, CreativeTabs>();
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(MIRROR);
		for (Block block : blocks) {
			blockMap.put(block, AncientTabs.tabAncientArts);
		}
	}
	
	public static void registerRenders() {
		/**TESRs**/
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlayerLuckyBlock.class, new RenderPlayerLuckyBlock());
	}
}
