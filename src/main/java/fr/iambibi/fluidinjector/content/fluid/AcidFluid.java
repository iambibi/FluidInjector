package fr.iambibi.fluidinjector.content.fluid;

import fr.iambibi.fluidinjector.content.CustomFluid;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class AcidFluid extends CustomFluid {
    @Override
    public Identifier getFluidID() {
        return Identifier.fromNamespaceAndPath("custom", "acid");
    }
}
