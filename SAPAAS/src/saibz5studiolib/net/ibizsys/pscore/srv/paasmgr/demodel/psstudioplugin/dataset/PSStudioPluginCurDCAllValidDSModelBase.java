/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psstudioplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="2A128CF2-0271-4817-8C3F-7D80370E3C77", name="CurDCAllValid", queries={@DEDataSetQuery(queryid="C396ADB7-06D3-4080-A5F5-6B0F91E88D54", queryname="AllDCValid"), @DEDataSetQuery(queryid="CDB47FCD-3297-4BF1-B99E-4EED0248FAE3", queryname="CurDCValid")})
public abstract class PSStudioPluginCurDCAllValidDSModelBase
extends DEDataSetModelBase {
    public PSStudioPluginCurDCAllValidDSModelBase() {
        this.initAnnotation(PSStudioPluginCurDCAllValidDSModelBase.class);
    }
}

