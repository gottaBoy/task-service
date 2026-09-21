/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup
 *  net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetail
 */
package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroupDetail;

public interface IPSWFUIActionGroupDetailRuntime
extends IPSWFUIActionGroupDetail {
    public void init(IPSModelStorageContext var1, IPSWFUIActionGroup var2, PSDEUIActionGroupDetail var3) throws Exception;
}

