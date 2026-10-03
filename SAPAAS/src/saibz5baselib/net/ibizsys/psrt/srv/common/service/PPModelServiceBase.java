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



import net.ibizsys.psrt.srv.common.entity.PPModel;
import net.ibizsys.psrt.srv.common.dao.PPModelDAO;
import net.ibizsys.psrt.srv.common.demodel.PPModelDEModel;

/**
 * 实体[PPModel] 服务对象基类
 */
public abstract class PPModelServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<PPModel> {
    private static final Log log = LogFactory.getLog(PPModelServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public PPModelServiceBase () {
        super();

    }

    /**
     * 获取实体[PPModel]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static PPModelService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[PPModel]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static PPModelService getInstance(SessionFactory sessionFactory) throws Exception {
        return (PPModelService)ServiceGlobal.getService(PPModelService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.PPModelService";
    }

    private PPModelDEModel pPModelDEModel;
    /**
     * 获取实体[PPModel]模型对象
     */
    public  PPModelDEModel getPPModelDEModel() {
        if(this.pPModelDEModel==null) {
            try {
                this.pPModelDEModel = (PPModelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.PPModelDEModel");
            } catch(Exception ex) {
            }
        }
        return this.pPModelDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getPPModelDEModel();
    }


    private PPModelDAO pPModelDAO;

    /**
     * 获取实体[PPModel]数据操作对象
     */
    public  PPModelDAO getPPModelDAO() {
        if(this.pPModelDAO==null) {
            try {
                this.pPModelDAO= (PPModelDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.PPModelDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.pPModelDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getPPModelDAO();
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
    protected void onFillParentInfo(PPModel et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :PORTALPAGE / 门户页面
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PortalPageService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity = ( net.ibizsys.psrt.srv.common.entity.PortalPage)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PortalPage.FIELD_PORTALPAGEID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_PortalPage(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C1PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_C1PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C2PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_C2PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C3PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_C3PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C4PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_C4PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L1PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_L1PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L2PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_L2PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L3PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_L3PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L4PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_L4PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R1PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_R1PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R2PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_R2PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R3PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_R3PVPart(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R4PVPARTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.PVPart parentEntity = ( net.ibizsys.psrt.srv.common.entity.PVPart)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.PVPart.FIELD_PVPARTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_R4PVPart(et,parentEntity );
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
    * 填充数据的父数据信息[门户页面]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_PortalPage(PPModel et,net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {
        et.setPortalPageId(parentEntity.getPortalPageId());
        et.setPortalPageName(parentEntity.getPortalPageName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_C1PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setC1PVPartCtrlId(parentEntity.getCtrlId());
        et.setC1PVPartId(parentEntity.getPVPartId());
        et.setC1PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_C2PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setC2PVPartCtrlId(parentEntity.getCtrlId());
        et.setC2PVPartId(parentEntity.getPVPartId());
        et.setC2PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_C3PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setC3PVPartCtrlId(parentEntity.getCtrlId());
        et.setC3PVPartId(parentEntity.getPVPartId());
        et.setC3PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_C4PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setC4PVPartCtrlId(parentEntity.getCtrlId());
        et.setC4PVPartId(parentEntity.getPVPartId());
        et.setC4PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_L1PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setL1PVPartCtrlId(parentEntity.getCtrlId());
        et.setL1PVPartId(parentEntity.getPVPartId());
        et.setL1PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_L2PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setL2PVPartCtrlId(parentEntity.getCtrlId());
        et.setL2PVPartId(parentEntity.getPVPartId());
        et.setL2PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_L3PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setL3PVPartCtrlId(parentEntity.getCtrlId());
        et.setL3PVPartId(parentEntity.getPVPartId());
        et.setL3PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_L4PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setL4PVPartCtrlId(parentEntity.getCtrlId());
        et.setL4PVPartId(parentEntity.getPVPartId());
        et.setL4PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_R1PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setR1PVPartCtrlId(parentEntity.getCtrlId());
        et.setR1PVPartId(parentEntity.getPVPartId());
        et.setR1PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_R2PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setR2PVPartCtrlId(parentEntity.getCtrlId());
        et.setR2PVPartId(parentEntity.getPVPartId());
        et.setR2PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_R3PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setR3PVPartCtrlId(parentEntity.getCtrlId());
        et.setR3PVPartId(parentEntity.getPVPartId());
        et.setR3PVPartName(parentEntity.getPVPartName());
    }

    /**
    * 填充数据的父数据信息[门户视图部件]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_R4PVPart(PPModel et,net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        et.setR4PVPartCtrlId(parentEntity.getCtrlId());
        et.setR4PVPartId(parentEntity.getPVPartId());
        et.setR4PVPartName(parentEntity.getPVPartName());
    }


    /**
    * 填充主键
     * @param et
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onFillEntityKeyValue(PPModel et,boolean bTempMode) throws Exception {
        StringBuilderEx sb  = new StringBuilderEx();
        //属性 PortalPageId - 门户页面
        Object objPortalPageId = et.get(PPModel.FIELD_PORTALPAGEID);
        if(objPortalPageId==null)
            objPortalPageId = "__EMTPY__";
        sb.append("%1$s", objPortalPageId);
        //属性 OwnerId - 所有者
        sb.append("||");
        Object objOwnerId = et.get(PPModel.FIELD_OWNERID);
        if(objOwnerId==null)
            objOwnerId = "__EMTPY__";
        sb.append("%1$s", objOwnerId);
        String strValue = sb.toString();
        et.set(this.getPPModelDEModel().getUniTagDEField().getName(),KeyValueHelper.genUniqueId(strValue));
        return true;
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(PPModel et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getIsSystem()==null) {
                et.setIsSystem((Integer)DefaultValueHelper.getValue(this.getWebContext(),"","0",9));
            }
            if(et.getPPModelName()==null) {
                et.setPPModelName((String)DefaultValueHelper.getValue(this.getWebContext(),"","门户视图用户自定义",25));
            }
            if(et.getPPMVersion()==null) {
                et.setPPMVersion((Integer)DefaultValueHelper.getValue(this.getWebContext(),"","1",9));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :PORTALPAGE / 门户页面
        onFillEntityFullInfo_PortalPage(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_C1PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_C2PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_C3PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_C4PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_L1PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_L2PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_L3PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_L4PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_R1PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_R2PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_R3PVPart(et, bCreate);
        //关系类型 : DER1N ,主实体 :PVPART / 门户视图部件
        onFillEntityFullInfo_R4PVPart(et, bCreate);
    }

    /**
    * 填充实体的数据信息 门户页面
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_PortalPage(PPModel et, boolean bCreate) throws Exception {
        if(et.isPortalPageIdDirty()) {
            if(et.getPortalPageId()!=null) {
                if((true&&et.getPortalPageId()==null)||(true&&et.getPortalPageName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity  = et.getPortalPage();
                    et.setPortalPageName(parentEntity.getPortalPageName());
                }

            } else {
                et.setPortalPageName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_C1PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isC1PVPartIdDirty()) {
            if(et.getC1PVPartId()!=null) {
                if((true&&et.getC1PVPartCtrlId()==null)||(true&&et.getC1PVPartId()==null)||(true&&et.getC1PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getC1PVPart();
                    et.setC1PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC1PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setC1PVPartCtrlId(null);
                et.setC1PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_C2PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isC2PVPartIdDirty()) {
            if(et.getC2PVPartId()!=null) {
                if((true&&et.getC2PVPartCtrlId()==null)||(true&&et.getC2PVPartId()==null)||(true&&et.getC2PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getC2PVPart();
                    et.setC2PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC2PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setC2PVPartCtrlId(null);
                et.setC2PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_C3PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isC3PVPartIdDirty()) {
            if(et.getC3PVPartId()!=null) {
                if((true&&et.getC3PVPartCtrlId()==null)||(true&&et.getC3PVPartId()==null)||(true&&et.getC3PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getC3PVPart();
                    et.setC3PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC3PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setC3PVPartCtrlId(null);
                et.setC3PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_C4PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isC4PVPartIdDirty()) {
            if(et.getC4PVPartId()!=null) {
                if((true&&et.getC4PVPartCtrlId()==null)||(true&&et.getC4PVPartId()==null)||(true&&et.getC4PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getC4PVPart();
                    et.setC4PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC4PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setC4PVPartCtrlId(null);
                et.setC4PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_L1PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isL1PVPartIdDirty()) {
            if(et.getL1PVPartId()!=null) {
                if((true&&et.getL1PVPartCtrlId()==null)||(true&&et.getL1PVPartId()==null)||(true&&et.getL1PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getL1PVPart();
                    et.setL1PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL1PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setL1PVPartCtrlId(null);
                et.setL1PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_L2PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isL2PVPartIdDirty()) {
            if(et.getL2PVPartId()!=null) {
                if((true&&et.getL2PVPartCtrlId()==null)||(true&&et.getL2PVPartId()==null)||(true&&et.getL2PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getL2PVPart();
                    et.setL2PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL2PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setL2PVPartCtrlId(null);
                et.setL2PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_L3PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isL3PVPartIdDirty()) {
            if(et.getL3PVPartId()!=null) {
                if((true&&et.getL3PVPartCtrlId()==null)||(true&&et.getL3PVPartId()==null)||(true&&et.getL3PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getL3PVPart();
                    et.setL3PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL3PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setL3PVPartCtrlId(null);
                et.setL3PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_L4PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isL4PVPartIdDirty()) {
            if(et.getL4PVPartId()!=null) {
                if((true&&et.getL4PVPartCtrlId()==null)||(true&&et.getL4PVPartId()==null)||(true&&et.getL4PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getL4PVPart();
                    et.setL4PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL4PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setL4PVPartCtrlId(null);
                et.setL4PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_R1PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isR1PVPartIdDirty()) {
            if(et.getR1PVPartId()!=null) {
                if((true&&et.getR1PVPartCtrlId()==null)||(true&&et.getR1PVPartId()==null)||(true&&et.getR1PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getR1PVPart();
                    et.setR1PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR1PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setR1PVPartCtrlId(null);
                et.setR1PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_R2PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isR2PVPartIdDirty()) {
            if(et.getR2PVPartId()!=null) {
                if((true&&et.getR2PVPartCtrlId()==null)||(true&&et.getR2PVPartId()==null)||(true&&et.getR2PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getR2PVPart();
                    et.setR2PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR2PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setR2PVPartCtrlId(null);
                et.setR2PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_R3PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isR3PVPartIdDirty()) {
            if(et.getR3PVPartId()!=null) {
                if((true&&et.getR3PVPartCtrlId()==null)||(true&&et.getR3PVPartId()==null)||(true&&et.getR3PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getR3PVPart();
                    et.setR3PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR3PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setR3PVPartCtrlId(null);
                et.setR3PVPartName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 门户视图部件
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_R4PVPart(PPModel et, boolean bCreate) throws Exception {
        if(et.isR4PVPartIdDirty()) {
            if(et.getR4PVPartId()!=null) {
                if((true&&et.getR4PVPartCtrlId()==null)||(true&&et.getR4PVPartId()==null)||(true&&et.getR4PVPartName()==null)) {
                    net.ibizsys.psrt.srv.common.entity.PVPart parentEntity  = et.getR4PVPart();
                    et.setR4PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR4PVPartName(parentEntity.getPVPartName());
                }

            } else {
                et.setR4PVPartCtrlId(null);
                et.setR4PVPartName(null);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(PPModel et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[门户页面]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPageBase parentEntity) throws Exception {
        return selectByPortalPage( parentEntity,"");
    }
    /**
     * 通过关系[门户页面]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPageBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_PORTALPAGEID, parentEntity.getPortalPageId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByPortalPageCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户页面]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByPortalPageCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByC1PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_C1PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByC1PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByC1PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByC2PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_C2PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByC2PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByC2PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByC3PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_C3PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByC3PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByC3PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByC4PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_C4PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByC4PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByC4PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByL1PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_L1PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByL1PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByL1PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByL2PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_L2PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByL2PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByL2PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByL3PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_L3PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByL3PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByL3PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByL4PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_L4PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByL4PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByL4PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByR1PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_R1PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByR1PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByR1PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByR2PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_R2PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByR2PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByR2PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByR3PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_R3PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByR3PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByR3PVPartCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity) throws Exception {
        return selectByR4PVPart( parentEntity,"");
    }
    /**
     * 通过关系[门户视图部件]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<PPModel> selectByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPartBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(PPModel.FIELD_R4PVPARTID, parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByR4PVPartCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[门户视图部件]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByR4PVPartCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[门户页面]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户页面]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByPortalPage(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setPortalPageId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户页面]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByPortalPage(parentEntity2);
                internalRemoveByPortalPage(parentEntity2);
                onAfterRemoveByPortalPage(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户页面]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户页面]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByPortalPage(parentEntity);
        onBeforeRemoveByPortalPage(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByPortalPage(parentEntity,removeList );
    }

    /**
     * 通过关系[门户页面]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户页面]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户页面]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByPortalPage(net.ibizsys.psrt.srv.common.entity.PortalPage parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByC1PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC1PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByC1PVPart(parentEntity2);
                internalRemoveByC1PVPart(parentEntity2);
                onAfterRemoveByC1PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByC1PVPart(parentEntity);
        onBeforeRemoveByC1PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByC1PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByC1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByC2PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC2PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByC2PVPart(parentEntity2);
                internalRemoveByC2PVPart(parentEntity2);
                onAfterRemoveByC2PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByC2PVPart(parentEntity);
        onBeforeRemoveByC2PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByC2PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByC2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByC3PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC3PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByC3PVPart(parentEntity2);
                internalRemoveByC3PVPart(parentEntity2);
                onAfterRemoveByC3PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByC3PVPart(parentEntity);
        onBeforeRemoveByC3PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByC3PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByC3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByC4PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC4PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByC4PVPart(parentEntity2);
                internalRemoveByC4PVPart(parentEntity2);
                onAfterRemoveByC4PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByC4PVPart(parentEntity);
        onBeforeRemoveByC4PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByC4PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByC4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByL1PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL1PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByL1PVPart(parentEntity2);
                internalRemoveByL1PVPart(parentEntity2);
                onAfterRemoveByL1PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByL1PVPart(parentEntity);
        onBeforeRemoveByL1PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByL1PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByL1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByL2PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL2PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByL2PVPart(parentEntity2);
                internalRemoveByL2PVPart(parentEntity2);
                onAfterRemoveByL2PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByL2PVPart(parentEntity);
        onBeforeRemoveByL2PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByL2PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByL2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByL3PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL3PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByL3PVPart(parentEntity2);
                internalRemoveByL3PVPart(parentEntity2);
                onAfterRemoveByL3PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByL3PVPart(parentEntity);
        onBeforeRemoveByL3PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByL3PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByL3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByL4PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL4PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByL4PVPart(parentEntity2);
                internalRemoveByL4PVPart(parentEntity2);
                onAfterRemoveByL4PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByL4PVPart(parentEntity);
        onBeforeRemoveByL4PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByL4PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByL4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByR1PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR1PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByR1PVPart(parentEntity2);
                internalRemoveByR1PVPart(parentEntity2);
                onAfterRemoveByR1PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByR1PVPart(parentEntity);
        onBeforeRemoveByR1PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByR1PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByR1PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByR2PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR2PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByR2PVPart(parentEntity2);
                internalRemoveByR2PVPart(parentEntity2);
                onAfterRemoveByR2PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByR2PVPart(parentEntity);
        onBeforeRemoveByR2PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByR2PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByR2PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByR3PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR3PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByR3PVPart(parentEntity2);
                internalRemoveByR3PVPart(parentEntity2);
                onAfterRemoveByR3PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByR3PVPart(parentEntity);
        onBeforeRemoveByR3PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByR3PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByR3PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
    }


    /**
     * 通过关系[门户视图部件]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> list =  this.selectByR4PVPart(parentEntity);
        for(PPModel item:list) {
            PPModel item2 = (PPModel)getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR4PVPartId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[门户视图部件]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByR4PVPart(parentEntity2);
                internalRemoveByR4PVPart(parentEntity2);
                onAfterRemoveByR4PVPart(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[门户视图部件]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {
        java.util.ArrayList<PPModel> removeList = selectByR4PVPart(parentEntity);
        onBeforeRemoveByR4PVPart(parentEntity,removeList );

        // 执行删除
        for (PPModel item : removeList ) {
            remove(item );
        }
        onAfterRemoveByR4PVPart(parentEntity,removeList );
    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /**
     * 通过关系[门户视图部件]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByR4PVPart(net.ibizsys.psrt.srv.common.entity.PVPart parentEntity,java.util.ArrayList<PPModel> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(PPModel et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(PPModel et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getPortalPageId()!=null) {
            IEntity entity = cloneSession.getEntity("PORTALPAGE",et.getPortalPageId());
            if(entity !=null) {
                onFillParentInfo_PortalPage(et,(net.ibizsys.psrt.srv.common.entity.PortalPage) entity);
            }
        }
        if(et.getC1PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getC1PVPartId());
            if(entity !=null) {
                onFillParentInfo_C1PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getC2PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getC2PVPartId());
            if(entity !=null) {
                onFillParentInfo_C2PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getC3PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getC3PVPartId());
            if(entity !=null) {
                onFillParentInfo_C3PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getC4PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getC4PVPartId());
            if(entity !=null) {
                onFillParentInfo_C4PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getL1PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getL1PVPartId());
            if(entity !=null) {
                onFillParentInfo_L1PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getL2PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getL2PVPartId());
            if(entity !=null) {
                onFillParentInfo_L2PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getL3PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getL3PVPartId());
            if(entity !=null) {
                onFillParentInfo_L3PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getL4PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getL4PVPartId());
            if(entity !=null) {
                onFillParentInfo_L4PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getR1PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getR1PVPartId());
            if(entity !=null) {
                onFillParentInfo_R1PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getR2PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getR2PVPartId());
            if(entity !=null) {
                onFillParentInfo_R2PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getR3PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getR3PVPartId());
            if(entity !=null) {
                onFillParentInfo_R3PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
        if(et.getR4PVPartId()!=null) {
            IEntity entity = cloneSession.getEntity("PVPART",et.getR4PVPartId());
            if(entity !=null) {
                onFillParentInfo_R4PVPart(et,(net.ibizsys.psrt.srv.common.entity.PVPart) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(PPModel et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,PPModel  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 中间部件1
        entityFieldError = onCheckField_C1PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件1
        entityFieldError = onCheckField_C1PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件1
        entityFieldError = onCheckField_C1PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件2
        entityFieldError = onCheckField_C2PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件2
        entityFieldError = onCheckField_C2PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件2
        entityFieldError = onCheckField_C2PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件3
        entityFieldError = onCheckField_C3PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件3
        entityFieldError = onCheckField_C3PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件3
        entityFieldError = onCheckField_C3PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件4
        entityFieldError = onCheckField_C4PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件4
        entityFieldError = onCheckField_C4PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 中间部件4
        entityFieldError = onCheckField_C4PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 系统数据
        entityFieldError = onCheckField_IsSystem( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件1
        entityFieldError = onCheckField_L1PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件1
        entityFieldError = onCheckField_L1PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件1
        entityFieldError = onCheckField_L1PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件2
        entityFieldError = onCheckField_L2PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件2
        entityFieldError = onCheckField_L2PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件2
        entityFieldError = onCheckField_L2PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件3
        entityFieldError = onCheckField_L3PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件3
        entityFieldError = onCheckField_L3PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件3
        entityFieldError = onCheckField_L3PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件4
        entityFieldError = onCheckField_L4PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件4
        entityFieldError = onCheckField_L4PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 左侧部件4
        entityFieldError = onCheckField_L4PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 所有者
        entityFieldError = onCheckField_OwnerId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 门户页面
        entityFieldError = onCheckField_PortalPageId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 频道页
        entityFieldError = onCheckField_PortalPageName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 页面布局
        entityFieldError = onCheckField_PPModel( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 模型明细
        entityFieldError = onCheckField_PPModelDetail( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户频道页标识
        entityFieldError = onCheckField_PPModelId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户频道页名称
        entityFieldError = onCheckField_PPModelName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 版本
        entityFieldError = onCheckField_PPMVersion( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件1
        entityFieldError = onCheckField_R1PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件1
        entityFieldError = onCheckField_R1PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件1
        entityFieldError = onCheckField_R1PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件2
        entityFieldError = onCheckField_R2PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件2
        entityFieldError = onCheckField_R2PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件2
        entityFieldError = onCheckField_R2PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件3
        entityFieldError = onCheckField_R3PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件3
        entityFieldError = onCheckField_R3PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件3
        entityFieldError = onCheckField_R3PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件4
        entityFieldError = onCheckField_R4PVPartCtrlId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件4
        entityFieldError = onCheckField_R4PVPartId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 右侧部件4
        entityFieldError = onCheckField_R4PVPartName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[C1PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C1PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC1PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getC1PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C1PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C1PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C1PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C1PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC1PVPartIdDirty()) {
            return null;
        }

        String value = et.getC1PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C1PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C1PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C1PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C1PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC1PVPartNameDirty()) {
            return null;
        }

        String value = et.getC1PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C1PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C1PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C2PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C2PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC2PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getC2PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C2PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C2PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C2PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C2PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC2PVPartIdDirty()) {
            return null;
        }

        String value = et.getC2PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C2PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C2PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C2PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C2PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC2PVPartNameDirty()) {
            return null;
        }

        String value = et.getC2PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C2PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C2PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C3PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C3PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC3PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getC3PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C3PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C3PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C3PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C3PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC3PVPartIdDirty()) {
            return null;
        }

        String value = et.getC3PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C3PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C3PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C3PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C3PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC3PVPartNameDirty()) {
            return null;
        }

        String value = et.getC3PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C3PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C3PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C4PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C4PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC4PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getC4PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C4PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C4PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C4PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C4PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC4PVPartIdDirty()) {
            return null;
        }

        String value = et.getC4PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C4PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C4PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[C4PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_C4PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isC4PVPartNameDirty()) {
            return null;
        }

        String value = et.getC4PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_C4PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_C4PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[IsSystem]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_IsSystem(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isIsSystemDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_ISSYSTEM);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        Integer value = et.getIsSystem();
        if(bBaseMode) {
            if(bCreate) {
                if(value==null) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_ISSYSTEM);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_IsSystem_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_ISSYSTEM);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L1PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L1PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL1PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getL1PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L1PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L1PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L1PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L1PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL1PVPartIdDirty()) {
            return null;
        }

        String value = et.getL1PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L1PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L1PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L1PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L1PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL1PVPartNameDirty()) {
            return null;
        }

        String value = et.getL1PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L1PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L1PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L2PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L2PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL2PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getL2PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L2PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L2PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L2PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L2PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL2PVPartIdDirty()) {
            return null;
        }

        String value = et.getL2PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L2PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L2PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L2PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L2PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL2PVPartNameDirty()) {
            return null;
        }

        String value = et.getL2PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L2PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L2PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L3PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L3PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL3PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getL3PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L3PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L3PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L3PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L3PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL3PVPartIdDirty()) {
            return null;
        }

        String value = et.getL3PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L3PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L3PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L3PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L3PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL3PVPartNameDirty()) {
            return null;
        }

        String value = et.getL3PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L3PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L3PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L4PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L4PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL4PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getL4PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L4PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L4PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L4PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L4PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL4PVPartIdDirty()) {
            return null;
        }

        String value = et.getL4PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L4PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L4PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[L4PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_L4PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isL4PVPartNameDirty()) {
            return null;
        }

        String value = et.getL4PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_L4PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_L4PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[OwnerId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_OwnerId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isOwnerIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_OWNERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getOwnerId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_OWNERID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_OwnerId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_OWNERID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PortalPageId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PortalPageId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPortalPageIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PORTALPAGEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getPortalPageId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_PORTALPAGEID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PortalPageId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PORTALPAGEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PortalPageName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PortalPageName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPortalPageNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PORTALPAGENAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getPortalPageName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_PORTALPAGENAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PortalPageName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PORTALPAGENAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PPModel]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PPModel(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPPModelDirty()) {
            return null;
        }

        String value = et.getPPModel();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PPModel_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMODEL);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PPModelDetail]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PPModelDetail(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPPModelDetailDirty()) {
            return null;
        }

        String value = et.getPPModelDetail();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PPModelDetail_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMODELDETAIL);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PPModelId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PPModelId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPPModelIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMODELID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getPPModelId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_PPMODELID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PPModelId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMODELID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PPModelName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PPModelName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPPModelNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMODELNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getPPModelName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_PPMODELNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PPModelName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMODELNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[PPMVersion]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_PPMVersion(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isPPMVersionDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMVERSION);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        Integer value = et.getPPMVersion();
        if(bBaseMode) {
            if(bCreate) {
                if(value==null) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(PPModel.FIELD_PPMVERSION);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_PPMVersion_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_PPMVERSION);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R1PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R1PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR1PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getR1PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R1PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R1PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R1PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R1PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR1PVPartIdDirty()) {
            return null;
        }

        String value = et.getR1PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R1PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R1PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R1PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R1PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR1PVPartNameDirty()) {
            return null;
        }

        String value = et.getR1PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R1PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R1PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R2PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R2PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR2PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getR2PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R2PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R2PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R2PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R2PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR2PVPartIdDirty()) {
            return null;
        }

        String value = et.getR2PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R2PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R2PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R2PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R2PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR2PVPartNameDirty()) {
            return null;
        }

        String value = et.getR2PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R2PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R2PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R3PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R3PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR3PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getR3PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R3PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R3PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R3PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R3PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR3PVPartIdDirty()) {
            return null;
        }

        String value = et.getR3PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R3PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R3PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R3PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R3PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR3PVPartNameDirty()) {
            return null;
        }

        String value = et.getR3PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R3PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R3PVPARTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R4PVPartCtrlId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R4PVPartCtrlId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR4PVPartCtrlIdDirty()) {
            return null;
        }

        String value = et.getR4PVPartCtrlId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R4PVPartCtrlId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R4PVPARTCTRLID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R4PVPartId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R4PVPartId(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR4PVPartIdDirty()) {
            return null;
        }

        String value = et.getR4PVPartId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R4PVPartId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R4PVPARTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[R4PVPartName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_R4PVPartName(boolean bBaseMode,PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isR4PVPartNameDirty()) {
            return null;
        }

        String value = et.getR4PVPartName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_R4PVPartName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(PPModel.FIELD_R4PVPARTNAME);
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
    protected void onSyncEntity(PPModel et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(PPModel et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(PPModel et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C1PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C1PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C1PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C1PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C1PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C1PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C2PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C2PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C2PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C2PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C2PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C2PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C3PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C3PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C3PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C3PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C3PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C3PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C4PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C4PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C4PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C4PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_C4PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_C4PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_ISSYSTEM,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_IsSystem_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L1PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L1PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L1PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L1PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L1PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L1PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L2PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L2PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L2PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L2PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L2PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L2PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L3PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L3PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L3PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L3PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L3PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L3PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L4PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L4PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L4PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L4PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_L4PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_L4PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_OWNERID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_OwnerId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PORTALPAGEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PortalPageId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PORTALPAGENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PortalPageName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PPMODEL,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PPModel_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PPMODELDETAIL,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PPModelDetail_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PPMODELID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PPModelId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PPMODELNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PPModelName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_PPMVERSION,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_PPMVersion_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R1PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R1PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R1PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R1PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R1PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R1PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R2PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R2PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R2PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R2PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R2PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R2PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R3PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R3PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R3PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R3PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R3PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R3PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R4PVPARTCTRLID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R4PVPartCtrlId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R4PVPARTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R4PVPartId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_R4PVPARTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_R4PVPartName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,PPModel.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[中间部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C1PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C1PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C1PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C1PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C1PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C1PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C2PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C2PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C2PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C2PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C2PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C2PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C3PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C3PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C3PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C3PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C3PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C3PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C4PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C4PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C4PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C4PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[中间部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_C4PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("C4PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
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
     * 判断值规则[系统数据][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_IsSystem_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[左侧部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L1PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L1PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L1PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L1PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L1PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L1PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L2PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L2PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L2PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L2PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L2PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L2PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L3PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L3PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L3PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L3PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L3PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L3PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L4PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L4PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L4PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L4PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[左侧部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_L4PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("L4PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[所有者][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_OwnerId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("OWNERID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[门户页面][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PortalPageId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PORTALPAGEID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[频道页][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PortalPageName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PORTALPAGENAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[页面布局][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PPModel_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PPMODEL", et, bTempMode,null,false,2000,true,"内容长度必须小于等于[2000]",false)))
                return null;
            return "内容长度必须小于等于[2000]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[模型明细][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PPModelDetail_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PPMODELDETAIL", et, bTempMode,null,false,1048576,true,"内容长度必须小于等于[1048576]",false)))
                return null;
            return "内容长度必须小于等于[1048576]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户频道页标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PPModelId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PPMODELID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户频道页名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PPModelName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("PPMODELNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[版本][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_PPMVersion_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
    }

    /**
     * 判断值规则[右侧部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R1PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R1PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R1PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R1PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件1][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R1PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R1PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R2PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R2PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R2PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R2PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R2PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R2PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R3PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R3PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R3PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R3PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件3][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R3PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R3PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R4PVPartCtrlId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R4PVPARTCTRLID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R4PVPartId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R4PVPARTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[右侧部件4][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_R4PVPartName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("R4PVPARTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, PPModel et) throws Exception {
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
    protected void onUpdateParent(PPModel et)throws Exception {
        super.onUpdateParent(et);
    }


}