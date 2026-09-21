/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelRT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelRTfillADViewRVsLogicModelBase
extends DELogicModelBase<PSModelRT> {
    private static final Log log = LogFactory.getLog(PSModelRTfillADViewRVsLogicModelBase.class);

    public PSModelRTfillADViewRVsLogicModelBase() {
        this.setId("631380A6-DA72-46EC-8860-748953E16956");
        this.setName("fillADViewRVs");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSModelRT pSModelRT = (PSModelRT)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
    }
}

