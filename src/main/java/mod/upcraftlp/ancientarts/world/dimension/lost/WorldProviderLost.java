package mod.upcraftlp.ancientarts.world.dimension.lost;

import mod.upcraftlp.ancientarts.init.AncientDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderLost extends WorldProvider {

	@Override
	public DimensionType getDimensionType() {
		return AncientDimensions.LOST;
	}
	
	@Override
	public IRenderHandler getCloudRenderer() {
		return null;
	}
	
	@Override
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.0D, 0.7D, 0.25D);
	}
	
	@Override
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		return new Vec3d(0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public Vec3d getCloudColor(float partialTicks) {
		return new Vec3d(0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public float getCloudHeight() {
		return this.getAverageGroundLevel() + 7.5F;
	}
	
	@Override
	public boolean doesWaterVaporize() {
		return true;
	}
	
	@Override
	public void calculateInitialWeather() {
		this.resetRainAndThunder();
		this.world.getWorldInfo().setRaining(false);
	}
	
	@Override
	public boolean canDoLightning(Chunk chunk) {
		return true;
	}
	
	@Override
	public float getSunBrightnessFactor(float par1) {
		return 0.0f;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		return DimensionType.OVERWORLD.getId();
	}
	
	@Override
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
	}
	
	@Override
	public boolean hasSkyLight() {
		return false;
	}
	
	@Override
	protected void generateLightBrightnessTable() {
		 for (int i = 0; i <= 12; ++i)
	     {
	         this.lightBrightnessTable[i] = 0.0F;
	     }
		 this.lightBrightnessTable[13] = 1.0f;
		 this.lightBrightnessTable[14] = 1.0f;
		 this.lightBrightnessTable[15] = 1.0f;
	}
	
}
