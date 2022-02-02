package com.techelevator.farm;

/**
 * This is the interface that allows us to sing about things on the farm.
 * The things we sing about need a name and a sound.
 */
public interface Singable {

    // ALL methods in an interface are by default public & abstract
    // You don't *have* to say it, but I think you should until you just *know* and remember this
    // It's a good reminder for right now

    /**
     * @return the Singable's name
     */
    public abstract String getName();

    /**
     * @return the Singable's sound (in words)
     */
    public abstract String getSound();

}
