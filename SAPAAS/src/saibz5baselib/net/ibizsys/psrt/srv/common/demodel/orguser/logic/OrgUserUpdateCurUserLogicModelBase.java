/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class OrgUserUpdateCurUserLogicModelBase
extends DELogicModelBase<OrgUser> {
    private static final Log log = LogFactory.getLog(OrgUserUpdateCurUserLogicModelBase.class);

    public OrgUserUpdateCurUserLogicModelBase() {
        this.setId("8C4864F8-2AAD-4202-962C-001B03B4D30B");
        this.setName("UpdateCurUser");
        this.setDefaultParamName("Default");
    }

    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(OrgUserService.class, sessionFactory);
        service.executeAction("UPDATE", _default);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        _default.set("orguserid", WebContext.getCurrent().getSessionValue("SRFPERSONID"));
        this.executeDeaction1(iActionContext);
    }
}

