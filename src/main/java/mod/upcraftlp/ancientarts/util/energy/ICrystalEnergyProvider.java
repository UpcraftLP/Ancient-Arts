package mod.upcraftlp.ancientarts.util.energy;

public interface ICrystalEnergyProvider {

	/**
	 * Tries to receive energy from the producer
	 * @param amount	the requested amount
	 * @param simulated	don't actually change anything if this is a simulation
	 * @return the amount of power that the consumer provides
	 */
	public long requestEnergy(long requestedAmount, boolean simulated);
}
