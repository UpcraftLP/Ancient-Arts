package mod.upcraftlp.ancientarts.init;

import java.util.Set;

import mod.upcraftlp.ancientarts.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class AncientConfigGuiFactory implements IModGuiFactory {
	
	@Override
	public void initialize(Minecraft minecraftInstance) {}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return AncientConfigGUI.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}
	
	public static class AncientConfigGUI extends GuiConfig {
		
		public AncientConfigGUI(GuiScreen parent) {
		    super(parent, AncientConfig.getEntries(),
		        Reference.MODID, false, false, I18n.format("config." + Reference.MODID + ".name"));
		  }
	}
	
}


