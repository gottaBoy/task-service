/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psmodelpfcode.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSModelPFCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelPFCodeLocateCodeUIActionModelBase
extends DEUIActionModelBase<PSModelPFCode> {
    private static final Log log = LogFactory.getLog(PSModelPFCodeLocateCodeUIActionModelBase.class);

    public PSModelPFCodeLocateCodeUIActionModelBase() {
        this.setId("109ABED8-2798-4487-AB51-DE54953A2C8A");
        this.setName("LocateCode");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("LocateCode");
    }
}

