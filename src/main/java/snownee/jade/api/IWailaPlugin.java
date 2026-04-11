package snownee.jade.api;

public interface IWailaPlugin {
    void register(IWailaCommonRegistration registration);
    void registerClient(IWailaClientRegistration registration);
}
