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
 * 实体逻辑处理[获取当前用户]模型对象基类
 */
public abstract class OrgUserGetCurUserLogicModelBase extends net.ibizsys.paas.demodel.DELogicModelBase<OrgUser> {

    private static final Log log = LogFactory.getLog(OrgUserGetCurUserLogicModelBase.class);

    public OrgUserGetCurUserLogicModelBase() {
        super();
        //设置逻辑基本信息
        this.setId("0708CF81-FA6D-42CB-88DF-2B2A97917F90");
        this.setName("GetCurUser");
        //设置默认参数名称
        this.setDefaultParamName("Default");
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.DELogicModelBase#onExecute(net.ibizsys.paas.core.IActionContext)
     */
    @Override
    protected void onExecute(IActionContext iActionContext) throws Exception {
        executeBegin(iActionContext);
    }

    /**
    * 执行逻辑处理[修改当前用户标示]
    * @Param iActionContext 处理上下文参数
    */
    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();

        //用户全局对象[SRFPERSONID] ==> Default[orguserid]
        _default.set("orguserid",WebContext.getCurrent().getSessionValue("SRFPERSONID"));

        if(true) {
            executeDeaction1(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[开始]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeBegin(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();


        if(true) {
            executePrepareparam1(iActionContext);
        }
    }
    /**
    * 执行逻辑处理[获取]
    * @Param iActionContext 处理上下文参数
    */
    protected void executeDeaction1(IActionContext iActionContext) throws Exception {
        net.ibizsys.psrt.srv.common.entity.OrgUser _default = (net.ibizsys.psrt.srv.common.entity.OrgUser)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        IService service = ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.OrgUserService.class,sessionFactory );
        service.executeAction(net.ibizsys.psrt.srv.common.service.OrgUserService.ACTION_GET,_default);

    }

}