package mod.upcraftlp.ancientarts.world.dimension.lost;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class DimTeleporterLost extends Teleporter {

	
	public DimTeleporterLost(WorldServer worldIn) {
		super(worldIn);
	}
	
	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
		//TODO portal
//		 if (!this.placeInExistingPortal(entityIn, rotationYaw))
//         {
//             this.makePortal(entityIn);
//             this.placeInExistingPortal(entityIn, rotationYaw);
//         }
	}

}
