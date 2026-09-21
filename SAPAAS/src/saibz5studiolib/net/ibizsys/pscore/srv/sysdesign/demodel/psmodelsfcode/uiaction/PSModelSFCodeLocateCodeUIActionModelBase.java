/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelsfcode.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelSFCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelSFCodeLocateCodeUIActionModelBase
extends DEUIActionModelBase<PSModelSFCode> {
    private static final Log log = LogFactory.getLog(PSModelSFCodeLocateCodeUIActionModelBase.class);

    public PSModelSFCodeLocateCodeUIActionModelBase() {
        this.setId("B72D3DA4-0F7E-470D-8E5A-85AFEA07BC14");
        this.setName("LocateCode");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("LocateCode");
    }
}

