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



import net.ibizsys.psrt.srv.wf.entity.WFReminder;
import net.ibizsys.psrt.srv.wf.dao.WFReminderDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel;

/**
 * 实体[WFReminder] 服务对象基类
 */
public abstract class WFReminderServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFReminder> {
    private static final Log log = LogFactory.getLog(WFReminderServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WFReminderServiceBase () {
        super();

    }

    /**
     * 获取实体[WFReminder]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFReminderService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFReminder]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFReminderService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFReminderService)ServiceGlobal.getService(WFReminderService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wf.service.WFReminderService";
    }

    private WFReminderDEModel wFReminderDEModel;
    /**
     * 获取实体[WFReminder]模型对象
     */
    public  WFReminderDEModel getWFReminderDEModel() {
        if(this.wFReminderDEModel==null) {
            try {
                this.wFReminderDEModel = (WFReminderDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFReminderDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFReminderDEModel();
    }


    private WFReminderDAO wFReminderDAO;

    /**
     * 获取实体[WFReminder]数据操作对象
     */
    public  WFReminderDAO getWFReminderDAO() {
        if(this.wFReminderDAO==null) {
            try {
                this.wFReminderDAO= (WFReminderDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFReminderDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFReminderDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFReminderDAO();
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
    protected void onFillParentInfo(WFReminder et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WFSTEPACTOR / 工作流步骤操作者
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID", true)==0)) {
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
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFREMINDER_WFUSER_WFUSERID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFUser)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFUser.FIELD_WFUSERID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFUser(et,parentEntity );
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
    * 填充数据的父数据信息[工作流步骤操作者]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFStepActor(WFReminder et,net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity) throws Exception {
        et.setActorId(parentEntity.getActorId());
        et.setReminderCount(parentEntity.getReminderCount());
        et.setWFCreateDate(parentEntity.getCreateDate());
        et.setWFStepActorId(parentEntity.getWFStepActorId());
        et.setWFStepActorName(parentEntity.getWFStepActorName());
    }

    /**
    * 填充数据的父数据信息[工作流用户]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFUser(WFReminder et,net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        et.setWFUserId(parentEntity.getWFUserId());
        et.setWFUserName(parentEntity.getWFUserName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFReminder et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WFSTEPACTOR / 工作流步骤操作者
        onFillEntityFullInfo_WFStepActor(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        onFillEntityFullInfo_WFUser(et, bCreate);
    }

    /**
    * 填充实体的数据信息 工作流步骤操作者
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFStepActor(WFReminder et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流用户
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFUser(WFReminder et, boolean bCreate) throws Exception {
        if(et.isWFUserIdDirty()) {
            if(et.getWFUserId()!=null) {
                if((true&&et.getWFUserId()==null)||(true&&et.getWFUserName()==null)) {
                    net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity  = et.getWFUser();
                    et.setWFUserName(parentEntity.getWFUserName());
                }

            } else {
                et.setWFUserName(null);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFReminder et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[工作流步骤操作者]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFReminder> selectByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActorBase parentEntity) throws Exception {
        return selectByWFStepActor( parentEntity,"");
    }
    /**
     * 通过关系[工作流步骤操作者]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFReminder> selectByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActorBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFReminder.FIELD_WFSTEPACTORID, parentEntity.getWFStepActorId());
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
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFReminder> selectByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity) throws Exception {
        return selectByWFUser( parentEntity,"");
    }
    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFReminder> selectByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFReminder.FIELD_WFUSERID, parentEntity.getWFUserId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFUserCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流用户]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFUserCond(SelectCond selectCond) throws Exception {

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
        java.util.ArrayList<WFReminder> list =  this.selectByWFStepActor(parentEntity);
        for(WFReminder item:list) {
            WFReminder item2 = (WFReminder)getDEModel().createEntity();
            item2.setWFReminderId(item.getWFReminderId());
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
        java.util.ArrayList<WFReminder> removeList = selectByWFStepActor(parentEntity);
        onBeforeRemoveByWFStepActor(parentEntity,removeList );

        // 执行删除
        for (WFReminder item : removeList ) {
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
    protected void onBeforeRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity,java.util.ArrayList<WFReminder> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流步骤操作者]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFStepActor(net.ibizsys.psrt.srv.wf.entity.WFStepActor parentEntity,java.util.ArrayList<WFReminder> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流用户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
    }


    /**
     * 通过关系[工作流用户]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        java.util.ArrayList<WFReminder> list =  this.selectByWFUser(parentEntity);
        for(WFReminder item:list) {
            WFReminder item2 = (WFReminder)getDEModel().createEntity();
            item2.setWFReminderId(item.getWFReminderId());
            item2.setWFUserId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流用户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFUser(parentEntity2);
                internalRemoveByWFUser(parentEntity2);
                onAfterRemoveByWFUser(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流用户]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流用户]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        java.util.ArrayList<WFReminder> removeList = selectByWFUser(parentEntity);
        onBeforeRemoveByWFUser(parentEntity,removeList );

        // 执行删除
        for (WFReminder item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFUser(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFReminder> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFReminder> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFReminder et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFReminder et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWFStepActorId()!=null) {
            IEntity entity = cloneSession.getEntity("WFSTEPACTOR",et.getWFStepActorId());
            if(entity !=null) {
                onFillParentInfo_WFStepActor(et,(net.ibizsys.psrt.srv.wf.entity.WFStepActor) entity);
            }
        }
        if(et.getWFUserId()!=null) {
            IEntity entity = cloneSession.getEntity("WFUSER",et.getWFUserId());
            if(entity !=null) {
                onFillParentInfo_WFUser(et,(net.ibizsys.psrt.srv.wf.entity.WFUser) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(WFReminder et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFReminder  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 催办备注
        entityFieldError = onCheckField_Memo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 催办时间
        entityFieldError = onCheckField_ReminderTime( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流工作催办标识
        entityFieldError = onCheckField_WFReminderId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 标题
        entityFieldError = onCheckField_WFReminderName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流催办_操作者
        entityFieldError = onCheckField_WFStepActorId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 催办者
        entityFieldError = onCheckField_WFUserId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 催办者
        entityFieldError = onCheckField_WFUserName( bBaseMode,  et,  bCreate,  bTempMode);
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
    protected EntityFieldError onCheckField_Memo(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFReminder.FIELD_MEMO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ReminderTime]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ReminderTime(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isReminderTimeDirty()) {
            return null;
        }

        Timestamp value = et.getReminderTime();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ReminderTime_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_REMINDERTIME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFReminderId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFReminderId(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFReminderIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_WFREMINDERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFReminderId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFReminder.FIELD_WFREMINDERID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFReminderId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_WFREMINDERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFReminderName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFReminderName(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFReminderNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_WFREMINDERNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFReminderName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFReminder.FIELD_WFREMINDERNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFReminderName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_WFREMINDERNAME);
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
    protected EntityFieldError onCheckField_WFStepActorId(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFReminder.FIELD_WFSTEPACTORID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserId(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserIdDirty()) {
            return null;
        }

        String value = et.getWFUserId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_WFUSERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserName(boolean bBaseMode,WFReminder et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserNameDirty()) {
            return null;
        }

        String value = et.getWFUserName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFReminder.FIELD_WFUSERNAME);
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
    protected void onSyncEntity(WFReminder et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFReminder et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFReminder et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_ACTORID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ActorId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_MEMO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Memo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_REMINDERCOUNT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ReminderCount_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_REMINDERTIME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ReminderTime_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFCREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFCreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFREMINDERID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFReminderId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFREMINDERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFReminderName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFSTEPACTORID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepActorId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFSTEPACTORNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepActorName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFUSERID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFReminder.FIELD_WFUSERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserName_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[催办对象][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ActorId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("ACTORID", et, bTempMode,null,false,80,true,"内容长度必须小于等于[80]",false)))
                return null;
            return "内容长度必须小于等于[80]";
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
     * 判断值规则[催办备注][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Memo_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MEMO", et, bTempMode,null,false,1048576,true,"内容长度必须小于等于[1048576]",false)))
                return null;
            return "内容长度必须小于等于[1048576]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[已催次数][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ReminderCount_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[催办时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ReminderTime_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
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
     * 判断值规则[送交时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFCreateDate_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[工作流工作催办标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFReminderId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFREMINDERID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[标题][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFReminderName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFREMINDERNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流催办_操作者][默认规则]
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
     * 判断值规则[工作操作者][默认规则]
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
     * 判断值规则[催办者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[催办者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFReminder et) throws Exception {
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
    protected void onUpdateParent(WFReminder et)throws Exception {
        super.onUpdateParent(et);
    }


}