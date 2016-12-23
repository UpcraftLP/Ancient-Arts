package mod.upcraftlp.ancientarts.blocks.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandlerModifiable;

public abstract class TileBasicInventory extends TileEntity implements IItemHandlerModifiable {

	protected final NonNullList<ItemStack> inventory = NonNullList.withSize(getSlots(), ItemStack.EMPTY);
	private static final String KEY_INVENTORY = "inventory";
	
	public void clearInventory() {
		for(int i = 0; i < this.getSlots(); i++) {
			this.setStackInSlot(i, ItemStack.EMPTY);
		}
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory.get(slot);
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		ItemStack workStack = stack.copy();
		ItemStack slotStack = this.getStackInSlot(slot);
		if(this.canInsertStackToSlot(slot, workStack) && !workStack.isEmpty() && (slotStack.isEmpty() || ItemStack.areItemsEqual(workStack, slotStack))) {
			
			while(workStack.isEmpty() && slotStack.getCount() <= this.getSlotLimit(slot)) {
				slotStack.grow(1);
				workStack.shrink(1);
			}
			this.setStackInSlot(slot, slotStack);
		}
		return workStack;
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		if(!this.getStackInSlot(slot).isEmpty()) {
			ItemStack stack = this.getStackInSlot(slot).copy();
			ItemStack returnStack = stack.copy();
			int count = 0;
			while (amount > 0 && !stack.isEmpty()) {
				stack.shrink(1);
				count++;
				amount--;
			}
			returnStack.setCount(count);
			if(!simulate) this.setStackInSlot(slot, stack);
			return returnStack;
		}
		return ItemStack.EMPTY;
	}

	@Override
	public int getSlotLimit(int slot) {
		return 1;
	}

	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		inventory.set(slot, stack);
		this.markDirty();
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList nbtList = new NBTTagList();
		for(ItemStack stack : this.inventory) {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.writeToNBT(nbt);
			nbtList.appendTag(nbt);
		}
		compound.setTag(KEY_INVENTORY, nbtList);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if(compound.hasKey(KEY_INVENTORY)) {
			NBTTagList invList = compound.getTagList(KEY_INVENTORY, 9);
			for(int i = 0; i < invList.tagCount(); i++) {
				NBTTagCompound itemNBT = invList.getCompoundTagAt(i);
				ItemStack stack = new ItemStack(itemNBT);
				this.setStackInSlot(i, stack);
			}
		}
	}
	
	@Override
	public void markDirty() {
		this.updateContents();
		super.markDirty();
	}
	
	public boolean containsStack(ItemStack stack) {
		for(ItemStack invStack : this.inventory) {
			if(ItemStack.areItemsEqual(stack, invStack)) return true;
		}
		return false;
	}
	
	public abstract boolean canInsertStackToSlot(int slot, ItemStack stack);
	
	public abstract void updateContents();

}
