package main.modell.storage;

import android.util.Log;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import main.modell.data.IChannel;

class StorageChannel implements IStorageChannel, Serializable {

    private List<IChannel> channelList;

    public StorageChannel(List<IChannel> channelList) {
        this.channelList = channelList;
    }

    @Override
    public void addChannelList(IChannel iChannel) {
        Log.d("Storage", "Add new Channel size: " + this.channelList.size());
        this.channelList.add(iChannel);
    }

    @Override
    public void addAllChannelList(List<IChannel> list) {
        this.channelList.addAll(list);
    }

    @Override
    public List<IChannel> getChannelList() {
        Log.d("Storage", "Channelsize: " + this.channelList.size());
        return this.channelList;
    }

    @Override
    public void removeChannel(String name) {
        IChannel removeChannel = null;

        for (IChannel iChannel : this.channelList) {
            if (iChannel.getName().compareTo(name) == 0) {
                removeChannel = iChannel;
            }
        }
        this.channelList.remove(removeChannel);
        Log.d("Storage", "Remove Channel size: " + this.channelList.size());
    }

    @Override
    public String toString() {
        return "StorageChannel{" +
                "channelList=" + Arrays.toString(channelList.toArray()) +
                '}';
    }
}
