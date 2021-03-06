package main.controller.asap;

import android.app.Activity;

import net.sharksystem.asap.ASAP;

import java.util.ArrayList;
import java.util.Collection;

public class BTApplication extends net.sharksystem.asap.android.apps.ASAPApplication {
    public static final String ASAP_Messenger = "ASAP_MESSENGER";
    private CharSequence id;
    static BTApplication instance;

    protected BTApplication(Collection<CharSequence> supportedFormats, Activity initialActivity) {
        super(supportedFormats, initialActivity);
        this.id = ASAP.createUniqueID();
    }

    /**
     * ASAP access
     * Source: https://github.com/SharedKnowledge/ASAPAndroid/blob/7cec8ba190acd859d848e07a584679022b9b8993/app/src/main/java/net/sharksystem/asap/android/example/ASAPExampleApplication.java#L11
     *
     * @param initialActivity
     * @return
     */
    public static BTApplication applicationInstance(Activity initialActivity) {
        if(BTApplication.instance == null) {
            Collection<CharSequence> formats = new ArrayList<>();
            formats.add(ASAP_Messenger);

            // create
            BTApplication.instance = new BTApplication(formats, initialActivity);

            // there could be some other steps. Setting up sub components. But there are non here.

            // launch
            BTApplication.instance.startASAPApplication();
        } // else - already initialized - nothing happens.

        return BTApplication.instance;
    }

    public static BTApplication getInstance() {
        return instance;
    }

    public CharSequence getOwnerID() {
        return this.id;
    }

}
