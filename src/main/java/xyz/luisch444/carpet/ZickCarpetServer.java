package xyz.luisch444.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ZickCarpetServer implements CarpetExtension, ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("zick-carpet");
	public static final String compactName = "zick-carpet";

	@Override
	public String version() {
		return compactName;
	}

	public static void loadExtension() {
		CarpetServer.manageExtension(new ZickCarpetServer());
	}

	@Override
	public void onInitialize() {
		ZickCarpetServer.loadExtension();
	}

	@Override
	public void onGameStarted() {
		// let's /carpet handle our few simple settings
		CarpetServer.settingsManager.parseSettingsClass(ZickCarpetSettings.class);
	}

	@Override
	public void onServerLoaded(MinecraftServer server){
		server.reloadResources(Arrays.asList("vanilla"));
	}

	@Override
	public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
		//SignalCommand.register(dispatcher);
	}

}
