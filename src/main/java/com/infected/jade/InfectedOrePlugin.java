package com.infected.jade;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public final class InfectedOrePlugin implements IWailaPlugin {
    private static final ResourceLocation INFECTED_DIAMOND_ORE =
            ResourceLocation.fromNamespaceAndPath("born_in_chaos_v1", "infected_diamond_ore");
    private static final ResourceLocation INFECTED_DEEPSLATE_DIAMOND_ORE =
            ResourceLocation.fromNamespaceAndPath("born_in_chaos_v1", "infected_deepslate_diamond_ore");

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (!(accessor instanceof BlockAccessor blockAccessor)) {
                return accessor == null ? originalAccessor : accessor;
            }

            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(blockAccessor.getBlock());
            if (INFECTED_DIAMOND_ORE.equals(blockId)) {
                return registration.blockAccessor()
                        .from(blockAccessor)
                        .blockState(Blocks.DIAMOND_ORE.defaultBlockState())
                        .build();
            }
            if (INFECTED_DEEPSLATE_DIAMOND_ORE.equals(blockId)) {
                return registration.blockAccessor()
                        .from(blockAccessor)
                        .blockState(Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
                        .build();
            }

            return accessor;
        });
    }
}
