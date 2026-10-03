/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.service;

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



import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.psrt.srv.wx.dao.WXMessageDAO;
import net.ibizsys.psrt.srv.wx.demodel.WXMessageDEModel;

/**
 * 实体[WXMessage] 服务对象基类
 */
public abstract class WXMessageServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WXMessage> {
    private static final Log log = LogFactory.getLog(WXMessageServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WXMessageServiceBase () {
        super();

    }

    /**
     * 获取实体[WXMessage]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WXMessageService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WXMessage]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WXMessageService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WXMessageService)ServiceGlobal.getService(WXMessageService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wx.service.WXMessageService";
    }

    private WXMessageDEModel wXMessageDEModel;
    /**
     * 获取实体[WXMessage]模型对象
     */
    public  WXMessageDEModel getWXMessageDEModel() {
        if(this.wXMessageDEModel==null) {
            try {
                this.wXMessageDEModel = (WXMessageDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXMessageDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wXMessageDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWXMessageDEModel();
    }


    private WXMessageDAO wXMessageDAO;

    /**
     * 获取实体[WXMessage]数据操作对象
     */
    public  WXMessageDAO getWXMessageDAO() {
        if(this.wXMessageDAO==null) {
            try {
                this.wXMessageDAO= (WXMessageDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wx.dao.WXMessageDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wXMessageDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWXMessageDAO();
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
    protected void onFillParentInfo(WXMessage et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WXACCOUNT / 微信公众号
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXAccountService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity = ( net.ibizsys.psrt.srv.wx.entity.WXAccount)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wx.entity.WXAccount.FIELD_WXACCOUNTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WXAccount(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WXENTAPP / 微信企业应用
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXEntAppService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity = ( net.ibizsys.psrt.srv.wx.entity.WXEntApp)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wx.entity.WXEntApp.FIELD_WXENTAPPID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WXEntApp(et,parentEntity );
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
    * 填充数据的父数据信息[微信公众号]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WXAccount(WXMessage et,net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {
        et.setWXAccountId(parentEntity.getWXAccountId());
        et.setWXAccountName(parentEntity.getWXAccountName());
    }

    /**
    * 填充数据的父数据信息[微信企业应用]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WXEntApp(WXMessage et,net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {
        et.setWXEntAppId(parentEntity.getWXEntAppId());
        et.setWXEntAppName(parentEntity.getWXEntAppName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WXMessage et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WXACCOUNT / 微信公众号
        onFillEntityFullInfo_WXAccount(et, bCreate);
        //关系类型 : DER1N ,主实体 :WXENTAPP / 微信企业应用
        onFillEntityFullInfo_WXEntApp(et, bCreate);
    }

    /**
    * 填充实体的数据信息 微信公众号
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WXAccount(WXMessage et, boolean bCreate) throws Exception {
        if(et.isWXAccountIdDirty()) {
            if(et.getWXAccountId()!=null) {
                if((true&&et.getWXAccountId()==null)||(true&&et.getWXAccountName()==null)) {
                    net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity  = et.getWXAccount();
                    et.setWXAccountName(parentEntity.getWXAccountName());
                }

            } else {
                et.setWXAccountName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 微信企业应用
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WXEntApp(WXMessage et, boolean bCreate) throws Exception {
        if(et.isWXEntAppIdDirty()) {
            if(et.getWXEntAppId()!=null) {
                if((true&&et.getWXEntAppId()==null)||(true&&et.getWXEntAppName()==null)) {
                    net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity  = et.getWXEntApp();
                    et.setWXEntAppName(parentEntity.getWXEntAppName());
                }

            } else {
                et.setWXEntAppName(null);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WXMessage et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[微信公众号]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WXMessage> selectByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccountBase parentEntity) throws Exception {
        return selectByWXAccount( parentEntity,"");
    }
    /**
     * 通过关系[微信公众号]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WXMessage> selectByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccountBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WXMessage.FIELD_WXACCOUNTID, parentEntity.getWXAccountId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWXAccountCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[微信公众号]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWXAccountCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[微信企业应用]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WXMessage> selectByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntAppBase parentEntity) throws Exception {
        return selectByWXEntApp( parentEntity,"");
    }
    /**
     * 通过关系[微信企业应用]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WXMessage> selectByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntAppBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WXMessage.FIELD_WXENTAPPID, parentEntity.getWXEntAppId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWXEntAppCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[微信企业应用]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWXEntAppCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[微信公众号]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {
        java.util.ArrayList<WXMessage> list =  this.selectByWXAccount(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WXACCOUNT");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID","" ,parentDEModel.getName(),"WXMESSAGE",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[微信公众号]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {
        java.util.ArrayList<WXMessage> list =  this.selectByWXAccount(parentEntity);
        for(WXMessage item:list) {
            WXMessage item2 = (WXMessage)getDEModel().createEntity();
            item2.setWXMessageId(item.getWXMessageId());
            item2.setWXAccountId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[微信公众号]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWXAccount(parentEntity2);
                internalRemoveByWXAccount(parentEntity2);
                onAfterRemoveByWXAccount(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[微信公众号]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[微信公众号]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {
        java.util.ArrayList<WXMessage> removeList = selectByWXAccount(parentEntity);
        onBeforeRemoveByWXAccount(parentEntity,removeList );

        // 执行删除
        for (WXMessage item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWXAccount(parentEntity,removeList );
    }

    /**
     * 通过关系[微信公众号]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity) throws Exception {

    }

    /**
     * 通过关系[微信公众号]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity,java.util.ArrayList<WXMessage> removeList) throws Exception {

    }

    /**
     * 通过关系[微信公众号]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWXAccount(net.ibizsys.psrt.srv.wx.entity.WXAccount parentEntity,java.util.ArrayList<WXMessage> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[微信企业应用]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {
        java.util.ArrayList<WXMessage> list =  this.selectByWXEntApp(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WXENTAPP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID","" ,parentDEModel.getName(),"WXMESSAGE",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[微信企业应用]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {
        java.util.ArrayList<WXMessage> list =  this.selectByWXEntApp(parentEntity);
        for(WXMessage item:list) {
            WXMessage item2 = (WXMessage)getDEModel().createEntity();
            item2.setWXMessageId(item.getWXMessageId());
            item2.setWXEntAppId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[微信企业应用]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWXEntApp(parentEntity2);
                internalRemoveByWXEntApp(parentEntity2);
                onAfterRemoveByWXEntApp(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[微信企业应用]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[微信企业应用]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {
        java.util.ArrayList<WXMessage> removeList = selectByWXEntApp(parentEntity);
        onBeforeRemoveByWXEntApp(parentEntity,removeList );

        // 执行删除
        for (WXMessage item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWXEntApp(parentEntity,removeList );
    }

    /**
     * 通过关系[微信企业应用]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity) throws Exception {

    }

    /**
     * 通过关系[微信企业应用]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity,java.util.ArrayList<WXMessage> removeList) throws Exception {

    }

    /**
     * 通过关系[微信企业应用]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWXEntApp(net.ibizsys.psrt.srv.wx.entity.WXEntApp parentEntity,java.util.ArrayList<WXMessage> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WXMessage et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WXMessage et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWXAccountId()!=null) {
            IEntity entity = cloneSession.getEntity("WXACCOUNT",et.getWXAccountId());
            if(entity !=null) {
                onFillParentInfo_WXAccount(et,(net.ibizsys.psrt.srv.wx.entity.WXAccount) entity);
            }
        }
        if(et.getWXEntAppId()!=null) {
            IEntity entity = cloneSession.getEntity("WXENTAPP",et.getWXEntAppId());
            if(entity !=null) {
                onFillParentInfo_WXEntApp(et,(net.ibizsys.psrt.srv.wx.entity.WXEntApp) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(WXMessage et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WXMessage  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 输入内容数量
        entityFieldError = onCheckField_Cnt( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 文本消息内容
        entityFieldError = onCheckField_Content( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 事件
        entityFieldError = onCheckField_Event( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 EventKey
        entityFieldError = onCheckField_EventKey( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 语音格式
        entityFieldError = onCheckField_Format( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 发送方帐号
        entityFieldError = onCheckField_FromUserName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 进入时间
        entityFieldError = onCheckField_IncomeTime( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 位置精度
        entityFieldError = onCheckField_Location_Prec( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 地理位置维度
        entityFieldError = onCheckField_Location_X( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 地理位置经度
        entityFieldError = onCheckField_Location_Y( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 图片消息媒体编号
        entityFieldError = onCheckField_MediaId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 消息类型
        entityFieldError = onCheckField_MsgType( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 图片路径
        entityFieldError = onCheckField_PicURL( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
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
        //检查属性 反馈图文消息的数量
        entityFieldError = onCheckField_RespArticleCount( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 反馈的文章内容
        entityFieldError = onCheckField_RespArticles( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 返回描述
        entityFieldError = onCheckField_RespDesc( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 返回图片消息媒体编号
        entityFieldError = onCheckField_RespMediaId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 反馈消息类型
        entityFieldError = onCheckField_RespMsgType( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 反馈时间
        entityFieldError = onCheckField_RespTime( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 返回标题
        entityFieldError = onCheckField_RespTitle( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 结果内容
        entityFieldError = onCheckField_Result( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 地图缩放大小
        entityFieldError = onCheckField_Scale( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 ScanCodeInfo
        entityFieldError = onCheckField_ScanCodeInfo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 ScanType
        entityFieldError = onCheckField_ScanType( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 视频消息缩略图的媒体编号
        entityFieldError = onCheckField_ThumbMediaId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 开发者微信号
        entityFieldError = onCheckField_ToUserName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 微信公众号
        entityFieldError = onCheckField_WXAccountId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 微信公众号
        entityFieldError = onCheckField_WXAccountName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 微信企业应用
        entityFieldError = onCheckField_WXEntAppId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 微信企业应用
        entityFieldError = onCheckField_WXEntAppName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 微信消息标识
        entityFieldError = onCheckField_WXMessageId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 微信消息名称
        entityFieldError = onCheckField_WXMessageName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[Cnt]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Cnt(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isCntDirty()) {
            return null;
        }

        Integer value = et.getCnt();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Cnt_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_CNT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Content]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Content(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isContentDirty()) {
            return null;
        }

        String value = et.getContent();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Content_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_CONTENT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Event]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Event(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isEventDirty()) {
            return null;
        }

        String value = et.getEvent();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Event_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_EVENT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[EventKey]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_EventKey(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isEventKeyDirty()) {
            return null;
        }

        String value = et.getEventKey();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_EventKey_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_EVENTKEY);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Format]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Format(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isFormatDirty()) {
            return null;
        }

        String value = et.getFormat();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Format_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_FORMAT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[FromUserName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_FromUserName(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isFromUserNameDirty()) {
            return null;
        }

        String value = et.getFromUserName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_FromUserName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_FROMUSERNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[IncomeTime]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_IncomeTime(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isIncomeTimeDirty()) {
            return null;
        }

        Timestamp value = et.getIncomeTime();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_IncomeTime_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_INCOMETIME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Location_Prec]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Location_Prec(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isLocation_PrecDirty()) {
            return null;
        }

        Double value = et.getLocation_Prec();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Location_Prec_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_LOCATION_PREC);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Location_X]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Location_X(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isLocation_XDirty()) {
            return null;
        }

        String value = et.getLocation_X();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Location_X_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_LOCATION_X);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Location_Y]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Location_Y(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isLocation_YDirty()) {
            return null;
        }

        String value = et.getLocation_Y();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Location_Y_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_LOCATION_Y);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[MediaId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_MediaId(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMediaIdDirty()) {
            return null;
        }

        String value = et.getMediaId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_MediaId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_MEDIAID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[MsgType]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_MsgType(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isMsgTypeDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_MSGTYPE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getMsgType();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WXMessage.FIELD_MSGTYPE);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_MsgType_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_MSGTYPE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PicURL]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PicURL(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPicURLDirty()) {
            return null;
        }

        String value = et.getPicURL();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PicURL_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_PICURL);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Reserver]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WXMessage.FIELD_RESERVER);
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
    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WXMessage.FIELD_RESERVER2);
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
    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WXMessage.FIELD_RESERVER3);
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
    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WXMessage.FIELD_RESERVER4);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespArticleCount]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespArticleCount(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespArticleCountDirty()) {
            return null;
        }

        Integer value = et.getRespArticleCount();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespArticleCount_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPARTICLECOUNT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespArticles]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespArticles(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespArticlesDirty()) {
            return null;
        }

        String value = et.getRespArticles();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespArticles_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPARTICLES);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespDesc]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespDesc(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespDescDirty()) {
            return null;
        }

        String value = et.getRespDesc();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespDesc_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPDESC);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespMediaId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespMediaId(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespMediaIdDirty()) {
            return null;
        }

        String value = et.getRespMediaId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespMediaId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPMEDIAID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespMsgType]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespMsgType(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespMsgTypeDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPMSGTYPE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getRespMsgType();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WXMessage.FIELD_RESPMSGTYPE);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespMsgType_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPMSGTYPE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespTime]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespTime(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespTimeDirty()) {
            return null;
        }

        Timestamp value = et.getRespTime();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespTime_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPTIME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[RespTitle]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_RespTitle(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isRespTitleDirty()) {
            return null;
        }

        String value = et.getRespTitle();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_RespTitle_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_RESPTITLE);
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
    protected EntityFieldError onCheckField_Result(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WXMessage.FIELD_RESULT);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[Scale]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_Scale(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isScaleDirty()) {
            return null;
        }

        Integer value = et.getScale();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_Scale_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_SCALE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ScanCodeInfo]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ScanCodeInfo(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isScanCodeInfoDirty()) {
            return null;
        }

        String value = et.getScanCodeInfo();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ScanCodeInfo_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_SCANCODEINFO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ScanType]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ScanType(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isScanTypeDirty()) {
            return null;
        }

        String value = et.getScanType();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ScanType_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_SCANTYPE);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ThumbMediaId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ThumbMediaId(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isThumbMediaIdDirty()) {
            return null;
        }

        String value = et.getThumbMediaId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ThumbMediaId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_THUMBMEDIAID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ToUserName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ToUserName(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isToUserNameDirty()) {
            return null;
        }

        String value = et.getToUserName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ToUserName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_TOUSERNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WXAccountId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WXAccountId(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWXAccountIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXACCOUNTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWXAccountId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WXMessage.FIELD_WXACCOUNTID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WXAccountId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXACCOUNTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WXAccountName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WXAccountName(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWXAccountNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXACCOUNTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWXAccountName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WXMessage.FIELD_WXACCOUNTNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WXAccountName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXACCOUNTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WXEntAppId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WXEntAppId(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWXEntAppIdDirty()) {
            return null;
        }

        String value = et.getWXEntAppId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WXEntAppId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXENTAPPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WXEntAppName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WXEntAppName(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWXEntAppNameDirty()) {
            return null;
        }

        String value = et.getWXEntAppName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WXEntAppName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXENTAPPNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WXMessageId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WXMessageId(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWXMessageIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXMESSAGEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWXMessageId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WXMessage.FIELD_WXMESSAGEID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WXMessageId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXMESSAGEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WXMessageName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WXMessageName(boolean bBaseMode,WXMessage et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWXMessageNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXMESSAGENAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWXMessageName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WXMessage.FIELD_WXMESSAGENAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WXMessageName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WXMessage.FIELD_WXMESSAGENAME);
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
    protected void onSyncEntity(WXMessage et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WXMessage et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WXMessage et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_CNT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Cnt_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_CONTENT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Content_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_EVENT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Event_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_EVENTKEY,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_EventKey_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_FORMAT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Format_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_FROMUSERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_FromUserName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_INCOMETIME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_IncomeTime_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_LOCATION_PREC,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Location_Prec_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_LOCATION_X,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Location_X_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_LOCATION_Y,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Location_Y_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_MEDIAID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MediaId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_MSGTYPE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_MsgType_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_PICURL,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PicURL_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESERVER,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESERVER2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESERVER3,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver3_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESERVER4,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver4_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPARTICLECOUNT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespArticleCount_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPARTICLES,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespArticles_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPDESC,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespDesc_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPMEDIAID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespMediaId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPMSGTYPE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespMsgType_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPTIME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespTime_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESPTITLE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_RespTitle_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_RESULT,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Result_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_SCALE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Scale_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_SCANCODEINFO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ScanCodeInfo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_SCANTYPE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ScanType_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_THUMBMEDIAID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ThumbMediaId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_TOUSERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ToUserName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_WXACCOUNTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WXAccountId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_WXACCOUNTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WXAccountName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_WXENTAPPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WXEntAppId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_WXENTAPPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WXEntAppName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_WXMESSAGEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WXMessageId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WXMessage.FIELD_WXMESSAGENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WXMessageName_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[输入内容数量][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Cnt_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[文本消息内容][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Content_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("CONTENT", et, bTempMode,null,false,4000,true,"内容长度必须小于等于[4000]",false)))
                return null;
            return "内容长度必须小于等于[4000]";
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
     * 判断值规则[事件][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Event_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("EVENT", et, bTempMode,null,false,40,true,"内容长度必须小于等于[40]",false)))
                return null;
            return "内容长度必须小于等于[40]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[EventKey][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_EventKey_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("EVENTKEY", et, bTempMode,null,false,500,true,"内容长度必须小于等于[500]",false)))
                return null;
            return "内容长度必须小于等于[500]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[语音格式][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Format_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("FORMAT", et, bTempMode,null,false,50,true,"内容长度必须小于等于[50]",false)))
                return null;
            return "内容长度必须小于等于[50]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[发送方帐号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_FromUserName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("FROMUSERNAME", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[进入时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_IncomeTime_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[位置精度][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Location_Prec_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[地理位置维度][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Location_X_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("LOCATION_X", et, bTempMode,null,false,20,true,"内容长度必须小于等于[20]",false)))
                return null;
            return "内容长度必须小于等于[20]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[地理位置经度][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Location_Y_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("LOCATION_Y", et, bTempMode,null,false,20,true,"内容长度必须小于等于[20]",false)))
                return null;
            return "内容长度必须小于等于[20]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[图片消息媒体编号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MediaId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MEDIAID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[消息类型][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_MsgType_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("MSGTYPE", et, bTempMode,null,false,40,true,"内容长度必须小于等于[40]",false)))
                return null;
            return "内容长度必须小于等于[40]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[图片路径][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PicURL_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PICURL", et, bTempMode,null,false,500,true,"内容长度必须小于等于[500]",false)))
                return null;
            return "内容长度必须小于等于[500]";
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
     * 判断值规则[反馈图文消息的数量][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespArticleCount_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[反馈的文章内容][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespArticles_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESPARTICLES", et, bTempMode,null,false,1048576,true,"内容长度必须小于等于[1048576]",false)))
                return null;
            return "内容长度必须小于等于[1048576]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[返回描述][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespDesc_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESPDESC", et, bTempMode,null,false,1000,true,"内容长度必须小于等于[1000]",false)))
                return null;
            return "内容长度必须小于等于[1000]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[返回图片消息媒体编号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespMediaId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESPMEDIAID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[反馈消息类型][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespMsgType_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESPMSGTYPE", et, bTempMode,null,false,40,true,"内容长度必须小于等于[40]",false)))
                return null;
            return "内容长度必须小于等于[40]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[反馈时间][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespTime_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[返回标题][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_RespTitle_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESPTITLE", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[结果内容][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Result_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RESULT", et, bTempMode,null,false,4000,true,"内容长度必须小于等于[4000]",false)))
                return null;
            return "内容长度必须小于等于[4000]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[地图缩放大小][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_Scale_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[ScanCodeInfo][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ScanCodeInfo_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("SCANCODEINFO", et, bTempMode,null,false,500,true,"内容长度必须小于等于[500]",false)))
                return null;
            return "内容长度必须小于等于[500]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[ScanType][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ScanType_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("SCANTYPE", et, bTempMode,null,false,50,true,"内容长度必须小于等于[50]",false)))
                return null;
            return "内容长度必须小于等于[50]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[视频消息缩略图的媒体编号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ThumbMediaId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("THUMBMEDIAID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[开发者微信号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ToUserName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TOUSERNAME", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
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
     * 判断值规则[微信公众号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WXAccountId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WXACCOUNTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[微信公众号][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WXAccountName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WXACCOUNTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[微信企业应用][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WXEntAppId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WXENTAPPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[微信企业应用][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WXEntAppName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WXENTAPPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[微信消息标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WXMessageId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WXMESSAGEID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[微信消息名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WXMessageName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WXMESSAGENAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WXMessage et) throws Exception {
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
    protected void onUpdateParent(WXMessage et)throws Exception {
        super.onUpdateParent(et);
    }


}