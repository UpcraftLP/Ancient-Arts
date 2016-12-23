package mod.upcraftlp.ancientarts.util.energy;

public interface ICrystalEnergyConsumer {

	/**
	 * 
	 * @param amount	the amount of energy to offer
	 * @param simulated	if this is a simulated access, don't change any values.
	 * @return the amount of energy that was accepted
	 */
	public long sendEnergy(long amount, boolean simulated);
}
