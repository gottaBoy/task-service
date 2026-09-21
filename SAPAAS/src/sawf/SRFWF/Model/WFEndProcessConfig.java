/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Model;

import SRFWF.Model.WFBaseProcessConfig;

public class WFEndProcessConfig
extends WFBaseProcessConfig {
    public static String TAG_WFEND = "SRFEXWFEND";

    public WFEndProcessConfig() {
        this.setObject("SRFWF.Ctrl.SRFWFDefaultProcess");
    }

    @Override
    public boolean isTerminalProcess() {
        return true;
    }
}

