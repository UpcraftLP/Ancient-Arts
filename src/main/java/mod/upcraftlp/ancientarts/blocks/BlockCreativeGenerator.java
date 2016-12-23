package mod.upcraftlp.ancientarts.blocks;

import core.upcraftlp.craftdev.API.templates.Block;
import mod.upcraftlp.ancientarts.blocks.tile.TileEntityCreativeGenerator;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeGenerator extends Block implements ITileEntityProvider  {

	public BlockCreativeGenerator() {
		super("creative_generator", Material.BARRIER, true);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCreativeGenerator();
	}

}
