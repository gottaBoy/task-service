/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfde.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSWFDEInitDEWFViewsUIActionModelBase
extends DEUIActionModelBase<PSWFDE> {
    private static final Log log = LogFactory.getLog(PSWFDEInitDEWFViewsUIActionModelBase.class);

    public PSWFDEInitDEWFViewsUIActionModelBase() {
        this.setId("20F1073D-8437-468E-9017-44CC2484AEB4");
        this.setName("InitDEWFViews");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitDEWFViews");
        this.setSuccessMsg("\u521d\u59cb\u5316\u5b9e\u4f53\u6d41\u7a0b\u89c6\u56fe\u6210\u529f\uff01");
    }
}

