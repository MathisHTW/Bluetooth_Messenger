package main.modell.storage;

import java.util.List;

import main.modell.data.IChannel;

interface IStorageChannel {

    /**
     * Add new Channel
     *
     * @param iChannel
     */
    void addChannelList(IChannel iChannel);

    /**
     * Add new List<IChannel>
     *
     * @param list
     */
    void addAllChannelList(List<IChannel> list);

    /**
     * Get list of Channel
     *
     * @return list
     */
    List<IChannel> getChannelList();

    /**
     * Remove Channel by Name
     *
     * @param name
     */
    void removeChannel(String name);
}
