/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Model;

import SRFWF.Model.WFProcessConfig;

public class WFStartProcessConfig
extends WFProcessConfig {
    public static String TAG_WFSTART = "SRFEXWFSTART";

    public WFStartProcessConfig() {
        this.setObject("SRFWF.Ctrl.SRFWFDefaultProcess");
    }

    @Override
    public String getName() {
        return "START";
    }

    @Override
    public boolean isStartProcess() {
        return true;
    }
}

