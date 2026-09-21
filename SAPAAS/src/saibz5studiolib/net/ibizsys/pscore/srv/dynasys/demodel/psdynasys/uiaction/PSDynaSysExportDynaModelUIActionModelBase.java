/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynasys.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaSysExportDynaModelUIActionModelBase
extends DEUIActionModelBase<PSDynaSys> {
    private static final Log log = LogFactory.getLog(PSDynaSysExportDynaModelUIActionModelBase.class);

    public PSDynaSysExportDynaModelUIActionModelBase() {
        this.setId("C7634BE6-C33F-4D5E-83EE-71B16AFAF8BB");
        this.setName("ExportDynaModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("ExportDynaModel");
    }
}

