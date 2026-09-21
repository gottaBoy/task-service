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
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class OrgUserUpdateRelatedInfoLogicModelBase
extends DELogicModelBase<OrgUser> {
    private static final Log log = LogFactory.getLog(OrgUserUpdateRelatedInfoLogicModelBase.class);

    public OrgUserUpdateRelatedInfoLogicModelBase() {
        this.setId("400C2976-7A46-4D3D-8708-3607CA4E1B9D");
        this.setName("UpdateRelatedInfo");
        this.setDefaultParamName("Default");
    }

    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("User", new User());
        this.executeBegin(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        User user = (User)iActionContext.getParam("User");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        user.set("USERID", _default.get("ORGUSERID"));
        user.set("USERNAME", _default.get("ORGUSERNAME"));
        user.set("VALIDFLAG", _default.get("VALIDFLAG"));
        this.executeDeaction1(iActionContext);
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        User user = (User)iActionContext.getParam("User");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(UserService.class, sessionFactory);
        service.executeAction("SAVE", user);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        User user = (User)iActionContext.getParam("User");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }
}

