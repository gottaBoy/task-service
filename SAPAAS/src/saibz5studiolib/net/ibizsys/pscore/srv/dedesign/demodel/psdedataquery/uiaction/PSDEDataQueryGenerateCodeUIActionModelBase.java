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

public abstract class PSDEDataQueryGenerateCodeUIActionModelBase
extends DEUIActionModelBase<PSDEDataQuery> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryGenerateCodeUIActionModelBase.class);

    public PSDEDataQueryGenerateCodeUIActionModelBase() {
        this.setId("2F622945-07B7-4A09-A863-7768C901E460");
        this.setName("GenerateCode");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_GENERATECODE");
        this.setReloadData(true);
        this.setSuccessMsg("\u751f\u6210\u4ee3\u7801\u5b8c\u6210\uff01");
    }
}

