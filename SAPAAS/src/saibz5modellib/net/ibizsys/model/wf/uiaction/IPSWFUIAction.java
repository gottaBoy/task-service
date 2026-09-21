/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflowObject;

public interface IPSWFUIAction
extends IPSWorkflowObject,
IPSUIAction {
    public static final String UIACTIONTYPE_WFUIACTION = "WFUIACTION";

    public IPSWFVersion getPSWFVersion();

    public String getFrontPSDEViewId();
}

