package snownee.jade.api;

public interface IWailaClientRegistration {
    void addRayTraceCallback(JadeRayTraceCallback callback);
    
    BlockAccessorBuilder blockAccessor();
    
    interface BlockAccessorBuilder {
        BlockAccessorBuilder from(BlockAccessor accessor);
        BlockAccessorBuilder blockState(net.minecraft.world.level.block.state.BlockState state);
        BlockAccessor build();
    }
}
