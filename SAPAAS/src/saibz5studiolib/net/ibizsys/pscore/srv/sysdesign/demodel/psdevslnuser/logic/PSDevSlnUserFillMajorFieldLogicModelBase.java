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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnuser.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnUserFillMajorFieldLogicModelBase
extends DELogicModelBase<PSDevSlnUser> {
    private static final Log log = LogFactory.getLog(PSDevSlnUserFillMajorFieldLogicModelBase.class);

    public PSDevSlnUserFillMajorFieldLogicModelBase() {
        this.setId("499E69C5-3916-402D-A411-40A977090EE5");
        this.setName("FillMajorField");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDevSlnUser pSDevSlnUser = (PSDevSlnUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executeprepareparam1(iActionContext);
    }

    protected void executeprepareparam1(IActionContext iActionContext) throws Exception {
        PSDevSlnUser pSDevSlnUser = (PSDevSlnUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDevSlnUser.set("PSDEVSLNUSERNAME", pSDevSlnUser.get("PSDEVUSEROBJNAME"));
    }
}

