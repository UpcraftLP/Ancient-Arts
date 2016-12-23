package mod.upcraftlp.ancientarts.items.util;

import core.upcraftlp.craftdev.API.templates.Item;

public abstract class ItemOrb extends Item {

	public ItemOrb(String name) {
		super("orb_" + name);
		this.setMaxStackSize(1);
	}

}
