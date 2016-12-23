package mod.upcraftlp.ancientarts.util.energy;

public interface ICrystalEnergyBuffer {

	/**
	 * 
	 * @return the maximum capacity of the buffer
	 */
	public long getEnergyCap();
	
	/**
	 * 
	 * @return the currently stored amount of energy
	 */
	public long getCurrentEnergy();
}
