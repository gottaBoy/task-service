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



import net.ibizsys.psrt.srv.wf.entity.WFAssistWork;
import net.ibizsys.psrt.srv.wf.dao.WFAssistWorkDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFAssistWorkDEModel;

/**
 * 实体[WFAssistWork] 服务对象基类
 */
public abstract class WFAssistWorkServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFAssistWork> {
    private static final Log log = LogFactory.getLog(WFAssistWorkServiceBase.class);
    /**
     * 实体数据集合[当前用户代办工作]标识
     */
    public final static String DATASET_CURUSERASSISTWORK = "CurUserAssistWork";
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WFAssistWorkServiceBase () {
        super();

    }

    /**
     * 获取实体[WFAssistWork]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFAssistWorkService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFAssistWork]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFAssistWorkService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFAssistWorkService)ServiceGlobal.getService(WFAssistWorkService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wf.service.WFAssistWorkService";
    }

    private WFAssistWorkDEModel wFAssistWorkDEModel;
    /**
     * 获取实体[WFAssistWork]模型对象
     */
    public  WFAssistWorkDEModel getWFAssistWorkDEModel() {
        if(this.wFAssistWorkDEModel==null) {
            try {
                this.wFAssistWorkDEModel = (WFAssistWorkDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFAssistWorkDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFAssistWorkDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFAssistWorkDEModel();
    }


    private WFAssistWorkDAO wFAssistWorkDAO;

    /**
     * 获取实体[WFAssistWork]数据操作对象
     */
    public  WFAssistWorkDAO getWFAssistWorkDAO() {
        if(this.wFAssistWorkDAO==null) {
            try {
                this.wFAssistWorkDAO= (WFAssistWorkDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFAssistWorkDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFAssistWorkDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFAssistWorkDAO();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onfetchDataSet(java.lang.String, net.ibizsys.paas.core.IDEDataSetFetchContext)
     */
    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName,IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if(StringHelper.compare(strDataSetName,DATASET_CURUSERASSISTWORK,true)==0) {
            return this.fetchCurUserAssistWork(iDEDataSetFetchContext);
        }
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
        super.onExecuteAction(strAction,entity);
    }

    /**
     * 获取数据集合[当前用户代办工作]
     * @param iDEDataSetFetchContext
     * @return
     * @throws Exception
     */
    public DBFetchResult fetchCurUserAssistWork(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {

        DBFetchResult dbFetchResult =  doServiceFetchWork(iDEDataSetFetchContext,DATASET_CURUSERASSISTWORK,false);
        // dbFetchResult.getDataSet().cacheDataRow();
        // session.close();
        return dbFetchResult;
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






    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillParentInfo(net.ibizsys.paas.entity.IEntity, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected void onFillParentInfo(WFAssistWork et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WFINSTANCE / 工作流实例
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFInstanceService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFInstance)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFInstance.FIELD_WFINSTANCEID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFInstance(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFSTEPACTOR / 工作流步骤操作者
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepActorService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFStepActor)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFStepActor.FIELD_WFSTEPACTORID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFStepActor(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFWORKFLOW / 工作流配置
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID", true)==0)) {
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
    * 填充数据的父数据信息[工作流实例]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFInstance(WFAssistWork et,net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        et.setActiveStepId(parentEntity.getActiveStepId());
        et.setUserData(parentEntity.getUserData());
        et.setUserData4(parentEntity.getUserData4());
        et.setWFInstanceId(parentEntity.getWFInstanceId());
        et.setWFInstanceName(parentEntity.getWFInstanceName());
    }

    /**
    * 填充数据的父数据信息[工作流步骤操作者]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFStepActor(WFAssistWork et,net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {
        et.setWFStepActorId(parentEntity.getWFStepActorId());
        et.setWFStepActorName(parentEntity.getWFStepActorName());
    }

    /**
    * 填充数据的父数据信息[工作流配置]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFWorkflow(WFAssistWork et,net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        et.setWFWorkflowId(parentEntity.getWFWorkflowId());
        et.setWFWorkflowName(parentEntity.getWFWorkflowName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFAssistWork et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WFINSTANCE / 工作流实例
        onFillEntityFullInfo_WFInstance(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFSTEPACTOR / 工作流步骤操作者
        onFillEntityFullInfo_WFStepActor(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFWORKFLOW / 工作流配置
        onFillEntityFullInfo_WFWorkflow(et, bCreate);
    }

    /**
    * 填充实体的数据信息 工作流实例
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFInstance(WFAssistWork et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流步骤操作者
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFStepActor(WFAssistWork et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流配置
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFWorkflow(WFAssistWork et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFAssistWork et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[工作流实例]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFAssistWork> selectByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstanceBase parentEntity) throws Exception {
        return selectByWFInstance( parentEntity,"");
    }
    /**
     * 通过关系[工作流实例]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFAssistWork> selectByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstanceBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFAssistWork.FIELD_WFINSTANCEID, parentEntity.getWFInstanceId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFInstanceCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流实例]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFInstanceCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流步骤操作者]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFAssistWork> selectByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActorBase parentEntity) throws Exception {
        return selectByWFStepActor( parentEntity,"");
    }
    /**
     * 通过关系[工作流步骤操作者]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFAssistWork> selectByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActorBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFAssistWork.FIELD_WFSTEPACTORID, parentEntity.getWFStepActorId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFStepActorCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流步骤操作者]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFStepActorCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流配置]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFAssistWork> selectByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase parentEntity) throws Exception {
        return selectByWFWorkflow( parentEntity,"");
    }
    /**
     * 通过关系[工作流配置]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFAssistWork> selectByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFAssistWork.FIELD_WFWORKFLOWID, parentEntity.getWFWorkflowId());
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
     * 判断是否能够通过关系[工作流实例]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
    }


    /**
     * 通过关系[工作流实例]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        java.util.ArrayList<WFAssistWork> list =  this.selectByWFInstance(parentEntity);
        for(WFAssistWork item:list) {
            WFAssistWork item2 = (WFAssistWork)getDEModel().createEntity();
            item2.setWFAssistWorkId(item.getWFAssistWorkId());
            item2.setWFInstanceId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流实例]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFInstance(parentEntity2);
                internalRemoveByWFInstance(parentEntity2);
                onAfterRemoveByWFInstance(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流实例]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流实例]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        java.util.ArrayList<WFAssistWork> removeList = selectByWFInstance(parentEntity);
        onBeforeRemoveByWFInstance(parentEntity,removeList );

        // 执行删除
        for (WFAssistWork item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFInstance(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流实例]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流实例]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity,java.util.ArrayList<WFAssistWork> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流实例]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity,java.util.ArrayList<WFAssistWork> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流步骤操作者]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {
    }


    /**
     * 通过关系[工作流步骤操作者]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {
        java.util.ArrayList<WFAssistWork> list =  this.selectByWFStepActor(parentEntity);
        for(WFAssistWork item:list) {
            WFAssistWork item2 = (WFAssistWork)getDEModel().createEntity();
            item2.setWFAssistWorkId(item.getWFAssistWorkId());
            item2.setWFStepActorId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流步骤操作者]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFStepActor(parentEntity2);
                internalRemoveByWFStepActor(parentEntity2);
                onAfterRemoveByWFStepActor(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流步骤操作者]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流步骤操作者]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {
        java.util.ArrayList<WFAssistWork> removeList = selectByWFStepActor(parentEntity);
        onBeforeRemoveByWFStepActor(parentEntity,removeList );

        // 执行删除
        for (WFAssistWork item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFStepActor(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流步骤操作者]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流步骤操作者]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity,java.util.ArrayList<WFAssistWork> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流步骤操作者]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity,java.util.ArrayList<WFAssistWork> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流配置]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
    }


    /**
     * 通过关系[工作流配置]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        java.util.ArrayList<WFAssistWork> list =  this.selectByWFWorkflow(parentEntity);
        for(WFAssistWork item:list) {
            WFAssistWork item2 = (WFAssistWork)getDEModel().createEntity();
            item2.setWFAssistWorkId(item.getWFAssistWorkId());
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
        java.util.ArrayList<WFAssistWork> removeList = selectByWFWorkflow(parentEntity);
        onBeforeRemoveByWFWorkflow(parentEntity,removeList );

        // 执行删除
        for (WFAssistWork item : removeList ) {
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
    protected void onBeforeRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity,java.util.ArrayList<WFAssistWork> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流配置]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity,java.util.ArrayList<WFAssistWork> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFAssistWork et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFAssistWork et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWFInstanceId()!=null) {
            IEntity entity = cloneSession.getEntity("WFINSTANCE",et.getWFInstanceId());
            if(entity !=null) {
                onFillParentInfo_WFInstance(et,(net.ibizsys.psrt.srv.wf.entity.WFInstance) entity);
            }
        }
        if(et.getWFStepActorId()!=null) {
            IEntity entity = cloneSession.getEntity("WFSTEPACTOR",et.getWFStepActorId());
            if(entity !=null) {
                onFillParentInfo_WFStepActor(et,(net.ibizsys.psrt.srv.wf.entity.WFStepActor) entity);
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
    protected void onRemoveEntityUncopyValues(WFAssistWork et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFAssistWork  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 工作流代办工作标识
        entityFieldError = onCheckField_WFAssistWorkId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流代办工作名称
        entityFieldError = onCheckField_WFAssistWorkName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 流程实例
        entityFieldError = onCheckField_WFInstanceId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 流程步骤名称
        entityFieldError = onCheckField_WFPLogicName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 步骤操作者
        entityFieldError = onCheckField_WFStepActorId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 流程步骤标识
        entityFieldError = onCheckField_WFStepId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流
        entityFieldError = onCheckField_WFWorkflowId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[WFAssistWorkId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFAssistWorkId(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFAssistWorkIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFASSISTWORKID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFAssistWorkId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFAssistWork.FIELD_WFASSISTWORKID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFAssistWorkId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFASSISTWORKID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFAssistWorkName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFAssistWorkName(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFAssistWorkNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFASSISTWORKNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFAssistWorkName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFAssistWork.FIELD_WFASSISTWORKNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFAssistWorkName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFASSISTWORKNAME);
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
    protected EntityFieldError onCheckField_WFInstanceId(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFInstanceIdDirty()) {
            return null;
        }

        String value = et.getWFInstanceId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFInstanceId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFINSTANCEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFPLogicName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFPLogicName(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFPLogicNameDirty()) {
            return null;
        }

        String value = et.getWFPLogicName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFPLogicName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFPLOGICNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStepActorId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStepActorId(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepActorIdDirty()) {
            return null;
        }

        String value = et.getWFStepActorId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepActorId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFSTEPACTORID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStepId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStepId(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepIdDirty()) {
            return null;
        }

        String value = et.getWFStepId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFSTEPID);
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
    protected EntityFieldError onCheckField_WFWorkflowId(boolean bBaseMode,WFAssistWork et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFAssistWork.FIELD_WFWORKFLOWID);
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
    protected void onSyncEntity(WFAssistWork et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFAssistWork et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFAssistWork et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_ACTIVESTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ActiveStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_USERDATA,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_USERDATA4,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData4_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFASSISTWORKID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFAssistWorkId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFASSISTWORKNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFAssistWorkName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFINSTANCEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFInstanceId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFINSTANCENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFInstanceName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFPLOGICNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFPLogicName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFSTEPACTORID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepActorId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFSTEPACTORNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepActorName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFSTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFWORKFLOWID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFWorkflowId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFAssistWork.FIELD_WFWORKFLOWNAME,true)==0)
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
     * 判断值规则[USERDATA][默认规则]
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
     * 判断值规则[USERDATA4][默认规则]
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
     * 判断值规则[工作流代办工作标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFAssistWorkId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFASSISTWORKID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流代办工作名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFAssistWorkName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFASSISTWORKNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[流程实例][默认规则]
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
     * 判断值规则[流程实例][默认规则]
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
     * 判断值规则[流程步骤名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFPLogicName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFPLOGICNAME", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[步骤操作者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepActorId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPACTORID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[步骤操作者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepActorName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPACTORNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[流程步骤标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流][默认规则]
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
     * 判断值规则[工作流][默认规则]
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFAssistWork et) throws Exception {
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
    protected void onUpdateParent(WFAssistWork et)throws Exception {
        super.onUpdateParent(et);
    }


}