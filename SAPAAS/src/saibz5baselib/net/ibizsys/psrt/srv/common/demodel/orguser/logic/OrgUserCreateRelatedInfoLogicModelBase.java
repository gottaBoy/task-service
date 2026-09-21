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
import net.ibizsys.psrt.srv.common.entity.UserDict;
import net.ibizsys.psrt.srv.common.service.UserDictService;
import net.ibizsys.psrt.srv.common.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class OrgUserCreateRelatedInfoLogicModelBase
extends DELogicModelBase<OrgUser> {
    private static final Log log = LogFactory.getLog(OrgUserCreateRelatedInfoLogicModelBase.class);

    public OrgUserCreateRelatedInfoLogicModelBase() {
        this.setId("10923BA6-9FD1-427C-9046-8DEBB24710B0");
        this.setName("CreateRelatedInfo");
        this.setDefaultParamName("Default");
    }

    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("UserDict", new UserDict());
        iActionContext.setParam("User", new User());
        this.executeBegin(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        UserDict userDict = (UserDict)iActionContext.getParam("UserDict");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        User user = (User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        user.set("USERID", _default.get("ORGUSERID"));
        user.set("USERNAME", _default.get("ORGUSERNAME"));
        this.executeDeaction1(iActionContext);
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        UserDict userDict = (UserDict)iActionContext.getParam("UserDict");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        User user = (User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(UserService.class, sessionFactory);
        service.executeAction("CREATE", user);
    }

    protected void executeDeaction2(IActionContext iActionContext) throws Exception {
        UserDict userDict = (UserDict)iActionContext.getParam("UserDict");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        User user = (User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(UserDictService.class, sessionFactory);
        service.executeAction("CREATE", userDict);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        UserDict userDict = (UserDict)iActionContext.getParam("UserDict");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        User user = (User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
        this.executePrepareparam2(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        UserDict userDict = (UserDict)iActionContext.getParam("UserDict");
        OrgUser _default = (OrgUser)iActionContext.getParam("Default");
        User user = (User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        userDict.set("OWNERID", _default.get("ORGUSERID"));
        userDict.set("USERDICTID", _default.get("ORGUSERID"));
        userDict.set("USERDICTNAME", _default.get("ORGUSERNAME"));
        userDict.set("OWNERTYPE", "ORGUSER");
        this.executeDeaction2(iActionContext);
    }
}

