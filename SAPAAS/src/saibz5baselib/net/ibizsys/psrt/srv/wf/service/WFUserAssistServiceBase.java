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



import net.ibizsys.psrt.srv.wf.entity.WFUserAssist;
import net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel;

/**
 * 实体[WFUserAssist] 服务对象基类
 */
public abstract class WFUserAssistServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFUserAssist> {
    private static final Log log = LogFactory.getLog(WFUserAssistServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WFUserAssistServiceBase () {
        super();

    }

    /**
     * 获取实体[WFUserAssist]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFUserAssistService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFUserAssist]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFUserAssistService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFUserAssistService)ServiceGlobal.getService(WFUserAssistService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wf.service.WFUserAssistService";
    }

    private WFUserAssistDEModel wFUserAssistDEModel;
    /**
     * 获取实体[WFUserAssist]模型对象
     */
    public  WFUserAssistDEModel getWFUserAssistDEModel() {
        if(this.wFUserAssistDEModel==null) {
            try {
                this.wFUserAssistDEModel = (WFUserAssistDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFUserAssistDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFUserAssistDEModel();
    }


    private WFUserAssistDAO wFUserAssistDAO;

    /**
     * 获取实体[WFUserAssist]数据操作对象
     */
    public  WFUserAssistDAO getWFUserAssistDAO() {
        if(this.wFUserAssistDAO==null) {
            try {
                this.wFUserAssistDAO= (WFUserAssistDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFUserAssistDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFUserAssistDAO();
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






    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillParentInfo(net.ibizsys.paas.entity.IEntity, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    protected void onFillParentInfo(WFUserAssist et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFUser)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFUser.FIELD_WFUSERID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFMajorUser(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFUser)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFUser.FIELD_WFUSERID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFMinorUser(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFWORKFLOW / 工作流配置
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID", true)==0)) {
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
    * 填充数据的父数据信息[工作流用户]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFMajorUser(WFUserAssist et,net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        et.setWFMajorUserId(parentEntity.getWFUserId());
        et.setWFMajorUserName(parentEntity.getWFUserName());
    }

    /**
    * 填充数据的父数据信息[工作流用户]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFMinorUser(WFUserAssist et,net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        et.setWFMinorUserId(parentEntity.getWFUserId());
        et.setWFMinorUserName(parentEntity.getWFUserName());
    }

    /**
    * 填充数据的父数据信息[工作流配置]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFWorkflow(WFUserAssist et,net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity) throws Exception {
        et.setWFWorkflowId(parentEntity.getWFWorkflowId());
        et.setWFWorkflowName(parentEntity.getWFWorkflowName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFUserAssist et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        onFillEntityFullInfo_WFMajorUser(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        onFillEntityFullInfo_WFMinorUser(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFWORKFLOW / 工作流配置
        onFillEntityFullInfo_WFWorkflow(et, bCreate);
    }

    /**
    * 填充实体的数据信息 工作流用户
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFMajorUser(WFUserAssist et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流用户
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFMinorUser(WFUserAssist et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流配置
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFWorkflow(WFUserAssist et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFUserAssist et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFUserAssist> selectByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity) throws Exception {
        return selectByWFMajorUser( parentEntity,"");
    }
    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFUserAssist> selectByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFUserAssist.FIELD_WFMAJORUSERID, parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFMajorUserCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流用户]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFMajorUserCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFUserAssist> selectByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity) throws Exception {
        return selectByWFMinorUser( parentEntity,"");
    }
    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFUserAssist> selectByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFUserAssist.FIELD_WFMINORUSERID, parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFMinorUserCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流用户]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFMinorUserCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流配置]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFUserAssist> selectByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase parentEntity) throws Exception {
        return selectByWFWorkflow( parentEntity,"");
    }
    /**
     * 通过关系[工作流配置]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFUserAssist> selectByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflowBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFUserAssist.FIELD_WFWORKFLOWID, parentEntity.getWFWorkflowId());
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
     * 判断是否能够通过关系[工作流用户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
    }


    /**
     * 通过关系[工作流用户]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        java.util.ArrayList<WFUserAssist> list =  this.selectByWFMajorUser(parentEntity);
        for(WFUserAssist item:list) {
            WFUserAssist item2 = (WFUserAssist)getDEModel().createEntity();
            item2.setWFUserAssistId(item.getWFUserAssistId());
            item2.setWFMajorUserId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流用户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFMajorUser(parentEntity2);
                internalRemoveByWFMajorUser(parentEntity2);
                onAfterRemoveByWFMajorUser(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流用户]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流用户]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        java.util.ArrayList<WFUserAssist> removeList = selectByWFMajorUser(parentEntity);
        onBeforeRemoveByWFMajorUser(parentEntity,removeList );

        // 执行删除
        for (WFUserAssist item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFMajorUser(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFUserAssist> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFMajorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFUserAssist> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流用户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
    }


    /**
     * 通过关系[工作流用户]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        java.util.ArrayList<WFUserAssist> list =  this.selectByWFMinorUser(parentEntity);
        for(WFUserAssist item:list) {
            WFUserAssist item2 = (WFUserAssist)getDEModel().createEntity();
            item2.setWFUserAssistId(item.getWFUserAssistId());
            item2.setWFMinorUserId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流用户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFMinorUser(parentEntity2);
                internalRemoveByWFMinorUser(parentEntity2);
                onAfterRemoveByWFMinorUser(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流用户]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流用户]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        java.util.ArrayList<WFUserAssist> removeList = selectByWFMinorUser(parentEntity);
        onBeforeRemoveByWFMinorUser(parentEntity,removeList );

        // 执行删除
        for (WFUserAssist item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFMinorUser(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFUserAssist> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFMinorUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFUserAssist> removeList) throws Exception {

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
        java.util.ArrayList<WFUserAssist> list =  this.selectByWFWorkflow(parentEntity);
        for(WFUserAssist item:list) {
            WFUserAssist item2 = (WFUserAssist)getDEModel().createEntity();
            item2.setWFUserAssistId(item.getWFUserAssistId());
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
        java.util.ArrayList<WFUserAssist> removeList = selectByWFWorkflow(parentEntity);
        onBeforeRemoveByWFWorkflow(parentEntity,removeList );

        // 执行删除
        for (WFUserAssist item : removeList ) {
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
    protected void onBeforeRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity,java.util.ArrayList<WFUserAssist> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流配置]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFWorkflow(net.ibizsys.psrt.srv.wf.entity.WFWorkflow parentEntity,java.util.ArrayList<WFUserAssist> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFUserAssist et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFUserAssist et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWFMajorUserId()!=null) {
            IEntity entity = cloneSession.getEntity("WFUSER",et.getWFMajorUserId());
            if(entity !=null) {
                onFillParentInfo_WFMajorUser(et,(net.ibizsys.psrt.srv.wf.entity.WFUser) entity);
            }
        }
        if(et.getWFMinorUserId()!=null) {
            IEntity entity = cloneSession.getEntity("WFUSER",et.getWFMinorUserId());
            if(entity !=null) {
                onFillParentInfo_WFMinorUser(et,(net.ibizsys.psrt.srv.wf.entity.WFUser) entity);
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
    protected void onRemoveEntityUncopyValues(WFUserAssist et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFUserAssist  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 备注
        entityFieldError = onCheckField_Memo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流用户
        entityFieldError = onCheckField_WFMajorUserId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流代办用户
        entityFieldError = onCheckField_WFMinorUserId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 代办步骤
        entityFieldError = onCheckField_WFStep( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流用户代办标识
        entityFieldError = onCheckField_WFUserAssistId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流用户代办名称
        entityFieldError = onCheckField_WFUserAssistName( bBaseMode,  et,  bCreate,  bTempMode);
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
     * 获取属性[Memo]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Memo(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFUserAssist.FIELD_MEMO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFMajorUserId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFMajorUserId(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFMajorUserIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFMAJORUSERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFMajorUserId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFUserAssist.FIELD_WFMAJORUSERID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFMajorUserId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFMAJORUSERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFMinorUserId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFMinorUserId(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFMinorUserIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFMINORUSERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFMinorUserId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFUserAssist.FIELD_WFMINORUSERID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFMinorUserId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFMINORUSERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStep]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStep(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepDirty()) {
            return null;
        }

        String value = et.getWFStep();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStep_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFSTEP);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserAssistId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserAssistId(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserAssistIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFUSERASSISTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFUserAssistId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFUserAssist.FIELD_WFUSERASSISTID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserAssistId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFUSERASSISTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserAssistName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserAssistName(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserAssistNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFUSERASSISTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFUserAssistName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFUserAssist.FIELD_WFUSERASSISTNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserAssistName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFUSERASSISTNAME);
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
    protected EntityFieldError onCheckField_WFWorkflowId(boolean bBaseMode,WFUserAssist et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFUserAssist.FIELD_WFWORKFLOWID);
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
    protected void onSyncEntity(WFUserAssist et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFUserAssist et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFUserAssist et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_MEMO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Memo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFMAJORUSERID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFMajorUserId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFMAJORUSERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFMajorUserName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFMINORUSERID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFMinorUserId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFMINORUSERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFMinorUserName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFSTEP,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStep_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFUSERASSISTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserAssistId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFUSERASSISTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserAssistName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFWORKFLOWID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFWorkflowId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserAssist.FIELD_WFWORKFLOWNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFWorkflowName_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
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
     * 判断值规则[备注][默认规则]
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
     * 判断值规则[工作流用户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFMajorUserId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFMAJORUSERID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流用户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFMajorUserName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFMAJORUSERNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流代办用户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFMinorUserId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFMINORUSERID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流代办用户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFMinorUserName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFMINORUSERNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[代办步骤][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStep_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEP", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流用户代办标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserAssistId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERASSISTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流用户代办名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserAssistName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERASSISTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFUserAssist et) throws Exception {
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
    protected void onUpdateParent(WFUserAssist et)throws Exception {
        super.onUpdateParent(et);
    }


}