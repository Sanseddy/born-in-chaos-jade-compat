package snownee.jade.api;

@FunctionalInterface
public interface JadeRayTraceCallback {
    BlockAccessor apply(Object hitResult, BlockAccessor accessor, BlockAccessor originalAccessor);
}
