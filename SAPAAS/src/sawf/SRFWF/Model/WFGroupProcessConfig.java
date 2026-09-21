/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Model;

import SRFWF.Ctrl.SRFWFGroupProcess;
import SRFWF.Model.WFEmbedProcessesConfig;
import SRFWF.Model.WFProcessConfig;

public class WFGroupProcessConfig
extends WFProcessConfig {
    public static String TAG_WFGROUPPROCESS = "SRFEXWFGROUPPROCESS";
    protected WFEmbedProcessesConfig wfProcessesConfig = new WFEmbedProcessesConfig(this);

    public WFGroupProcessConfig() {
        this.setObject(SRFWFGroupProcess.class.getName());
    }

    public WFEmbedProcessesConfig getEmbedProcessesConfig() {
        return this.wfProcessesConfig;
    }
}

