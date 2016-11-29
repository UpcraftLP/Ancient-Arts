package mod.upcraftlp.ancientarts;

import java.time.Year;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeVersion;

public class Reference {

	public static final String MCVERSIONS = "1.11";
	public static final String VERSION = "0.1.0";
	
	/** TEAM **/
	public static final String[] authors = {"UpcraftLP"};
	public static final String MOD_DESCRIPTION = "Ancient Arts" + ForgeVersion.mcVersion;
	public static final String CREDITS = TextFormatting.GOLD + "\u00A9" + Year.now().getValue() + " " + authors[0];
	
	//DO NOT CHANGE!!!
	public static final String MODNAME = "Ancient Arts";
	public static final String MODID = "ancientarts";
	public static final String DEPENDENCIES = "required-after:craftdevcore";
	public static final String UPDATE_URL = ""; //TODO: CurseForge page!
	public static final String UPDATE_JSON = ""; //TODO: Version File
	public static final String CLIENTSIDE_PATH = "mod.upcraftlp." + MODID + ".proxy.ClientProxy";
	public static final String SERVERSIDE_PATH = "mod.upcraftlp." + MODID + ".proxy.ServerProxy";
	public static final String ID_PREFIX = MODID + ":";
	public static final String GUI_FACTORY = "mod.upcraftlp." + MODID + ".init.AncientConfigGuiFactory";

}
