/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.EntityError;

import java.sql.Timestamp;

import net.ibizsys.paas.util.DefaultValueHelper;

import javax.annotation.PostConstruct;

import net.ibizsys.paas.service.IDataContextParam;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import net.ibizsys.psrt.srv.wf.service.WFAssistWorkService;
import net.ibizsys.psrt.srv.wf.entity.WFAssistWork;

import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;

import net.ibizsys.psrt.srv.wf.service.WFStepInstService;
import net.ibizsys.psrt.srv.wf.entity.WFStepInst;

import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.entity.WFStep;

import net.ibizsys.psrt.srv.wf.service.WFWorkList2Service;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList2;

import net.ibizsys.psrt.srv.wf.service.WFWorkListService;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;

import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.dao.WFInstanceDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFInstanceDEModel;

/**
 * 实体[WFInstance] 服务对象基类
 */
public abstract class WFInstanceServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFInstance> {
    private static final Log log = LogFactory.getLog(WFInstanceServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";

    /**
     * 实体行为[取消流程]标识
     */
    public final static String ACTION_USERCANCEL = "UserCancel";
    /**
     * 实体行为[重新启动]标识
     */
    public final static String ACTION_RESTART = "Restart";

    public WFInstanceServiceBase () {
        super();

    }

    /**
     * 获取实体[WFInstance]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFInstanceService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFInstance]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFInstanceService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, sessionFactory);
    }

    /**
     * Spring注册后执行构造处理
     * @throws Exception
     */
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(getServiceId(), this);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getServiceId()
     */
    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFInstanceService";
    }

    private WFInstanceDEModel wFInstanceDEModel;
    /**
     * 获取实体[WFInstance]模型对象
     */
    public  WFInstanceDEModel getWFInstanceDEModel() {
        if(this.wFInstanceDEModel==null) {
            try {
                this.wFInstanceDEModel = (WFInstanceDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFInstanceDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFInstanceDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFInstanceDEModel();
    }


    private WFInstanceDAO wFInstanceDAO;

    /**
     * 获取实体[WFInstance]数据操作对象
     */
    public  WFInstanceDAO getWFInstanceDAO() {
        if(this.wFInstanceDAO==null) {
            try {
                this.wFInstanceDAO= (WFInstanceDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFInstanceDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFInstanceDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFInstanceDAO();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onfetchDataSet(java.lang.String, net.ibizsys.paas.core.IDEDataSetFetchContext)
     */
    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName,IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if(StringHelper.compare(strDataSetName,DATASET_DEFAULT,true)==0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName,iDEDataSetFetchContext);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onExecuteAction(java.lang.String, net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected  void onExecuteAction(String strAction,IEntity entity) throws Exception {
        if(StringHelper.compare(strAction,ACTION_USERCANCEL,true)==0) {
            this.userCancel((WFInstance)entity);
            return;
        }
        if(StringHelper.compare(strAction,ACTION_RESTART,true)==0) {
            this.restart((WFInstance)entity);
            return;
        }
        super.onExecuteAction(strAction,entity);
    }

    /**
     * 获取数据集合[DEFAULT]
     * @param iDEDataSetFetchContext
     * @return
     * @throws Exception
     */
    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {

        DBFetchResult dbFetchResult =  doServiceFetchWork(iDEDataSetFetchContext,DATASET_DEFAULT,false);
        // dbFetchResult.getDataSet().cacheDataRow();
        // session.close();
        return dbFetchResult;
    }





    /**
     * 执行操作[UserCancel]
     */
    public void userCancel(WFInstance wFInstance) throws Exception {

        if(this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag(IServiceAPIAction.ACTIONTYPE_DEACTION, ACTION_USERCANCEL), wFInstance);
            return;
        }

        final IServicePlugin iServicePlugin = getPlugin();
        if(iServicePlugin!=null && iServicePlugin.doCustomAction(this,ACTION_USERCANCEL, IServicePlugin.ACTIONPOS_ENTER,wFInstance,null).getResult()==PluginActionResult.RESULT_REPLACE)
            return;
        this.testDEMainStateAction(wFInstance,ACTION_USERCANCEL);
        final WFInstance wFInstance2 = wFInstance;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if(iServicePlugin==null || iServicePlugin.doCustomAction(getService(),ACTION_USERCANCEL, IServicePlugin.ACTIONPOS_ACTION,wFInstance2,null).getResult()!=PluginActionResult.RESULT_REPLACE)
                    onUserCancel(wFInstance2);
            }
        });

        if(iServicePlugin!=null)
            iServicePlugin.doCustomAction(this,ACTION_USERCANCEL,IServicePlugin.ACTIONPOS_LEAVE,wFInstance,null);
    }

    /**
     * 执行操作[UserCancel]
     */
    protected void onUserCancel(WFInstance wFInstance) throws Exception {

        throw new Exception("没有实现自定义行为[UserCancel]");
    }
    /**
     * 执行操作[Restart]
     */
    public void restart(WFInstance wFInstance) throws Exception {

        if(this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag(IServiceAPIAction.ACTIONTYPE_DEACTION, ACTION_RESTART), wFInstance);
            return;
        }

        final IServicePlugin iServicePlugin = getPlugin();
        if(iServicePlugin!=null && iServicePlugin.doCustomAction(this,ACTION_RESTART, IServicePlugin.ACTIONPOS_ENTER,wFInstance,null).getResult()==PluginActionResult.RESULT_REPLACE)
            return;
        this.testDEMainStateAction(wFInstance,ACTION_RESTART);
        final WFInstance wFInstance2 = wFInstance;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                if(iServicePlugin==null || iServicePlugin.doCustomAction(getService(),ACTION_RESTART, IServicePlugin.ACTIONPOS_ACTION,wFInstance2,null).getResult()!=PluginActionResult.RESULT_REPLACE)
                    onRestart(wFInstance2);
            }
        });

        if(iServicePlugin!=null)
            iServicePlugin.doCustomAction(this,ACTION_RESTART,IServicePlugin.ACTIONPOS_LEAVE,wFInstance,null);
    }

    /**
     * 执行操作[Restart]
     */
    protected void onRestart(WFInstance wFInstance) throws Exception {

        throw new Exception("没有实现自定义行为[Restart]");
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillParentInfo(net.ibizsys.paas.entity.IEntity, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected void onFillParentInfo(WFInstance et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :ORG / 组织机构
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFINSTANCE_ORG_ORGID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.OrgService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.Org parentEntity = ( net.ibizsys.psrt.srv.common.entity.Org)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.Org.FIELD_ORGID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_Org(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFINSTANCE / 工作流实例
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFInstanceService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFInstance)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFInstance.FIELD_WFINSTANCEID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_PWFInstance(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFWORKFLOW / 工作流配置
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFWorkflowService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFWorkflow)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFWorkflow.FIELD_WFWORKFLOWID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFWorkflow(et,parentEntity );
            return;
        }
        super.onFillParentInfo(et,strParentType,strTypeParam,strParentKey);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncDER1NData(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData( strDER1NId,  strParentKey,  strDatas);
    }


    /**
    * 填充数据的父数据信息[组织机构]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_Org(WFInstance et,net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {
        et.setOrgId(parentEntity.getOrgId());
        et.setOrgName(parentEntity.getOrgName());
    }

    /**
    * 填充数据的父数据信息[工作流实例]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_PWFInstance(WFInstance et,net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        et.setPWFInstanceId(parentEntity.getWFInstanceId());
        et.setPWFInstanceName(parentEntity.getWFInstanceName());
    }

    /**
    * 填充数据的父数据信息[工作流配置]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFWorkflow(WFInstance et,net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        et.setWFWorkflowId(parentEntity.getWFWorkflowId());
        et.setWFWorkflowName(parentEntity.getWFWorkflowName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFInstance et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getSuspendFlag()==null) {
                et.setSuspendFlag((Integer)DefaultValueHelper.getValue(this.getWebContext(),"","0",9));
            }
            if(et.getTraceStep()==null) {
                et.setTraceStep((Integer)DefaultValueHelper.getValue(this.getWebContext(),"","0",9));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :ORG / 组织机构
        onFillEntityFullInfo_Org(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFINSTANCE / 工作流实例
        onFillEntityFullInfo_PWFInstance(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFWORKFLOW / 工作流配置
        onFillEntityFullInfo_WFWorkflow(et, bCreate);
    }

    /**
    * 填充实体的数据信息 组织机构
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_Org(WFInstance et, boolean bCreate) throws Exception {
        if(et.isOrgIdDirty()) {
            if(et.getOrgId()!=null) {
                if((true&&et.getOrgId()==null)||(true&&et.getOrgName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.Org parentEntity  = et.getOrg();
                    et.setOrgName(parentEntity.getOrgName());
                }

            } else {
                et.setOrgName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 工作流实例
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_PWFInstance(WFInstance et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流配置
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFWorkflow(WFInstance et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFInstance et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[组织机构]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFInstance> selectByOrg(net.ibizsys.psrt.srv.common.entity.OrgBase parentEntity) throws Exception {
        return selectByOrg( parentEntity,"");
    }
    /**
     * 通过关系[组织机构]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFInstance> selectByOrg(net.ibizsys.psrt.srv.common.entity.OrgBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFInstance.FIELD_ORGID, parentEntity.getOrgId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByOrgCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[组织机构]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByOrgCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流实例]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFInstance> selectByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstanceBase parentEntity) throws Exception {
        return selectByPWFInstance( parentEntity,"");
    }
    /**
     * 通过关系[工作流实例]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFInstance> selectByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstanceBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFInstance.FIELD_PWFINSTANCEID, parentEntity.getWFInstanceId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByPWFInstanceCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流实例]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByPWFInstanceCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流配置]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFInstance> selectByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase parentEntity) throws Exception {
        return selectByWFWorkflow( parentEntity,"");
    }
    /**
     * 通过关系[工作流配置]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFInstance> selectByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFInstance.FIELD_WFWORKFLOWID, parentEntity.getWFWorkflowId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFWorkflowCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流配置]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFWorkflowCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[组织机构]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> list =  this.selectByOrg(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("ORG");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFINSTANCE_ORG_ORGID","" ,parentDEModel.getName(),"WFINSTANCE",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[组织机构]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> list =  this.selectByOrg(parentEntity);
        for(WFInstance item:list) {
            WFInstance item2 = (WFInstance)getDEModel().createEntity();
            item2.setWFInstanceId(item.getWFInstanceId());
            item2.setOrgId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[组织机构]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.Org parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByOrg(parentEntity2);
                internalRemoveByOrg(parentEntity2);
                onAfterRemoveByOrg(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[组织机构]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[组织机构]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> removeList = selectByOrg(parentEntity);
        onBeforeRemoveByOrg(parentEntity,removeList );

        // 执行删除
        for (WFInstance item : removeList ) {
            remove(item );
        }
        onAfterRemoveByOrg(parentEntity,removeList );
    }

    /**
     * 通过关系[组织机构]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity) throws Exception {

    }

    /**
     * 通过关系[组织机构]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity,java.util.ArrayList<WFInstance> removeList) throws Exception {

    }

    /**
     * 通过关系[组织机构]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByOrg(net.ibizsys.psrt.srv.common.entity.Org parentEntity,java.util.ArrayList<WFInstance> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流实例]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> list =  this.selectByPWFInstance(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFINSTANCE");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID","" ,parentDEModel.getName(),"WFINSTANCE",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[工作流实例]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> list =  this.selectByPWFInstance(parentEntity);
        for(WFInstance item:list) {
            WFInstance item2 = (WFInstance)getDEModel().createEntity();
            item2.setWFInstanceId(item.getWFInstanceId());
            item2.setPWFInstanceId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流实例]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByPWFInstance(parentEntity2);
                internalRemoveByPWFInstance(parentEntity2);
                onAfterRemoveByPWFInstance(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流实例]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流实例]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> removeList = selectByPWFInstance(parentEntity);
        onBeforeRemoveByPWFInstance(parentEntity,removeList );

        // 执行删除
        for (WFInstance item : removeList ) {
            remove(item );
        }
        onAfterRemoveByPWFInstance(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流实例]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流实例]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity,java.util.ArrayList<WFInstance> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流实例]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByPWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity,java.util.ArrayList<WFInstance> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流配置]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> list =  this.selectByWFWorkflow(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFWORKFLOW");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID","" ,parentDEModel.getName(),"WFINSTANCE",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[工作流配置]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> list =  this.selectByWFWorkflow(parentEntity);
        for(WFInstance item:list) {
            WFInstance item2 = (WFInstance)getDEModel().createEntity();
            item2.setWFInstanceId(item.getWFInstanceId());
            item2.setWFWorkflowId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流配置]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFWorkflow(parentEntity2);
                internalRemoveByWFWorkflow(parentEntity2);
                onAfterRemoveByWFWorkflow(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流配置]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流配置]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        java.util.ArrayList<WFInstance> removeList = selectByWFWorkflow(parentEntity);
        onBeforeRemoveByWFWorkflow(parentEntity,removeList );

        // 执行删除
        for (WFInstance item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFWorkflow(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流配置]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流配置]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity,java.util.ArrayList<WFInstance> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流配置]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity,java.util.ArrayList<WFInstance> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFInstance et) throws Exception {
        //判断是否可以删除 关系 工作流实例 数据
        if(true) {
            WFInstanceService service = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class,this.getSessionFactory());
            service.testRemoveByPWFInstance(et);
        }
        //判断是否可以删除 关系 工作流步骤数据 数据
        if(true) {
            WFStepDataService service = (WFStepDataService)ServiceGlobal.getService(WFStepDataService.class,this.getSessionFactory());
            service.testRemoveByWFInstance(et);
        }
        //判断是否可以删除 关系 工作流步骤子实例 数据
        if(true) {
            WFStepInstService service = (WFStepInstService)ServiceGlobal.getService(WFStepInstService.class,this.getSessionFactory());
            service.testRemoveByWFInstance(et);
        }
        //判断是否可以删除 关系 工作流步骤 数据
        if(true) {
            WFStepService service = (WFStepService)ServiceGlobal.getService(WFStepService.class,this.getSessionFactory());
            service.testRemoveByWFInstance(et);
        }
        //判断是否可以删除 关系 工作流工作列表2 数据
        if(true) {
            WFWorkList2Service service = (WFWorkList2Service)ServiceGlobal.getService(WFWorkList2Service.class,this.getSessionFactory());
            service.testRemoveByWFInstance(et);
        }
        //判断是否可以删除 关系 工作流工作列表 数据
        if(true) {
            WFWorkListService service = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class,this.getSessionFactory());
            service.testRemoveByWFInstance(et);
        }

        //删除 关系 工作流步骤子实例 数据
        if(true) {
            WFStepInstService service = (WFStepInstService)ServiceGlobal.getService(WFStepInstService.class,this.getSessionFactory());
            service.resetWFInstance(et);
        }
        //删除 关系 工作流工作列表2 数据
        if(true) {
            WFWorkList2Service service = (WFWorkList2Service)ServiceGlobal.getService(WFWorkList2Service.class,this.getSessionFactory());
            service.resetWFInstance(et);
        }
        //删除 关系 工作流工作列表 数据
        if(true) {
            WFWorkListService service = (WFWorkListService)ServiceGlobal.getService(WFWorkListService.class,this.getSessionFactory());
            service.resetWFInstance(et);
        }
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFInstance et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getOrgId()!=null) {
            IEntity entity = cloneSession.getEntity("ORG",et.getOrgId());
            if(entity !=null) {
                onFillParentInfo_Org(et,(net.ibizsys.psrt.srv.common.entity.Org) entity);
            }
        }
        if(et.getPWFInstanceId()!=null) {
            IEntity entity = cloneSession.getEntity("WFINSTANCE",et.getPWFInstanceId());
            if(entity !=null) {
                onFillParentInfo_PWFInstance(et,(net.ibizsys.psrt.srv.wf.entity.WFInstance) entity);
            }
        }
        if(et.getWFWorkflowId()!=null) {
            IEntity entity = cloneSession.getEntity("WFWORKFLOW",et.getWFWorkflowId());
            if(entity !=null) {
                onFillParentInfo_WFWorkflow(et,(net.ibizsys.psrt.srv.wf.entity.WFWorkflow) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(WFInstance et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFInstance  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 ACTIVESTEPID
        entityFieldError = onCheckField_ActiveStepId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 当前步骤名称
        entityFieldError = onCheckField_ActiveStepName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 取消原因
        entityFieldError = onCheckField_CancelReason( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 结束时间
        entityFieldError = onCheckField_EndTime( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 错误信息
        entityFieldError = onCheckField_ErrorInfo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 重要程度
        entityFieldError = onCheckField_ImportanceFlag( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 是否取消
        entityFieldError = onCheckField_IsCancel( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 是否关闭
        entityFieldError = onCheckField_IsClose( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 是否错误
        entityFieldError = onCheckField_IsError( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 是否完成
        entityFieldError = onCheckField_IsFinish( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 上一个操作
        entityFieldError = onCheckField_LastAction( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 上一个操作者
        entityFieldError = onCheckField_LastActorId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 上一个操作步骤
        entityFieldError = onCheckField_LastWFStepId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流说明
        entityFieldError = onCheckField_Memo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 OWNER
        entityFieldError = onCheckField_Owner( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 并行实例
        entityFieldError = onCheckField_ParallelInst( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 父步骤编号
        entityFieldError = onCheckField_PStepId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 父实例
        entityFieldError = onCheckField_PWFInstanceId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 结果信息
        entityFieldError = onCheckField_Result( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 开始时间
        entityFieldError = onCheckField_StartTime( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 流程挂起
        entityFieldError = onCheckField_SuspendFlag( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 跟踪步骤
        entityFieldError = onCheckField_TraceStep( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户数据
        entityFieldError = onCheckField_UserData( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户数据2
        entityFieldError = onCheckField_UserData2( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户数据3
        entityFieldError = onCheckField_UserData3( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户数据4
        entityFieldError = onCheckField_UserData4( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户数据信息
        entityFieldError = onCheckField_UserDataInfo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 自定义数据
        entityFieldError = onCheckField_UserTag( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 自定义数据
        entityFieldError = onCheckField_UserTag2( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流实例标识
        entityFieldError = onCheckField_WFInstanceId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流实例名称
        entityFieldError = onCheckField_WFInstanceName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 流程配置
        entityFieldError = onCheckField_WFModel( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流版本
        entityFieldError = onCheckField_WFVersion( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流名称
        entityFieldError = onCheckField_WFWorkflowId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[ActiveStepId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ActiveStepId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isActiveStepIdDirty()) {
            return null;
        }

        String value = et.getActiveStepId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ActiveStepId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ACTIVESTEPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ActiveStepName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ActiveStepName(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isActiveStepNameDirty()) {
            return null;
        }

        String value = et.getActiveStepName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ActiveStepName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ACTIVESTEPNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[CancelReason]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_CancelReason(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isCancelReasonDirty()) {
            return null;
        }

        String value = et.getCancelReason();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_CancelReason_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_CANCELREASON);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[EndTime]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_EndTime(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isEndTimeDirty()) {
            return null;
        }

        Timestamp value = et.getEndTime();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_EndTime_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ENDTIME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ErrorInfo]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ErrorInfo(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isErrorInfoDirty()) {
            return null;
        }

        String value = et.getErrorInfo();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ErrorInfo_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ERRORINFO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ImportanceFlag]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ImportanceFlag(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isImportanceFlagDirty()) {
            return null;
        }

        Integer value = et.getImportanceFlag();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ImportanceFlag_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_IMPORTANCEFLAG);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[IsCancel]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_IsCancel(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isIsCancelDirty()) {
            return null;
        }

        Integer value = et.getIsCancel();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_IsCancel_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ISCANCEL);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[IsClose]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_IsClose(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isIsCloseDirty()) {
            return null;
        }

        Integer value = et.getIsClose();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_IsClose_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ISCLOSE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[IsError]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_IsError(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isIsErrorDirty()) {
            return null;
        }

        Integer value = et.getIsError();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_IsError_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ISERROR);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[IsFinish]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_IsFinish(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isIsFinishDirty()) {
            return null;
        }

        Integer value = et.getIsFinish();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_IsFinish_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_ISFINISH);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[LastAction]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_LastAction(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isLastActionDirty()) {
            return null;
        }

        String value = et.getLastAction();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_LastAction_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_LASTACTION);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[LastActorId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_LastActorId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isLastActorIdDirty()) {
            return null;
        }

        String value = et.getLastActorId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_LastActorId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_LASTACTORID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[LastWFStepId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_LastWFStepId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isLastWFStepIdDirty()) {
            return null;
        }

        String value = et.getLastWFStepId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_LastWFStepId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_LASTWFSTEPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Memo]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Memo(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMemoDirty()) {
            return null;
        }

        String value = et.getMemo();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Memo_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_MEMO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Owner]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Owner(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isOwnerDirty()) {
            return null;
        }

        String value = et.getOwner();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Owner_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_OWNER);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ParallelInst]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ParallelInst(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isParallelInstDirty()) {
            return null;
        }

        Integer value = et.getParallelInst();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ParallelInst_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_PARALLELINST);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PStepId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PStepId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPStepIdDirty()) {
            return null;
        }

        String value = et.getPStepId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PStepId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_PSTEPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PWFInstanceId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PWFInstanceId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPWFInstanceIdDirty()) {
            return null;
        }

        String value = et.getPWFInstanceId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PWFInstanceId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_PWFINSTANCEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Result]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Result(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isResultDirty()) {
            return null;
        }

        String value = et.getResult();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Result_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_RESULT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[StartTime]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_StartTime(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isStartTimeDirty()) {
            return null;
        }

        Timestamp value = et.getStartTime();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_StartTime_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_STARTTIME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[SuspendFlag]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_SuspendFlag(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isSuspendFlagDirty()) {
            return null;
        }

        Integer value = et.getSuspendFlag();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_SuspendFlag_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_SUSPENDFLAG);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TraceStep]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TraceStep(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTraceStepDirty()) {
            return null;
        }

        Integer value = et.getTraceStep();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TraceStep_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_TRACESTEP);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserData]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserData(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserDataDirty()) {
            return null;
        }

        String value = et.getUserData();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserData_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERDATA);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserData2]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserData2(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserData2Dirty()) {
            return null;
        }

        String value = et.getUserData2();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserData2_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERDATA2);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserData3]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserData3(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserData3Dirty()) {
            return null;
        }

        String value = et.getUserData3();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserData3_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERDATA3);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserData4]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserData4(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserData4Dirty()) {
            return null;
        }

        String value = et.getUserData4();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserData4_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERDATA4);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserDataInfo]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserDataInfo(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserDataInfoDirty()) {
            return null;
        }

        String value = et.getUserDataInfo();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserDataInfo_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERDATAINFO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserTag]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserTag(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserTagDirty()) {
            return null;
        }

        String value = et.getUserTag();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserTag_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERTAG);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserTag2]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserTag2(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserTag2Dirty()) {
            return null;
        }

        String value = et.getUserTag2();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserTag2_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_USERTAG2);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFInstanceId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFInstanceId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFInstanceIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFINSTANCEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFInstanceId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFInstance.FIELD_WFINSTANCEID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFInstanceId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFINSTANCEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFInstanceName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFInstanceName(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFInstanceNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFINSTANCENAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFInstanceName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFInstance.FIELD_WFINSTANCENAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFInstanceName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFINSTANCENAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFModel]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFModel(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFModelDirty()) {
            return null;
        }

        String value = et.getWFModel();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFModel_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFMODEL);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFVersion]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFVersion(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFVersionDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFVERSION);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        Integer value = et.getWFVersion();
        if(bBaseMode) {
            if(bCreate) {
                if(value==null) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFInstance.FIELD_WFVERSION);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFVersion_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFVERSION);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFWorkflowId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFWorkflowId(boolean bBaseMode,WFInstance et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFWorkflowIdDirty()) {
            return null;
        }

        String value = et.getWFWorkflowId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFWorkflowId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFInstance.FIELD_WFWORKFLOWID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncEntity(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncEntity(WFInstance et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFInstance et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFInstance et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ACTIVESTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ActiveStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ACTIVESTEPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ActiveStepName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_CANCELREASON,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CancelReason_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ENABLE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Enable_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ENDTIME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_EndTime_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ERRORINFO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ErrorInfo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_IMPORTANCEFLAG,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ImportanceFlag_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ISCANCEL,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_IsCancel_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ISCLOSE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_IsClose_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ISERROR,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_IsError_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ISFINISH,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_IsFinish_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_LASTACTION,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_LastAction_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_LASTACTORID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_LastActorId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_LASTWFSTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_LastWFStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_MEMO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Memo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ORGID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_OrgId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_ORGNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_OrgName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_OWNER,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Owner_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_PARALLELINST,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ParallelInst_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_PSTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_PWFINSTANCEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PWFInstanceId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_PWFINSTANCENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PWFInstanceName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_RESULT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Result_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_STARTTIME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_StartTime_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_SUSPENDFLAG,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_SuspendFlag_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_TRACESTEP,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TraceStep_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERDATA,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERDATA2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERDATA3,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData3_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERDATA4,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData4_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERDATAINFO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserDataInfo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERTAG,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserTag_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_USERTAG2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserTag2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_WFINSTANCEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFInstanceId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_WFINSTANCENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFInstanceName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_WFMODEL,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFModel_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_WFVERSION,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFVersion_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_WFWORKFLOWID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFWorkflowId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFInstance.FIELD_WFWORKFLOWNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFWorkflowName_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[ACTIVESTEPID][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ActiveStepId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("ACTIVESTEPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[当前步骤名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ActiveStepName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("ACTIVESTEPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[取消原因][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_CancelReason_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("CANCELREASON", et, bTempMode,null,false,1048576,true,"内容长度必须小于等于[1048576]",false)))
                return null;
            return "内容长度必须小于等于[1048576]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[建立时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_CreateDate_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[建立人][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_CreateMan_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("CREATEMAN", et, bTempMode,null,false,60,true,"内容长度必须小于等于[60]",false)))
                return null;
            return "内容长度必须小于等于[60]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[逻辑有效标志][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Enable_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[结束时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_EndTime_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[错误信息][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ErrorInfo_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("ERRORINFO", et, bTempMode,null,false,1048576,true,"内容长度必须小于等于[1048576]",false)))
                return null;
            return "内容长度必须小于等于[1048576]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[重要程度][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ImportanceFlag_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[是否取消][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_IsCancel_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[是否关闭][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_IsClose_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[是否错误][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_IsError_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[是否完成][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_IsFinish_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[上一个操作][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_LastAction_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("LASTACTION", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[上一个操作者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_LastActorId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("LASTACTORID", et, bTempMode,null,false,60,true,"内容长度必须小于等于[60]",false)))
                return null;
            return "内容长度必须小于等于[60]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[上一个操作步骤][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_LastWFStepId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("LASTWFSTEPID", et, bTempMode,null,false,60,true,"内容长度必须小于等于[60]",false)))
                return null;
            return "内容长度必须小于等于[60]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流说明][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Memo_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MEMO", et, bTempMode,null,false,2000,true,"内容长度必须小于等于[2000]",false)))
                return null;
            return "内容长度必须小于等于[2000]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组织标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_OrgId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("ORGID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组织名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_OrgName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("ORGNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[OWNER][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Owner_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("OWNER", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[并行实例][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ParallelInst_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[父步骤编号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PStepId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PSTEPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[父实例][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PWFInstanceId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PWFINSTANCEID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[父实例][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PWFInstanceName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PWFINSTANCENAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[结果信息][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Result_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESULT", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[开始时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_StartTime_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[流程挂起][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_SuspendFlag_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[跟踪步骤][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TraceStep_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[更新时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UpdateDate_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[更新人][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UpdateMan_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("UPDATEMAN", et, bTempMode,null,false,60,true,"内容长度必须小于等于[60]",false)))
                return null;
            return "内容长度必须小于等于[60]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户数据][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserData_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATA", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户数据2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserData2_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATA2", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户数据3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserData3_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATA3", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户数据4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserData4_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATA4", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户数据信息][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserDataInfo_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATAINFO", et, bTempMode,null,false,1000,true,"内容长度必须小于等于[1000]",false)))
                return null;
            return "内容长度必须小于等于[1000]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[自定义数据][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserTag_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERTAG", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[自定义数据][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserTag2_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERTAG2", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流实例标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFInstanceId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFINSTANCEID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流实例名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFInstanceName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFINSTANCENAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[流程配置][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFModel_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFMODEL", et, bTempMode,null,false,1048576,true,"内容长度必须小于等于[1048576]",false)))
                return null;
            return "内容长度必须小于等于[1048576]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流版本][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFVersion_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[工作流名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFWorkflowId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFWORKFLOWID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFWorkflowName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFWORKFLOWNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onMergeChild(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFInstance et) throws Exception {
        boolean bRet = false;
        if(super.onMergeChild( strChildType, strTypeParam,  et))
            bRet = true;
        return bRet;
    }



    /**
     * 更新父数据
     * @param et
     * @throws Exception
     */
    @Override
    protected void onUpdateParent(WFInstance et)throws Exception {
        super.onUpdateParent(et);
    }


}