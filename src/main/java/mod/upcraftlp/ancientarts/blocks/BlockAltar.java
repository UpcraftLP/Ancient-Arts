package mod.upcraftlp.ancientarts.blocks;

import core.upcraftlp.craftdev.API.templates.Block;
import mod.upcraftlp.ancientarts.blocks.tile.TileEntityAltar;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAltar extends Block implements ITileEntityProvider {

	public BlockAltar() {
		super("altar", Material.ROCK, true);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAltar();
	}

}
