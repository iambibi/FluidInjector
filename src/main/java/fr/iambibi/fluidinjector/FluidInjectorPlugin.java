package fr.iambibi.fluidinjector;

import fr.iambibi.fluidinjector.content.CustomFluid;
import fr.iambibi.fluidinjector.content.fluid.AcidFluid;
import fr.iambibi.fluidinjector.injector.FluidManager;
import lombok.Getter;
import net.minecraft.core.registries.Registries;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class FluidInjectorPlugin extends JavaPlugin {

    @Getter
    private FluidManager fluidManager;

    private final List<CustomFluid> customFluids = new ArrayList<>(List.of(
            new AcidFluid()
    ));

    @Override
    public void onEnable() {
        fluidManager = new FluidManager(this, customFluids);

        getLogger().info("FluidInjectorPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FluidInjectorPlugin has been disabled!");
    }
}
