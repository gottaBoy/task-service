/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsysapp.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="2EB2E90D-6087-4A97-BCE5-59134F4A4CD0", name="CurUser", queries={@DEDataSetQuery(queryid="2EB2E90D-6087-4A97-BCE5-59134F4A4CD0", queryname="CurUser"), @DEDataSetQuery(queryid="BE8E430B-C781-4548-96B3-D4BA40D2D1CE", queryname="CurUser2"), @DEDataSetQuery(queryid="E467193D-B9AC-4587-9560-0DE2FD00F9C4", queryname="CurUser3"), @DEDataSetQuery(queryid="16F31EEE-95A7-40D1-8612-200257AD043D", queryname="CurUser4")})
public abstract class PSDevSlnSysAppCurUserDSModelBase
extends DEDataSetModelBase {
    public PSDevSlnSysAppCurUserDSModelBase() {
        this.initAnnotation(PSDevSlnSysAppCurUserDSModelBase.class);
    }
}

