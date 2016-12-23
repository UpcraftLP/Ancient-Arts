package mod.upcraftlp.ancientarts.util.nodes;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import mod.upcraftlp.ancientarts.util.energy.ICrystalEnergyConsumer;
import mod.upcraftlp.ancientarts.util.energy.ICrystalEnergyProvider;
import net.minecraft.tileentity.TileEntity;

public abstract class AbstractNode extends TileEntity implements ICrystalEnergyConsumer, ICrystalEnergyProvider {

	private List<WeakReference<ICrystalEnergyProvider>> connectedProviders;
	private List<WeakReference<ICrystalEnergyConsumer>> connectedConsumers;
	private List<AbstractNode> connectedNodes;
	
	@Override
	public long requestEnergy(long requestedAmount, boolean simulated) {
		long gainedEnergy = 0L;
		for(WeakReference<ICrystalEnergyProvider> ref : this.connectedProviders) {
			ICrystalEnergyProvider provider = ref.get();
			gainedEnergy += provider.requestEnergy(requestedAmount, simulated);
			requestedAmount -=  gainedEnergy;
			if(requestedAmount == 0) return gainedEnergy;
		}
		return gainedEnergy;
	}
	
	@Override
	public long sendEnergy(long amount, boolean simulated) {
		long acceptedEnergy = 0L;
		for(WeakReference<ICrystalEnergyConsumer> ref : this.connectedConsumers) {
			ICrystalEnergyConsumer consumer = ref.get();
			acceptedEnergy  += consumer.sendEnergy(amount, simulated);
			amount -= acceptedEnergy;
			if(amount == 0) return  acceptedEnergy;
		}
		return acceptedEnergy;
	}
	
	public void updateConnectionsRecursively() {
		//TODO
	}
	
	public List<AbstractNode> getConnectedNodes(List<AbstractNode> startNodes) {
		List<AbstractNode> nodes = new ArrayList<AbstractNode>();
		nodes.add(this);
		nodes.addAll(startNodes);
		for(AbstractNode node : this.connectedNodes) {
			if(!nodes.contains(node)) {
				nodes.addAll(node.getConnectedNodes(nodes));
			}
		}
		return nodes;
	}
	
}
