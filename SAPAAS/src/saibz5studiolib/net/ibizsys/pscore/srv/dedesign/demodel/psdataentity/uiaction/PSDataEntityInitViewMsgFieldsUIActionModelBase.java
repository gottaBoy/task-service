/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdataentity.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDataEntityInitViewMsgFieldsUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityInitViewMsgFieldsUIActionModelBase.class);

    public PSDataEntityInitViewMsgFieldsUIActionModelBase() {
        this.setId("5CCDB182-AC67-4E8D-B866-938599E36FDD");
        this.setName("InitViewMsgFields");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitViewMsgFields");
        this.setSuccessMsg("\u521d\u59cb\u5316\u89c6\u56fe\u6d88\u606f\u5c5e\u6027\u5b8c\u6210\uff01");
    }
}

