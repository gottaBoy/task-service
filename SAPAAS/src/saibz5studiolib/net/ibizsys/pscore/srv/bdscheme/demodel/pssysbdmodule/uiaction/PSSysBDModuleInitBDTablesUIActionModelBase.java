/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdmodule.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysBDModuleInitBDTablesUIActionModelBase
extends DEUIActionModelBase<PSSysBDModule> {
    private static final Log log = LogFactory.getLog(PSSysBDModuleInitBDTablesUIActionModelBase.class);

    public PSSysBDModuleInitBDTablesUIActionModelBase() {
        this.setId("AA8826D0-BE3F-4566-A3CE-2F8BE393EA85");
        this.setName("InitBDTables");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitBDTables");
        this.setReloadData(true);
    }
}

