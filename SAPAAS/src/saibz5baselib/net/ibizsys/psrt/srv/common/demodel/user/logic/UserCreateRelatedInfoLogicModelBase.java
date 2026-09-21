/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.common.demodel.user.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class UserCreateRelatedInfoLogicModelBase
extends DELogicModelBase<User> {
    private static final Log log = LogFactory.getLog(UserCreateRelatedInfoLogicModelBase.class);

    public UserCreateRelatedInfoLogicModelBase() {
        this.setId("F28C6146-4E62-4B48-A9AD-E37BC6855113");
        this.setName("CreateRelatedInfo");
        this.setDefaultParamName("Default");
    }

    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        iActionContext.setParam("WFUser", new WFUser());
        iActionContext.setParam("MsgAccount", new MsgAccount());
        this.executeBegin(iActionContext);
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        WFUser wFUser = (WFUser)iActionContext.getParam("WFUser");
        MsgAccount msgAccount = (MsgAccount)iActionContext.getParam("MsgAccount");
        User _default = (User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        msgAccount.set("MSGACCOUNTID", _default.get("USERID"));
        msgAccount.set("MSGACCOUNTNAME", _default.get("USERNAME"));
        msgAccount.set("ISLIST", "0");
        this.executeDeaction2(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        WFUser wFUser = (WFUser)iActionContext.getParam("WFUser");
        MsgAccount msgAccount = (MsgAccount)iActionContext.getParam("MsgAccount");
        User _default = (User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
        this.executePrepareparam2(iActionContext);
    }

    protected void executeDeaction2(IActionContext iActionContext) throws Exception {
        WFUser wFUser = (WFUser)iActionContext.getParam("WFUser");
        MsgAccount msgAccount = (MsgAccount)iActionContext.getParam("MsgAccount");
        User _default = (User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(MsgAccountService.class, sessionFactory);
        service.executeAction("SAVE", msgAccount);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        WFUser wFUser = (WFUser)iActionContext.getParam("WFUser");
        MsgAccount msgAccount = (MsgAccount)iActionContext.getParam("MsgAccount");
        User _default = (User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        wFUser.set("WFUSERID", _default.get("USERID"));
        wFUser.set("WFUSERNAME", _default.get("USERNAME"));
        wFUser.set("VALIDFLAG", _default.get("VALIDFLAG"));
        this.executeDeaction1(iActionContext);
    }

    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        WFUser wFUser = (WFUser)iActionContext.getParam("WFUser");
        MsgAccount msgAccount = (MsgAccount)iActionContext.getParam("MsgAccount");
        User _default = (User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(WFUserService.class, sessionFactory);
        service.executeAction("SAVE", wFUser);
    }
}

