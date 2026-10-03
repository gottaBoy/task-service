/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.service;

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



import net.ibizsys.psrt.srv.common.entity.TSSDTaskPolicy;
import net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO;
import net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel;

/**
 * 实体[TSSDTaskPolicy] 服务对象基类
 */
public abstract class TSSDTaskPolicyServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<TSSDTaskPolicy> {
    private static final Log log = LogFactory.getLog(TSSDTaskPolicyServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public TSSDTaskPolicyServiceBase () {
        super();

    }

    /**
     * 获取实体[TSSDTaskPolicy]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static TSSDTaskPolicyService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[TSSDTaskPolicy]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static TSSDTaskPolicyService getInstance(SessionFactory sessionFactory) throws Exception {
        return (TSSDTaskPolicyService)ServiceGlobal.getService(TSSDTaskPolicyService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService";
    }

    private TSSDTaskPolicyDEModel tSSDTaskPolicyDEModel;
    /**
     * 获取实体[TSSDTaskPolicy]模型对象
     */
    public  TSSDTaskPolicyDEModel getTSSDTaskPolicyDEModel() {
        if(this.tSSDTaskPolicyDEModel==null) {
            try {
                this.tSSDTaskPolicyDEModel = (TSSDTaskPolicyDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel");
            } catch(Exception ex) {
            }
        }
        return this.tSSDTaskPolicyDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getTSSDTaskPolicyDEModel();
    }


    private TSSDTaskPolicyDAO tSSDTaskPolicyDAO;

    /**
     * 获取实体[TSSDTaskPolicy]数据操作对象
     */
    public  TSSDTaskPolicyDAO getTSSDTaskPolicyDAO() {
        if(this.tSSDTaskPolicyDAO==null) {
            try {
                this.tSSDTaskPolicyDAO= (TSSDTaskPolicyDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.tSSDTaskPolicyDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getTSSDTaskPolicyDAO();
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
    protected void onFillParentInfo(TSSDTaskPolicy et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :TSSDPOLICY / 任务时刻策略
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDPolicyService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity = ( net.ibizsys.psrt.srv.common.entity.TSSDPolicy)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.TSSDPolicy.FIELD_TSSDPOLICYID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_TSSDPolicy(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :TSSDTASK / 任务调度任务项
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity = ( net.ibizsys.psrt.srv.common.entity.TSSDTask)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.TSSDTask.FIELD_TSSDTASKID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_TSSDTask(et,parentEntity );
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
    * 填充数据的父数据信息[任务时刻策略]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_TSSDPolicy(TSSDTaskPolicy et,net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {
        et.setTSSDPolicyId(parentEntity.getTSSDPolicyId());
        et.setTSSDPolicyName(parentEntity.getTSSDPolicyName());
    }

    /**
    * 填充数据的父数据信息[任务调度任务项]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_TSSDTask(TSSDTaskPolicy et,net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {
        et.setTSSDTaskId(parentEntity.getTSSDTaskId());
        et.setTSSDTaskName(parentEntity.getTSSDTaskName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(TSSDTaskPolicy et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :TSSDPOLICY / 任务时刻策略
        onFillEntityFullInfo_TSSDPolicy(et, bCreate);
        //关系类型 : DER1N ,主实体 :TSSDTASK / 任务调度任务项
        onFillEntityFullInfo_TSSDTask(et, bCreate);
    }

    /**
    * 填充实体的数据信息 任务时刻策略
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_TSSDPolicy(TSSDTaskPolicy et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 任务调度任务项
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_TSSDTask(TSSDTaskPolicy et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(TSSDTaskPolicy et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[任务时刻策略]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<TSSDTaskPolicy> selectByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicyBase parentEntity) throws Exception {
        return selectByTSSDPolicy( parentEntity,"");
    }
    /**
     * 通过关系[任务时刻策略]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<TSSDTaskPolicy> selectByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicyBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(TSSDTaskPolicy.FIELD_TSSDPOLICYID, parentEntity.getTSSDPolicyId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByTSSDPolicyCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[任务时刻策略]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByTSSDPolicyCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[任务调度任务项]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<TSSDTaskPolicy> selectByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTaskBase parentEntity) throws Exception {
        return selectByTSSDTask( parentEntity,"");
    }
    /**
     * 通过关系[任务调度任务项]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<TSSDTaskPolicy> selectByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTaskBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(TSSDTaskPolicy.FIELD_TSSDTASKID, parentEntity.getTSSDTaskId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByTSSDTaskCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[任务调度任务项]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByTSSDTaskCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[任务时刻策略]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {
    }


    /**
     * 通过关系[任务时刻策略]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {
        java.util.ArrayList<TSSDTaskPolicy> list =  this.selectByTSSDPolicy(parentEntity);
        for(TSSDTaskPolicy item:list) {
            TSSDTaskPolicy item2 = (TSSDTaskPolicy)getDEModel().createEntity();
            item2.setTSSDTaskPolicyId(item.getTSSDTaskPolicyId());
            item2.setTSSDPolicyId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[任务时刻策略]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByTSSDPolicy(parentEntity2);
                internalRemoveByTSSDPolicy(parentEntity2);
                onAfterRemoveByTSSDPolicy(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[任务时刻策略]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[任务时刻策略]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {
        java.util.ArrayList<TSSDTaskPolicy> removeList = selectByTSSDPolicy(parentEntity);
        onBeforeRemoveByTSSDPolicy(parentEntity,removeList );

        // 执行删除
        for (TSSDTaskPolicy item : removeList ) {
            remove(item );
        }
        onAfterRemoveByTSSDPolicy(parentEntity,removeList );
    }

    /**
     * 通过关系[任务时刻策略]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity,java.util.ArrayList<TSSDTaskPolicy> removeList) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDPolicy(net.ibizsys.psrt.srv.common.entity.TSSDPolicy parentEntity,java.util.ArrayList<TSSDTaskPolicy> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[任务调度任务项]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {
    }


    /**
     * 通过关系[任务调度任务项]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {
        java.util.ArrayList<TSSDTaskPolicy> list =  this.selectByTSSDTask(parentEntity);
        for(TSSDTaskPolicy item:list) {
            TSSDTaskPolicy item2 = (TSSDTaskPolicy)getDEModel().createEntity();
            item2.setTSSDTaskPolicyId(item.getTSSDTaskPolicyId());
            item2.setTSSDTaskId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[任务调度任务项]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByTSSDTask(parentEntity2);
                internalRemoveByTSSDTask(parentEntity2);
                onAfterRemoveByTSSDTask(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[任务调度任务项]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[任务调度任务项]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {
        java.util.ArrayList<TSSDTaskPolicy> removeList = selectByTSSDTask(parentEntity);
        onBeforeRemoveByTSSDTask(parentEntity,removeList );

        // 执行删除
        for (TSSDTaskPolicy item : removeList ) {
            remove(item );
        }
        onAfterRemoveByTSSDTask(parentEntity,removeList );
    }

    /**
     * 通过关系[任务调度任务项]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity) throws Exception {

    }

    /**
     * 通过关系[任务调度任务项]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity,java.util.ArrayList<TSSDTaskPolicy> removeList) throws Exception {

    }

    /**
     * 通过关系[任务调度任务项]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDTask(net.ibizsys.psrt.srv.common.entity.TSSDTask parentEntity,java.util.ArrayList<TSSDTaskPolicy> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(TSSDTaskPolicy et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(TSSDTaskPolicy et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getTSSDPolicyId()!=null) {
            IEntity entity = cloneSession.getEntity("TSSDPOLICY",et.getTSSDPolicyId());
            if(entity !=null) {
                onFillParentInfo_TSSDPolicy(et,(net.ibizsys.psrt.srv.common.entity.TSSDPolicy) entity);
            }
        }
        if(et.getTSSDTaskId()!=null) {
            IEntity entity = cloneSession.getEntity("TSSDTASK",et.getTSSDTaskId());
            if(entity !=null) {
                onFillParentInfo_TSSDTask(et,(net.ibizsys.psrt.srv.common.entity.TSSDTask) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(TSSDTaskPolicy et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,TSSDTaskPolicy  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 保留字段
        entityFieldError = onCheckField_Reserver( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 保留字段2
        entityFieldError = onCheckField_Reserver2( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 保留字段3
        entityFieldError = onCheckField_Reserver3( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 保留字段4
        entityFieldError = onCheckField_Reserver4( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 任务运行策略
        entityFieldError = onCheckField_TSSDPolicyId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 调度任务
        entityFieldError = onCheckField_TSSDTaskId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 调度任务项策略标识
        entityFieldError = onCheckField_TSSDTaskPolicyId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 调度任务项策略名称
        entityFieldError = onCheckField_TSSDTaskPolicyName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[Reserver]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isReserverDirty()) {
            return null;
        }

        String value = et.getReserver();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Reserver_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_RESERVER);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Reserver2]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isReserver2Dirty()) {
            return null;
        }

        String value = et.getReserver2();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Reserver2_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_RESERVER2);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Reserver3]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isReserver3Dirty()) {
            return null;
        }

        String value = et.getReserver3();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Reserver3_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_RESERVER3);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Reserver4]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isReserver4Dirty()) {
            return null;
        }

        String value = et.getReserver4();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Reserver4_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_RESERVER4);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDPolicyId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDPolicyId(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDPolicyIdDirty()) {
            return null;
        }

        String value = et.getTSSDPolicyId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDPolicyId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDPOLICYID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDTaskId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDTaskId(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDTaskIdDirty()) {
            return null;
        }

        String value = et.getTSSDTaskId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDTaskId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDTaskPolicyId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDTaskPolicyId(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDTaskPolicyIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKPOLICYID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getTSSDTaskPolicyId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKPOLICYID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDTaskPolicyId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKPOLICYID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDTaskPolicyName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDTaskPolicyName(boolean bBaseMode,TSSDTaskPolicy et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDTaskPolicyNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKPOLICYNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getTSSDTaskPolicyName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKPOLICYNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDTaskPolicyName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDTaskPolicy.FIELD_TSSDTASKPOLICYNAME);
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
    protected void onSyncEntity(TSSDTaskPolicy et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(TSSDTaskPolicy et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(TSSDTaskPolicy et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        IEntity tSSDTask =et.getTSSDTask();
        if(tSSDTask!=null) {
            if(tSSDTask.contains(strField)) {
                return tSSDTask.get(strField);
            }
        }
        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_RESERVER,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_RESERVER2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_RESERVER3,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver3_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_RESERVER4,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver4_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_TSSDPOLICYID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDPolicyId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_TSSDPOLICYNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDPolicyName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_TSSDTASKID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDTaskId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_TSSDTASKNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDTaskName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_TSSDTASKPOLICYID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDTaskPolicyId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_TSSDTASKPOLICYNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDTaskPolicyName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDTaskPolicy.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);

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
     * 判断值规则[保留字段][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Reserver_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESERVER", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[保留字段2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Reserver2_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESERVER2", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[保留字段3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Reserver3_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESERVER3", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[保留字段4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Reserver4_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESERVER4", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务运行策略][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDPolicyId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDPOLICYID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务运行策略][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDPolicyName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDPOLICYNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[调度任务][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDTaskId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDTASKID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[调度任务][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDTaskName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDTASKNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[调度任务项策略标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDTaskPolicyId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDTASKPOLICYID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[调度任务项策略名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDTaskPolicyName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDTASKPOLICYNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
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



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onMergeChild(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, TSSDTaskPolicy et) throws Exception {
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
    protected void onUpdateParent(TSSDTaskPolicy et)throws Exception {
        super.onUpdateParent(et);
    }


}