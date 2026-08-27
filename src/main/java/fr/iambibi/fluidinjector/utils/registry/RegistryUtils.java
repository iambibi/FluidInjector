package fr.iambibi.fluidinjector.utils.registry;

import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceKey;

import java.lang.reflect.Field;

public class RegistryUtils {

    private static final Field frozenField;
    static {
        try {
            frozenField = MappedRegistry.class.getDeclaredField("frozen");
            frozenField.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Impossible de localiser le champ 'frozen' sur MappedRegistry", e);
        }
    }

    public static void unfreeze(Object registry) {
        setFrozen(registry, false);
    }

    public static void freeze(Object registry) {
        setFrozen(registry, true);
    }

    private static void setFrozen(Object registry, boolean value) {
        try {
            frozenField.set(registry, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Impossible de modifier 'frozen' sur " + registry, e);
        }
    }

    public static <T> T injectWithoutFreezing(WritableRegistry<T> registry, ResourceKey<T> key, T value) {
        return Registry.register(registry, key, value);
    }
}
