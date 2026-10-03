/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.logic;


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

import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.OrgUserService;

/**
 * 实体逻辑处理[建立关联信息]模型对象基类
 */
public abstract class OrgUserCreateRelatedInfoLogicModelBase extends net.ibizsys.paas.demodel.DELogicModelBase<OrgUser> {

    private static final Log log = LogFactory.getLog(OrgUserCreateRelatedInfoLogicModelBase.class);

    public OrgUserCreateRelatedInfoLogicModelBase() {
        super();
        //设置逻辑基本信息
        this.setId("10923BA6-9FD1-427C-9046-8DEBB24710B0");
        this.setName("CreateRelatedInfo");
        //设置默认参数名称
        this.setDefaultParamName("Default");
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DELogicModelBase#onExecute(net.ibizsys.paas.core.IActionContext)
     */
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        //初始化逻辑变量[用户词典]
        iActionContext.setParam("UserDict",new net.ibizsys.psrt.srv.common.entity.UserDict());
        //初始化逻辑变量[User]
        iActionContext.setParam("User",new net.ibizsys.psrt.srv.common.entity.User());
        executeBegin(iActionContext);
    }

    /**
    * 执行逻辑处理[准备用户对象参数]
    * @Param iActionContext 处理上下文参数
    */
    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.UserDict userDict = (net.ibizsys.psrt.srv.common.entity.UserDict)iActionContext.getParam("UserDict");
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        net.ibizsys.psrt.srv.common.entity.User user = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();

        //Default[ORGUSERID] ==> User[USERID]
        user.set("USERID",_default.get("ORGUSERID"));
        //Default[ORGUSERNAME] ==> User[USERNAME]
        user.set("USERNAME",_default.get("ORGUSERNAME"));

        if(true) {
            executeDeaction1(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[保存用户]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.UserDict userDict = (net.ibizsys.psrt.srv.common.entity.UserDict)iActionContext.getParam("UserDict");
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        net.ibizsys.psrt.srv.common.entity.User user = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserService.class,sessionFactory );
        service.executeAction(net.ibizsys.psrt.srv.common.service.UserService.ACTION_CREATE,user);

    }
    /**
    * 执行逻辑处理[建立用户词典]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeDeaction2(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.UserDict userDict = (net.ibizsys.psrt.srv.common.entity.UserDict)iActionContext.getParam("UserDict");
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        net.ibizsys.psrt.srv.common.entity.User user = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserDictService.class,sessionFactory );
        service.executeAction(net.ibizsys.psrt.srv.common.service.UserDictService.ACTION_CREATE,userDict);

    }
    /**
    * 执行逻辑处理[开始]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeBegin(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.UserDict userDict = (net.ibizsys.psrt.srv.common.entity.UserDict)iActionContext.getParam("UserDict");
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        net.ibizsys.psrt.srv.common.entity.User user = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();


        if(true) {
            executePrepareparam1(iActionContext);
        }
        if(true) {
            executePrepareparam2(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[准备用户词典数据对象]
    * @Param iActionContext 处理上下文参数
    */
    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.UserDict userDict = (net.ibizsys.psrt.srv.common.entity.UserDict)iActionContext.getParam("UserDict");
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        net.ibizsys.psrt.srv.common.entity.User user = (net.ibizsys.psrt.srv.common.entity.User)iActionContext.getParam("User");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();

        //Default[ORGUSERID] ==> UserDict[OWNERID]
        userDict.set("OWNERID",_default.get("ORGUSERID"));
        //Default[ORGUSERID] ==> UserDict[USERDICTID]
        userDict.set("USERDICTID",_default.get("ORGUSERID"));
        //Default[ORGUSERNAME] ==> UserDict[USERDICTNAME]
        userDict.set("USERDICTNAME",_default.get("ORGUSERNAME"));
        //直接值[ORGUSER] ==> UserDict[OWNERTYPE]
        userDict.set("OWNERTYPE","ORGUSER");

        if(true) {
            executeDeaction2(iActionContext);
        }
    }

}