package main.controller.asap;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collection;

public class ASAPApplication extends net.sharksystem.asap.android.apps.ASAPApplication  {
    public static final String ASAP_Messenger = "ASAP_MESSENGER";
    private CharSequence id;
    static ASAPApplication instance;

    /**
     * ASAP access
     * Source: https://github.com/SharedKnowledge/ASAPAndroid/blob/7cec8ba190acd859d848e07a584679022b9b8993/app/src/main/java/net/sharksystem/asap/android/example/ASAPExampleApplication.java#L11
     * @param initialActivity
     * @return
     */
    public static ASAPApplication initializeASAPApplication(Activity initialActivity) {
        if(ASAPApplication.instance == null) {
            Collection<CharSequence> formats = new ArrayList<>();
            formats.add(ASAP_Messenger);

            // create
            ASAPApplication.instance = new ASAPApplication(formats, initialActivity);

            // there could be some other steps. Setting up sub components. But there are non here.
            // launch
            ASAPApplication.instance.startASAPApplication();
        } // else - already initialized - nothing happens.

        return ASAPApplication.instance;
    }

    protected ASAPApplication(Collection<CharSequence> supportedFormats, Activity initialActivity) {
        super(supportedFormats, initialActivity);
    }

    public CharSequence getOwnerID() {
        return this.id;
    }

}
