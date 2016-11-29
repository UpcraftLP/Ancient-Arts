package mod.upcraftlp.ancientarts.world.dimension.dream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DimTeleporterDream extends Teleporter {

	public DimTeleporterDream(WorldServer worldIn) {
		super(worldIn);
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
		if(entityIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) entityIn;
			player.connection.setPlayerLocation(player.posX, player.posY, player.posZ, entityIn.rotationYaw, entityIn.rotationPitch);
		}
		return true;
	}
	
	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
		
	}
	
	@Override
	public boolean makePortal(Entity entityIn) {
		return true;
	}

}
