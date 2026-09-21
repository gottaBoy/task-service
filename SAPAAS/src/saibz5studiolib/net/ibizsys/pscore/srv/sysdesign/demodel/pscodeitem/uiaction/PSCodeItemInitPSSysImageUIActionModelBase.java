/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pscodeitem.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSCodeItemInitPSSysImageUIActionModelBase
extends DEUIActionModelBase<PSCodeItem> {
    private static final Log log = LogFactory.getLog(PSCodeItemInitPSSysImageUIActionModelBase.class);

    public PSCodeItemInitPSSysImageUIActionModelBase() {
        this.setId("F595E64F-F24E-4CD9-911A-385B51CF9307");
        this.setName("InitPSSysImage");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitPSSysImage");
        this.setReloadData(true);
    }
}

