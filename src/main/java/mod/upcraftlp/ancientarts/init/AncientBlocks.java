package mod.upcraftlp.ancientarts.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.upcraftlp.ancientarts.blocks.BlockDeadWoodLeaves;
import mod.upcraftlp.ancientarts.blocks.BlockDeadWoodLog;
import mod.upcraftlp.ancientarts.blocks.BlockDeadWoodPlanks;
import mod.upcraftlp.ancientarts.blocks.BlockDeadWoodSapling;
import mod.upcraftlp.ancientarts.blocks.BlockMirror;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class AncientBlocks {

	public static Map<Block, CreativeTabs> blockMap;
	
	public static Block MIRROR = new BlockMirror();
	public static Block DEADWOOD_LOG = new BlockDeadWoodLog();
	public static Block DEADWOOD_PLANKS = new BlockDeadWoodPlanks();
	public static Block DEADWOOD_LEAVES = new BlockDeadWoodLeaves();
	public static Block DEADWOOD_SAPLING = new BlockDeadWoodSapling();

	public static void init() {
		blockMap = new HashMap<Block, CreativeTabs>();
		List<Block> blocks = new ArrayList<Block>();
		blocks.add(MIRROR);
		blocks.add(DEADWOOD_LOG);
		blocks.add(DEADWOOD_PLANKS);
		blocks.add(DEADWOOD_LEAVES);
		blocks.add(DEADWOOD_SAPLING);
		
		for (Block block : blocks) {
			blockMap.put(block, AncientTabs.tabAncientArts);
		}
	}
	
	public static void registerRenders() {
		/**TESRs**/
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityclass, new RenderTileEntity());
	}
}
