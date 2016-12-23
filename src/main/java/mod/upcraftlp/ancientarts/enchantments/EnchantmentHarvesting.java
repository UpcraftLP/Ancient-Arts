package mod.upcraftlp.ancientarts.enchantments;

import com.google.common.base.Predicate;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class EnchantmentHarvesting extends Enchantment {

	private static final String NAME = "harvesting";
	private static final EnumEnchantmentType ENUM = EnumHelper.addEnchantmentType(NAME, new Predicate<Item>() {

		@Override
		public boolean apply(Item input) {
			return input instanceof ItemHoe || input.getToolClasses(new ItemStack(input)).contains("hoe");
		}
		
	});;
	
	public EnchantmentHarvesting(Rarity rarityIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, getEnum(), slots);
		this.setName(NAME);
		this.setRegistryName(NAME);
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return !stack.isEmpty() && (stack.getItem() instanceof ItemHoe || stack.getItem().getToolClasses(stack).contains("hoe"));
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return canApply(stack);
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return false;
	}
	
	public static EnumEnchantmentType getEnum() {
		return ENUM;
	}
	
}
