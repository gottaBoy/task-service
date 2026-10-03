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



import net.ibizsys.psrt.srv.wf.entity.WFTmpStepActor;
import net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFTmpStepActorDEModel;

/**
 * 实体[WFTmpStepActor] 服务对象基类
 */
public abstract class WFTmpStepActorServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFTmpStepActor> {
    private static final Log log = LogFactory.getLog(WFTmpStepActorServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WFTmpStepActorServiceBase () {
        super();

    }

    /**
     * 获取实体[WFTmpStepActor]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFTmpStepActorService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFTmpStepActor]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFTmpStepActorService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFTmpStepActorService)ServiceGlobal.getService(WFTmpStepActorService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService";
    }

    private WFTmpStepActorDEModel wFTmpStepActorDEModel;
    /**
     * 获取实体[WFTmpStepActor]模型对象
     */
    public  WFTmpStepActorDEModel getWFTmpStepActorDEModel() {
        if(this.wFTmpStepActorDEModel==null) {
            try {
                this.wFTmpStepActorDEModel = (WFTmpStepActorDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFTmpStepActorDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFTmpStepActorDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFTmpStepActorDEModel();
    }


    private WFTmpStepActorDAO wFTmpStepActorDAO;

    /**
     * 获取实体[WFTmpStepActor]数据操作对象
     */
    public  WFTmpStepActorDAO getWFTmpStepActorDAO() {
        if(this.wFTmpStepActorDAO==null) {
            try {
                this.wFTmpStepActorDAO= (WFTmpStepActorDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFTmpStepActorDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFTmpStepActorDAO();
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
    protected void onFillParentInfo(WFTmpStepActor et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WFACTOR / 工作流操作者
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFActorService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFActor)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFActor.FIELD_WFACTORID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFActor(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFSTEP / 工作流步骤
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFStep)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFStep.FIELD_WFSTEPID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFStep(et,parentEntity );
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
    * 填充数据的父数据信息[工作流操作者]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFActor(WFTmpStepActor et,net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {
        et.setWFActorId(parentEntity.getWFActorId());
        et.setWFActorName(parentEntity.getWFActorName());
    }

    /**
    * 填充数据的父数据信息[工作流步骤]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFStep(WFTmpStepActor et,net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        et.setPrevWFStepId(parentEntity.getWFStepId());
        et.setPrevWFStepName(parentEntity.getWFPLogicName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFTmpStepActor et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getWFTmpStepActorName()==null) {
                et.setWFTmpStepActorName((String)DefaultValueHelper.getValue(this.getWebContext(),"","工作流步骤操作者（临时）",25));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WFACTOR / 工作流操作者
        onFillEntityFullInfo_WFActor(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFSTEP / 工作流步骤
        onFillEntityFullInfo_WFStep(et, bCreate);
    }

    /**
    * 填充实体的数据信息 工作流操作者
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFActor(WFTmpStepActor et, boolean bCreate) throws Exception {
        if(et.isWFActorIdDirty()) {
            if(et.getWFActorId()!=null) {
                if((true&&et.getWFActorId()==null)||(true&&et.getWFActorName()==null)) {
                    net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity  = et.getWFActor();
                    et.setWFActorName(parentEntity.getWFActorName());
                }

            } else {
                et.setWFActorName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 工作流步骤
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFStep(WFTmpStepActor et, boolean bCreate) throws Exception {
        if(et.isPrevWFStepIdDirty()) {
            if(et.getPrevWFStepId()!=null) {
                if((true&&et.getPrevWFStepId()==null)||(true&&et.getPrevWFStepName()==null)) {
                    net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity  = et.getWFStep();
                    et.setPrevWFStepName(parentEntity.getWFPLogicName());
                }

            } else {
                et.setPrevWFStepName(null);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFTmpStepActor et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[工作流操作者]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFTmpStepActor> selectByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActorBase parentEntity) throws Exception {
        return selectByWFActor( parentEntity,"");
    }
    /**
     * 通过关系[工作流操作者]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFTmpStepActor> selectByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActorBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFTmpStepActor.FIELD_WFACTORID, parentEntity.getWFActorId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFActorCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流操作者]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFActorCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流步骤]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFTmpStepActor> selectByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStepBase parentEntity) throws Exception {
        return selectByWFStep( parentEntity,"");
    }
    /**
     * 通过关系[工作流步骤]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFTmpStepActor> selectByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStepBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFTmpStepActor.FIELD_PREVWFSTEPID, parentEntity.getWFStepId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFStepCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流步骤]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFStepCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[工作流操作者]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {
        java.util.ArrayList<WFTmpStepActor> list =  this.selectByWFActor(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFACTOR");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID","" ,parentDEModel.getName(),"WFTMPSTEPACTOR",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[工作流操作者]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {
        java.util.ArrayList<WFTmpStepActor> list =  this.selectByWFActor(parentEntity);
        for(WFTmpStepActor item:list) {
            WFTmpStepActor item2 = (WFTmpStepActor)getDEModel().createEntity();
            item2.setWFTmpStepActorId(item.getWFTmpStepActorId());
            item2.setWFActorId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流操作者]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFActor(parentEntity2);
                internalRemoveByWFActor(parentEntity2);
                onAfterRemoveByWFActor(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流操作者]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流操作者]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {
        java.util.ArrayList<WFTmpStepActor> removeList = selectByWFActor(parentEntity);
        onBeforeRemoveByWFActor(parentEntity,removeList );

        // 执行删除
        for (WFTmpStepActor item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFActor(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流操作者]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流操作者]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity,java.util.ArrayList<WFTmpStepActor> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流操作者]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFActor(net.ibizsys.psrt.srv.wf.entity.WFActor parentEntity,java.util.ArrayList<WFTmpStepActor> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流步骤]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        java.util.ArrayList<WFTmpStepActor> list =  this.selectByWFStep(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFSTEP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID","" ,parentDEModel.getName(),"WFTMPSTEPACTOR",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[工作流步骤]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        java.util.ArrayList<WFTmpStepActor> list =  this.selectByWFStep(parentEntity);
        for(WFTmpStepActor item:list) {
            WFTmpStepActor item2 = (WFTmpStepActor)getDEModel().createEntity();
            item2.setWFTmpStepActorId(item.getWFTmpStepActorId());
            item2.setPrevWFStepId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流步骤]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFStep(parentEntity2);
                internalRemoveByWFStep(parentEntity2);
                onAfterRemoveByWFStep(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流步骤]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流步骤]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        java.util.ArrayList<WFTmpStepActor> removeList = selectByWFStep(parentEntity);
        onBeforeRemoveByWFStep(parentEntity,removeList );

        // 执行删除
        for (WFTmpStepActor item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFStep(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流步骤]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流步骤]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity,java.util.ArrayList<WFTmpStepActor> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流步骤]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFStep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity,java.util.ArrayList<WFTmpStepActor> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFTmpStepActor et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFTmpStepActor et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWFActorId()!=null) {
            IEntity entity = cloneSession.getEntity("WFACTOR",et.getWFActorId());
            if(entity !=null) {
                onFillParentInfo_WFActor(et,(net.ibizsys.psrt.srv.wf.entity.WFActor) entity);
            }
        }
        if(et.getPrevWFStepId()!=null) {
            IEntity entity = cloneSession.getEntity("WFSTEP",et.getPrevWFStepId());
            if(entity !=null) {
                onFillParentInfo_WFStep(et,(net.ibizsys.psrt.srv.wf.entity.WFStep) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(WFTmpStepActor et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFTmpStepActor  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 操作连接
        entityFieldError = onCheckField_Connection( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 备注
        entityFieldError = onCheckField_Memo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 上一个处理
        entityFieldError = onCheckField_PrevProcess( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流临时步骤操作者（上一步骤）
        entityFieldError = onCheckField_PrevWFStepId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流临时步骤操作者（上一步骤）
        entityFieldError = onCheckField_PrevWFStepName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流临时步骤操作者_工作流操作者
        entityFieldError = onCheckField_WFActorId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流临时步骤操作者_工作流操作者
        entityFieldError = onCheckField_WFActorName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流步骤操作者（临时）标识
        entityFieldError = onCheckField_WFTmpStepActorId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流步骤操作者（临时）名称
        entityFieldError = onCheckField_WFTmpStepActorName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[Connection]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Connection(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isConnectionDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_CONNECTION);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getConnection();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFTmpStepActor.FIELD_CONNECTION);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Connection_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_CONNECTION);
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
    protected EntityFieldError onCheckField_Memo(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_MEMO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PrevProcess]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PrevProcess(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPrevProcessDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_PREVPROCESS);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getPrevProcess();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFTmpStepActor.FIELD_PREVPROCESS);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PrevProcess_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_PREVPROCESS);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PrevWFStepId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PrevWFStepId(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPrevWFStepIdDirty()) {
            return null;
        }

        String value = et.getPrevWFStepId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PrevWFStepId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_PREVWFSTEPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PrevWFStepName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PrevWFStepName(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPrevWFStepNameDirty()) {
            return null;
        }

        String value = et.getPrevWFStepName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PrevWFStepName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_PREVWFSTEPNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFActorId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFActorId(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFActorIdDirty()) {
            return null;
        }

        String value = et.getWFActorId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFActorId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFACTORID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFActorName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFActorName(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFActorNameDirty()) {
            return null;
        }

        String value = et.getWFActorName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFActorName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFACTORNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFTmpStepActorId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFTmpStepActorId(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFTmpStepActorIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFTMPSTEPACTORID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFTmpStepActorId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFTMPSTEPACTORID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFTmpStepActorId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFTMPSTEPACTORID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFTmpStepActorName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFTmpStepActorName(boolean bBaseMode,WFTmpStepActor et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFTmpStepActorNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFTMPSTEPACTORNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFTmpStepActorName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFTMPSTEPACTORNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFTmpStepActorName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFTmpStepActor.FIELD_WFTMPSTEPACTORNAME);
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
    protected void onSyncEntity(WFTmpStepActor et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFTmpStepActor et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFTmpStepActor et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_CONNECTION,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Connection_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_MEMO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Memo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_PREVPROCESS,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PrevProcess_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_PREVWFSTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PrevWFStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_PREVWFSTEPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PrevWFStepName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_WFACTORID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFActorId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_WFACTORNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFActorName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_WFTMPSTEPACTORID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFTmpStepActorId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFTmpStepActor.FIELD_WFTMPSTEPACTORNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFTmpStepActorName_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[操作连接][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Connection_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("CONNECTION", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
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
     * 判断值规则[备注][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Memo_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MEMO", et, bTempMode,null,false,500,true,"内容长度必须小于等于[500]",false)))
                return null;
            return "内容长度必须小于等于[500]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[上一个处理][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PrevProcess_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PREVPROCESS", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流临时步骤操作者（上一步骤）][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PrevWFStepId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PREVWFSTEPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流临时步骤操作者（上一步骤）][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PrevWFStepName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PREVWFSTEPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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

    /**
     * 判断值规则[工作流临时步骤操作者_工作流操作者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFActorId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFACTORID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流临时步骤操作者_工作流操作者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFActorName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFACTORNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流步骤操作者（临时）标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFTmpStepActorId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFTMPSTEPACTORID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流步骤操作者（临时）名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFTmpStepActorName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFTMPSTEPACTORNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFTmpStepActor et) throws Exception {
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
    protected void onUpdateParent(WFTmpStepActor et)throws Exception {
        super.onUpdateParent(et);
    }


}