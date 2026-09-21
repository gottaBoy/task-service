/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystestdata.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysTestDataInitModelUIActionModelBase
extends DEUIActionModelBase<PSSysTestData> {
    private static final Log log = LogFactory.getLog(PSSysTestDataInitModelUIActionModelBase.class);

    public PSSysTestDataInitModelUIActionModelBase() {
        this.setId("79A30D33-E4CC-4CAF-BB3B-050F3D29E0A1");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6570\u636e\u5b8c\u6210\uff01");
    }
}

