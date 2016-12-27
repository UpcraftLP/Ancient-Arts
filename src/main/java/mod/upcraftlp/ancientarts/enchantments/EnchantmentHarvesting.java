package mod.upcraftlp.ancientarts.enchantments;

import mod.upcraftlp.ancientarts.init.AncientMisc;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentHarvesting extends Enchantment {

	private static final String NAME = "harvesting";
	
	public EnchantmentHarvesting() {
		super(Rarity.UNCOMMON, AncientMisc.Enchantments.ENUM_HOE, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
		this.setName(NAME);
		this.setRegistryName(NAME);
		this.type = AncientMisc.Enchantments.ENUM_HOE;
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 0;
	}
	
}
