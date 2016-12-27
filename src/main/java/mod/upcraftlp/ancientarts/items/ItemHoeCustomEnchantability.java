package mod.upcraftlp.ancientarts.items;

import net.minecraft.item.ItemHoe;

public class ItemHoeCustomEnchantability extends ItemHoe {

	public ItemHoeCustomEnchantability(ToolMaterial material) {
		super(material);
		String matName = material.name().toLowerCase();
		String name = "hoe" + matName.substring(0, 1).toUpperCase() + matName.substring(1);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	//see net.minecraft.item.ItemTool
	@Override
	public int getItemEnchantability() {
		return this.theToolMaterial.getEnchantability();
	}

}
