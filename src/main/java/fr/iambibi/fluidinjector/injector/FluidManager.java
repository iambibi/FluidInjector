package fr.iambibi.fluidinjector.injector;

import fr.iambibi.fluidinjector.FluidInjectorPlugin;
import fr.iambibi.fluidinjector.content.CustomFluid;
import fr.iambibi.fluidinjector.utils.registry.RegistryUtils;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import java.util.List;

public class FluidManager {

    private final FluidInjectorPlugin plugin;
    private final List<CustomFluid> customFluids;

    public FluidManager(FluidInjectorPlugin plugin, List<CustomFluid> customFluids) {
        this.plugin = plugin;
        this.customFluids = customFluids;
    }

    public void injectCustomLiquids() {
        try {
            RegistryUtils.unfreeze(BuiltInRegistries.FLUID);

            for (CustomFluid customFluid : customFluids) {

                ResourceKey<Fluid> key = ResourceKey.create(Registries.FLUID, customFluid.getFluidID());

                Fluid fluid = RegistryUtils.injectWithoutFreezing(
                        (WritableRegistry<Fluid>) BuiltInRegistries.FLUID,
                        key,
                        customFluid
                );
            }


        } finally {
            RegistryUtils.freeze(BuiltInRegistries.FLUID);
        }
    }

}
