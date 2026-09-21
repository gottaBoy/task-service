/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="38F190BA-4271-43B6-9BEC-717F04BE008B", name="CurSysCustom", queries={@DEDataSetQuery(queryid="508B84CA-C951-4728-B1A0-BBBB959B5063", queryname="CurSysCustom")})
public abstract class PSSysPFPluginCurSysCustomDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysCustomDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysCustomDSModelBase.class);
    }
}

