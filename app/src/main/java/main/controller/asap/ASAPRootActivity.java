package main.controller.asap;

import net.sharksystem.asap.android.apps.ASAPActivity;

import main.controller.asap.rebuild.ASAPApplication;

class ASAPRootActivity extends ASAPActivity {
    public ASAPRootActivity() {
        super(ASAPApplication.getASAPApplication());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
