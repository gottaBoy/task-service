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

@DEDataSet(id="40E6DE90-E4B6-4269-8F48-8E03A1DA2308", name="CurSysDEDataImport", queries={@DEDataSetQuery(queryid="40E6DE90-E4B6-4269-8F48-8E03A1DA2308", queryname="CurSysDEDataImport")})
public abstract class PSSysPFPluginCurSysDEDataImportDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysDEDataImportDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysDEDataImportDSModelBase.class);
    }
}

