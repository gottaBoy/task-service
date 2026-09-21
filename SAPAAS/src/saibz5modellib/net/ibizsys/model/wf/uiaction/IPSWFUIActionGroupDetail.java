/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.view.IPSUIActionGroupDetail;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;

public interface IPSWFUIActionGroupDetail
extends IPSUIActionGroupDetail {
    public IPSWFUIActionGroup getPSWFUIActionGroup();

    public IPSWFUIAction getPSWFUIAction();
}

