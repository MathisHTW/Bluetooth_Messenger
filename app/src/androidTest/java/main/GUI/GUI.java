package main.GUI;

public interface GUI {
    //no inteface because GUI

    /*
    Use Cases:
        1 Channel öffnen:
          GUI: Name eingetragen, Join klicken:
          Logic to GUI: openChannel(Name)
          Model to Logic: setMyName(Name)
                return true to Logic
          Network to Logic: usedIds()
                return List of used Ids to Logic
          Logic calculates ID for this device
          Model to Logic: setMyID(id)
                return true to Logic
          Network/Model to Logic: openChannel(getMyName(),getMyID())
                return name and id of this device to Logic, to be sent by network
          return true to GUI

       2 response to new device:
            GUI: (im Channelscreen)
            Logic to Network: addContact(contactName, contactID)
                              addChannel(channelName, channelID)
            Model to Logic: addContact(contactName, contactID)
                            addChannel(channelName, channelID)
                return true to Logic
                return true to Logic
              return true to Network
              return true to Network
            wenn Device schon bekannt:
                nichts mehr
            wenn Device neu:
            Beobachter informiert GUI wenn sich etwas im Model geändert hat
            Network to Logic: respondToNewDevice(myName,myID)
                return true
            Logic to GUI:
                listChannels()
            Model to Logic: listOfChannels()
                return List of currently available channels to Logic
             return List of Channels to GUI
            GUI refreshes List of channels
        3 join Channel
            GUI: klickt auf Channel


     */
}
