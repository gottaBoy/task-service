/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psctrlmsg.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="FD379997-8356-4D64-99FA-D29EB47B4A85", name="CurDEAll", queries={@DEDataSetQuery(queryid="2A0E1428-F5BF-4CBD-8C76-4AEECEE74137", queryname="CurDE"), @DEDataSetQuery(queryid="A539E9B1-9F64-4215-95DC-0AE46ED1D9BD", queryname="CurSys")})
public abstract class PSCtrlMsgCurDEAllDSModelBase
extends DEDataSetModelBase {
    public PSCtrlMsgCurDEAllDSModelBase() {
        this.initAnnotation(PSCtrlMsgCurDEAllDSModelBase.class);
    }
}

