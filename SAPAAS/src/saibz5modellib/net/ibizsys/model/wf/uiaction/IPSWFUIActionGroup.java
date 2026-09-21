/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.wf.uiaction;

import java.util.Iterator;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflowObject;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetail;

public interface IPSWFUIActionGroup
extends IPSWorkflowObject,
IPSUIActionGroup {
    public IPSWFVersion getPSWFVersion();

    public Iterator<IPSWFUIAction> getPSWFUIActions();

    public Iterator<IPSWFUIActionGroupDetail> getPSWFUIActionGroupDetails();
}

