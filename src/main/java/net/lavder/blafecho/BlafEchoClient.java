package net.lavder.blafecho;

import net.fabricmc.api.ClientModInitializer;
import net.lavder.blafecho.util.ModModelPredicates;

public class BlafEchoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        ModModelPredicates.registerModelPredicates();
    }
}
