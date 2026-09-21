/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psctrllogicgroup.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="13D0BAB1-9258-45A8-A920-2D6B58EAA11E", name="CurDEAll", queries={@DEDataSetQuery(queryid="D23D6F41-BB48-41EF-BA2D-6312C358589B", queryname="CurDE"), @DEDataSetQuery(queryid="7B7BB4D5-39F3-4B4F-B398-C27E2DD9F376", queryname="CurSys")})
public abstract class PSCtrlLogicGroupCurDEAllDSModelBase
extends DEDataSetModelBase {
    public PSCtrlLogicGroupCurDEAllDSModelBase() {
        this.initAnnotation(PSCtrlLogicGroupCurDEAllDSModelBase.class);
    }
}

