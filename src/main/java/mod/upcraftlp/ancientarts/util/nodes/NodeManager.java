package mod.upcraftlp.ancientarts.util.nodes;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mod.upcraftlp.ancientarts.util.energy.ICrystalEnergyBuffer;
import mod.upcraftlp.ancientarts.util.energy.ICrystalEnergyConsumer;
import mod.upcraftlp.ancientarts.util.energy.ICrystalEnergyProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NodeManager {

	static {
		managers = new HashMap<Integer, NodeManager>();
	}
	
	protected static final Map<Integer, NodeManager> managers;
	
	public NodeManager get(int ID) {
		if(!managers.containsKey(ID)) managers.put(ID, new NodeManager());
		return managers.get(ID);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	public NodeManager() {
		nodes = new ArrayList<NodeRegistryEntry>();
	}
	
	private static List<NodeRegistryEntry> nodes;
	
	
	public static void registerNode(AbstractNode node) {
		nodes.add(new NodeRegistryEntry(node));
	}
	
	public static class NodeRegistryEntry {
		
		private final WeakReference<AbstractNode> NODE;
		
		public NodeRegistryEntry(AbstractNode node) {
			this.NODE = new WeakReference<AbstractNode>(node);
			World w = node.getWorld();
			BlockPos posDown = node.getPos().down();
			if(w.getTileEntity(posDown) != null) {
				TileEntity te = w.getTileEntity(posDown);
				if(te instanceof ICrystalEnergyConsumer) {
					
				}
				if(te instanceof ICrystalEnergyProvider) {
					
				}
				if(te instanceof ICrystalEnergyBuffer) {
					
				}
				
			}
		}
		
		public AbstractNode get() { 
			return this.NODE.get();
		}
		
		public ICrystalEnergyConsumer getConsumer() {
			//TODO  //FIXME
			return null;
		}
	}
}
