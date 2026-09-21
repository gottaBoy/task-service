/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pscodelist.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSCodeListInitModelUIActionModelBase
extends DEUIActionModelBase<PSCodeList> {
    private static final Log log = LogFactory.getLog(PSCodeListInitModelUIActionModelBase.class);

    public PSCodeListInitModelUIActionModelBase() {
        this.setId("7DB0B9AB-D4FE-4F95-8F70-927538DB234A");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u4ee3\u7801\u8868\u5b8c\u6210\uff01");
    }
}

