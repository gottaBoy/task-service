/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Model;

import SRFWF.Model.WFProcessConfig;

public class WFSuspendProcessConfig
extends WFProcessConfig {
    public static String TAG_WFSUSPENDPROCESS = "SRFEXWFSUSPENDPPROCESS";

    @Override
    public boolean isSuspendProcess() {
        return true;
    }
}

