/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataquery.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEDataQueryPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSDEDataQuery> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryPreviewSaveUIActionModelBase.class);

    public PSDEDataQueryPreviewSaveUIActionModelBase() {
        this.setId("59B1D866-D045-44A9-B9E5-78E52F8A7535");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

