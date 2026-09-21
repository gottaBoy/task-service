/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrlevent.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="a08660cb0f5d408d9d985cca03bf7c23", name="DEFAULT", queries={@DEDataSetQuery(queryid="FD493899-0027-4F3A-A7ED-E0CBA215EDFD", queryname="DEFAULT")})
public abstract class PSCtrlEventDefaultDSModelBase
extends DEDataSetModelBase {
    public PSCtrlEventDefaultDSModelBase() {
        this.initAnnotation(PSCtrlEventDefaultDSModelBase.class);
    }
}

