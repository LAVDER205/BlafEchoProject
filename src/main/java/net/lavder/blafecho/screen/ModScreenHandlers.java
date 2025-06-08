package net.lavder.blafecho.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.lavder.blafecho.BlafEcho;
import net.lavder.blafecho.screen.custom.GrowthChamberScreenHandler;
import net.lavder.blafecho.screen.custom.PedestalScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BlafEcho.MOD_ID, "pedestal_screen_handler"),
                    new ExtendedScreenHandlerType<>(PedestalScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<GrowthChamberScreenHandler> GROWTH_CHAMBER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BlafEcho.MOD_ID, "growth_chamber_screen_handler"),
                    new ExtendedScreenHandlerType<>(GrowthChamberScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandler() {
        BlafEcho.LOGGER.info("Registering Screen Handlers for " + BlafEcho.MOD_ID);
    }
}
