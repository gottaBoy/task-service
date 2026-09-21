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

public abstract class PSDEDataQueryCreateDEDataSetUIActionModelBase
extends DEUIActionModelBase<PSDEDataQuery> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCreateDEDataSetUIActionModelBase.class);

    public PSDEDataQueryCreateDEDataSetUIActionModelBase() {
        this.setId("7EAA1331-8AE7-446D-95E4-EAD1A692BA49");
        this.setName("CreateDEDataSet");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDEDataSet");
        this.setReloadData(true);
        this.setSuccessMsg("\u5efa\u7acb\u9ed8\u8ba4\u6570\u636e\u96c6\u5408\u6210\u529f\uff01");
    }
}

