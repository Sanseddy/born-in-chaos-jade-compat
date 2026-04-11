package com.infected.jade;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.JadeRayTraceCallback;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.resources.ResourceLocation;

@WailaPlugin
public class InfectedOrePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        // No common registration needed
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        // Register ray trace callback to override infected ore blocks
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor == null) {
                return originalAccessor;
            }

            // Get the block being looked at
            net.minecraft.world.level.block.Block block = accessor.getBlock();
            if (block == null) {
                return accessor;
            }
            
            // Get the registry name of the block
            ResourceLocation registryName = net.minecraftforge.registries.ForgeRegistries.BLOCKS.getKey(block);
            if (registryName == null) {
                return accessor;
            }
            
            String blockNameStr = registryName.toString();

            // Check if it's infected diamond ore
            if (blockNameStr.equals("born_in_chaos_v1:infected_diamond_ore")) {
                return registration.blockAccessor()
                    .from(accessor)
                    .blockState(Blocks.DIAMOND_ORE.defaultBlockState())
                    .build();
            }

            // Check if it's infected deepslate diamond ore
            if (blockNameStr.equals("born_in_chaos_v1:infected_deepslate_diamond_ore")) {
                return registration.blockAccessor()
                    .from(accessor)
                    .blockState(Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())
                    .build();
            }

            return accessor;
        });
    }
}
