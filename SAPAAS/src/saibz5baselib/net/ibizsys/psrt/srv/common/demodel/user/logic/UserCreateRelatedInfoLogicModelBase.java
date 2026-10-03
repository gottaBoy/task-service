/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.user.logic;


import java.util.List;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.IService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.UserService;

/**
 * 实体逻辑处理[建立用户相关信息]模型对象基类
 */
public abstract class UserCreateRelatedInfoLogicModelBase extends net.ibizsys.paas.demodel.DELogicModelBase<User> {

    private static final Log log = LogFactory.getLog(UserCreateRelatedInfoLogicModelBase.class);

    public UserCreateRelatedInfoLogicModelBase() {
        super();
        //设置逻辑基本信息
        this.setId("F28C6146-4E62-4B48-A9AD-E37BC6855113");
        this.setName("CreateRelatedInfo");
        //设置默认参数名称
        this.setDefaultParamName("Default");
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DELogicModelBase#onExecute(net.ibizsys.paas.core.IActionContext)
     */
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        //初始化逻辑变量[流程用户]
        iActionContext.setParam("WFUser",new net.ibizsys.psrt.srv.wf.entity.WFUser());
        //初始化逻辑变量[消息账户]
        iActionContext.setParam("MsgAccount",new net.ibizsys.psrt.srv.common.entity.MsgAccount());
        executeBegin(iActionContext);
    }

    /**
    * 执行逻辑处理[准备消息账户对象]
    * @Param iActionContext 处理上下文参数
    */
    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.wf.entity.WFUser wFUser = (net.ibizsys.psrt.srv.wf.entity.WFUser)iActionContext.getParam("WFUser");
        net.ibizsys.psrt.srv.common.entity.MsgAccount msgAccount = (net.ibizsys.psrt.srv.common.entity.MsgAccount)iActionContext.getParam("MsgAccount");
        net.ibizsys.psrt.srv.common.entity.User _default = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();

        //Default[USERID] ==> MsgAccount[MSGACCOUNTID]
        msgAccount.set("MSGACCOUNTID",_default.get("USERID"));
        //Default[USERNAME] ==> MsgAccount[MSGACCOUNTNAME]
        msgAccount.set("MSGACCOUNTNAME",_default.get("USERNAME"));
        //直接值[0] ==> MsgAccount[ISLIST]
        msgAccount.set("ISLIST","0");

        if(true) {
            executeDeaction2(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[开始]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeBegin(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.wf.entity.WFUser wFUser = (net.ibizsys.psrt.srv.wf.entity.WFUser)iActionContext.getParam("WFUser");
        net.ibizsys.psrt.srv.common.entity.MsgAccount msgAccount = (net.ibizsys.psrt.srv.common.entity.MsgAccount)iActionContext.getParam("MsgAccount");
        net.ibizsys.psrt.srv.common.entity.User _default = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();


        if(true) {
            executePrepareparam1(iActionContext);
        }
        if(true) {
            executePrepareparam2(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[建立消息账户]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeDeaction2(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.wf.entity.WFUser wFUser = (net.ibizsys.psrt.srv.wf.entity.WFUser)iActionContext.getParam("WFUser");
        net.ibizsys.psrt.srv.common.entity.MsgAccount msgAccount = (net.ibizsys.psrt.srv.common.entity.MsgAccount)iActionContext.getParam("MsgAccount");
        net.ibizsys.psrt.srv.common.entity.User _default = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.MsgAccountService.class,sessionFactory );
        service.executeAction(net.ibizsys.psrt.srv.common.service.MsgAccountService.ACTION_SAVE,msgAccount);

    }
    /**
    * 执行逻辑处理[准备流程用户对象]
    * @Param iActionContext 处理上下文参数
    */
    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.wf.entity.WFUser wFUser = (net.ibizsys.psrt.srv.wf.entity.WFUser)iActionContext.getParam("WFUser");
        net.ibizsys.psrt.srv.common.entity.MsgAccount msgAccount = (net.ibizsys.psrt.srv.common.entity.MsgAccount)iActionContext.getParam("MsgAccount");
        net.ibizsys.psrt.srv.common.entity.User _default = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();

        //Default[USERID] ==> WFUser[WFUSERID]
        wFUser.set("WFUSERID",_default.get("USERID"));
        //Default[USERNAME] ==> WFUser[WFUSERNAME]
        wFUser.set("WFUSERNAME",_default.get("USERNAME"));
        //Default[VALIDFLAG] ==> WFUser[VALIDFLAG]
        wFUser.set("VALIDFLAG",_default.get("VALIDFLAG"));

        if(true) {
            executeDeaction1(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[建立流程用户]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.wf.entity.WFUser wFUser = (net.ibizsys.psrt.srv.wf.entity.WFUser)iActionContext.getParam("WFUser");
        net.ibizsys.psrt.srv.common.entity.MsgAccount msgAccount = (net.ibizsys.psrt.srv.common.entity.MsgAccount)iActionContext.getParam("MsgAccount");
        net.ibizsys.psrt.srv.common.entity.User _default = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,sessionFactory );
        service.executeAction(net.ibizsys.psrt.srv.wf.service.WFUserService.ACTION_SAVE,wFUser);

    }

}