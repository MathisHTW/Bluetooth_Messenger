package main.controller.asap;

import net.sharksystem.asap.android.apps.ASAPActivity;
import net.sharksystem.asap.android.apps.ASAPApplication;

class ASAPRootActivity extends ASAPActivity {
    public ASAPRootActivity() {
        super(main.controller.asap.ASAPApplication.getASAPApplication());
    }
}
