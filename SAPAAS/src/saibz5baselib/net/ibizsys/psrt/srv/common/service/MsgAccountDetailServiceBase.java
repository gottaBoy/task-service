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



import net.ibizsys.psrt.srv.common.entity.MsgAccountDetail;
import net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO;
import net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel;

/**
 * 实体[MsgAccountDetail] 服务对象基类
 */
public abstract class MsgAccountDetailServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<MsgAccountDetail> {
    private static final Log log = LogFactory.getLog(MsgAccountDetailServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public MsgAccountDetailServiceBase () {
        super();

    }

    /**
     * 获取实体[MsgAccountDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static MsgAccountDetailService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[MsgAccountDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static MsgAccountDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (MsgAccountDetailService)ServiceGlobal.getService(MsgAccountDetailService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.MsgAccountDetailService";
    }

    private MsgAccountDetailDEModel msgAccountDetailDEModel;
    /**
     * 获取实体[MsgAccountDetail]模型对象
     */
    public  MsgAccountDetailDEModel getMsgAccountDetailDEModel() {
        if(this.msgAccountDetailDEModel==null) {
            try {
                this.msgAccountDetailDEModel = (MsgAccountDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel");
            } catch(Exception ex) {
            }
        }
        return this.msgAccountDetailDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getMsgAccountDetailDEModel();
    }


    private MsgAccountDetailDAO msgAccountDetailDAO;

    /**
     * 获取实体[MsgAccountDetail]数据操作对象
     */
    public  MsgAccountDetailDAO getMsgAccountDetailDAO() {
        if(this.msgAccountDetailDAO==null) {
            try {
                this.msgAccountDetailDAO= (MsgAccountDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.msgAccountDetailDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getMsgAccountDetailDAO();
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
    protected void onFillParentInfo(MsgAccountDetail et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :MSGACCOUNT / 消息账户
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity = ( net.ibizsys.psrt.srv.common.entity.MsgAccount)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.MsgAccount.FIELD_MSGACCOUNTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_MajorMsgAccount(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :MSGACCOUNT / 消息账户
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity = ( net.ibizsys.psrt.srv.common.entity.MsgAccount)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.MsgAccount.FIELD_MSGACCOUNTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_MinorMsgAccount(et,parentEntity );
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
    * 填充数据的父数据信息[消息账户]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_MajorMsgAccount(MsgAccountDetail et,net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        et.setMajorMsgAccountId(parentEntity.getMsgAccountId());
        et.setMajorMsgAccountName(parentEntity.getMsgAccountName());
    }

    /**
    * 填充数据的父数据信息[消息账户]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_MinorMsgAccount(MsgAccountDetail et,net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        et.setMinorMsgAccountId(parentEntity.getMsgAccountId());
        et.setMinorMsgAccountName(parentEntity.getMsgAccountName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(MsgAccountDetail et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :MSGACCOUNT / 消息账户
        onFillEntityFullInfo_MajorMsgAccount(et, bCreate);
        //关系类型 : DER1N ,主实体 :MSGACCOUNT / 消息账户
        onFillEntityFullInfo_MinorMsgAccount(et, bCreate);
    }

    /**
    * 填充实体的数据信息 消息账户
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_MajorMsgAccount(MsgAccountDetail et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 消息账户
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_MinorMsgAccount(MsgAccountDetail et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(MsgAccountDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[消息账户]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<MsgAccountDetail> selectByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccountBase parentEntity) throws Exception {
        return selectByMajorMsgAccount( parentEntity,"");
    }
    /**
     * 通过关系[消息账户]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<MsgAccountDetail> selectByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccountBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(MsgAccountDetail.FIELD_MAJORMSGACCOUNTID, parentEntity.getMsgAccountId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByMajorMsgAccountCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[消息账户]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByMajorMsgAccountCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[消息账户]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<MsgAccountDetail> selectByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccountBase parentEntity) throws Exception {
        return selectByMinorMsgAccount( parentEntity,"");
    }
    /**
     * 通过关系[消息账户]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<MsgAccountDetail> selectByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccountBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(MsgAccountDetail.FIELD_MINORMSGACCOUNTID, parentEntity.getMsgAccountId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByMinorMsgAccountCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[消息账户]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByMinorMsgAccountCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[消息账户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
    }


    /**
     * 通过关系[消息账户]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        java.util.ArrayList<MsgAccountDetail> list =  this.selectByMajorMsgAccount(parentEntity);
        for(MsgAccountDetail item:list) {
            MsgAccountDetail item2 = (MsgAccountDetail)getDEModel().createEntity();
            item2.setMsgAccountDetailId(item.getMsgAccountDetailId());
            item2.setMajorMsgAccountId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[消息账户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByMajorMsgAccount(parentEntity2);
                internalRemoveByMajorMsgAccount(parentEntity2);
                onAfterRemoveByMajorMsgAccount(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[消息账户]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[消息账户]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        java.util.ArrayList<MsgAccountDetail> removeList = selectByMajorMsgAccount(parentEntity);
        onBeforeRemoveByMajorMsgAccount(parentEntity,removeList );

        // 执行删除
        for (MsgAccountDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByMajorMsgAccount(parentEntity,removeList );
    }

    /**
     * 通过关系[消息账户]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {

    }

    /**
     * 通过关系[消息账户]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity,java.util.ArrayList<MsgAccountDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[消息账户]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByMajorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity,java.util.ArrayList<MsgAccountDetail> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[消息账户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
    }


    /**
     * 通过关系[消息账户]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        java.util.ArrayList<MsgAccountDetail> list =  this.selectByMinorMsgAccount(parentEntity);
        for(MsgAccountDetail item:list) {
            MsgAccountDetail item2 = (MsgAccountDetail)getDEModel().createEntity();
            item2.setMsgAccountDetailId(item.getMsgAccountDetailId());
            item2.setMinorMsgAccountId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[消息账户]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByMinorMsgAccount(parentEntity2);
                internalRemoveByMinorMsgAccount(parentEntity2);
                onAfterRemoveByMinorMsgAccount(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[消息账户]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[消息账户]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {
        java.util.ArrayList<MsgAccountDetail> removeList = selectByMinorMsgAccount(parentEntity);
        onBeforeRemoveByMinorMsgAccount(parentEntity,removeList );

        // 执行删除
        for (MsgAccountDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByMinorMsgAccount(parentEntity,removeList );
    }

    /**
     * 通过关系[消息账户]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity) throws Exception {

    }

    /**
     * 通过关系[消息账户]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity,java.util.ArrayList<MsgAccountDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[消息账户]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByMinorMsgAccount(net.ibizsys.psrt.srv.common.entity.MsgAccount parentEntity,java.util.ArrayList<MsgAccountDetail> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(MsgAccountDetail et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(MsgAccountDetail et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getMajorMsgAccountId()!=null) {
            IEntity entity = cloneSession.getEntity("MSGACCOUNT",et.getMajorMsgAccountId());
            if(entity !=null) {
                onFillParentInfo_MajorMsgAccount(et,(net.ibizsys.psrt.srv.common.entity.MsgAccount) entity);
            }
        }
        if(et.getMinorMsgAccountId()!=null) {
            IEntity entity = cloneSession.getEntity("MSGACCOUNT",et.getMinorMsgAccountId());
            if(entity !=null) {
                onFillParentInfo_MinorMsgAccount(et,(net.ibizsys.psrt.srv.common.entity.MsgAccount) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(MsgAccountDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,MsgAccountDetail  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 组消息账户_组账户
        entityFieldError = onCheckField_MajorMsgAccountId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 组消息账户_明细账户
        entityFieldError = onCheckField_MinorMsgAccountId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 组消息账户明细标识
        entityFieldError = onCheckField_MsgAccountDetailId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 组消息账户明细名称
        entityFieldError = onCheckField_MsgAccountDetailName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[MajorMsgAccountId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_MajorMsgAccountId(boolean bBaseMode,MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMajorMsgAccountIdDirty()) {
            return null;
        }

        String value = et.getMajorMsgAccountId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_MajorMsgAccountId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(MsgAccountDetail.FIELD_MAJORMSGACCOUNTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[MinorMsgAccountId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_MinorMsgAccountId(boolean bBaseMode,MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMinorMsgAccountIdDirty()) {
            return null;
        }

        String value = et.getMinorMsgAccountId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_MinorMsgAccountId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(MsgAccountDetail.FIELD_MINORMSGACCOUNTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[MsgAccountDetailId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_MsgAccountDetailId(boolean bBaseMode,MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMsgAccountDetailIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(MsgAccountDetail.FIELD_MSGACCOUNTDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getMsgAccountDetailId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(MsgAccountDetail.FIELD_MSGACCOUNTDETAILID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_MsgAccountDetailId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(MsgAccountDetail.FIELD_MSGACCOUNTDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[MsgAccountDetailName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_MsgAccountDetailName(boolean bBaseMode,MsgAccountDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMsgAccountDetailNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(MsgAccountDetail.FIELD_MSGACCOUNTDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getMsgAccountDetailName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(MsgAccountDetail.FIELD_MSGACCOUNTDETAILNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_MsgAccountDetailName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(MsgAccountDetail.FIELD_MSGACCOUNTDETAILNAME);
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
    protected void onSyncEntity(MsgAccountDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(MsgAccountDetail et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(MsgAccountDetail et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        IEntity majorMsgAccount =et.getMajorMsgAccount();
        if(majorMsgAccount!=null) {
            if(majorMsgAccount.contains(strField)) {
                return majorMsgAccount.get(strField);
            }
        }
        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_MAJORMSGACCOUNTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MajorMsgAccountId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_MAJORMSGACCOUNTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MajorMsgAccountName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_MINORMSGACCOUNTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MinorMsgAccountId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_MINORMSGACCOUNTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MinorMsgAccountName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_MSGACCOUNTDETAILID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MsgAccountDetailId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_MSGACCOUNTDETAILNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MsgAccountDetailName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,MsgAccountDetail.FIELD_UPDATEMAN,true)==0)
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
     * 判断值规则[组消息账户_组账户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MajorMsgAccountId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MAJORMSGACCOUNTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组账户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MajorMsgAccountName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MAJORMSGACCOUNTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组消息账户_明细账户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MinorMsgAccountId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MINORMSGACCOUNTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[包含账户][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MinorMsgAccountName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MINORMSGACCOUNTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组消息账户明细标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MsgAccountDetailId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MSGACCOUNTDETAILID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[组消息账户明细名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MsgAccountDetailName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MSGACCOUNTDETAILNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, MsgAccountDetail et) throws Exception {
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
    protected void onUpdateParent(MsgAccountDetail et)throws Exception {
        super.onUpdateParent(et);
    }


}