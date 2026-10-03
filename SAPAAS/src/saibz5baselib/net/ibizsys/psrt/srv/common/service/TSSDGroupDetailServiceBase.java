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



import net.ibizsys.psrt.srv.common.entity.TSSDGroupDetail;
import net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO;
import net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel;

/**
 * 实体[TSSDGroupDetail] 服务对象基类
 */
public abstract class TSSDGroupDetailServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<TSSDGroupDetail> {
    private static final Log log = LogFactory.getLog(TSSDGroupDetailServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public TSSDGroupDetailServiceBase () {
        super();

    }

    /**
     * 获取实体[TSSDGroupDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static TSSDGroupDetailService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[TSSDGroupDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static TSSDGroupDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (TSSDGroupDetailService)ServiceGlobal.getService(TSSDGroupDetailService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService";
    }

    private TSSDGroupDetailDEModel tSSDGroupDetailDEModel;
    /**
     * 获取实体[TSSDGroupDetail]模型对象
     */
    public  TSSDGroupDetailDEModel getTSSDGroupDetailDEModel() {
        if(this.tSSDGroupDetailDEModel==null) {
            try {
                this.tSSDGroupDetailDEModel = (TSSDGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel");
            } catch(Exception ex) {
            }
        }
        return this.tSSDGroupDetailDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getTSSDGroupDetailDEModel();
    }


    private TSSDGroupDetailDAO tSSDGroupDetailDAO;

    /**
     * 获取实体[TSSDGroupDetail]数据操作对象
     */
    public  TSSDGroupDetailDAO getTSSDGroupDetailDAO() {
        if(this.tSSDGroupDetailDAO==null) {
            try {
                this.tSSDGroupDetailDAO= (TSSDGroupDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.tSSDGroupDetailDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getTSSDGroupDetailDAO();
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
    protected void onFillParentInfo(TSSDGroupDetail et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :TSSDGROUP / 任务时刻策略组
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDGroupService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity = ( net.ibizsys.psrt.srv.common.entity.TSSDGroup)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.TSSDGroup.FIELD_TSSDGROUPID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_TSSDGroup(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :TSSDITEM / 任务时刻策略项
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDItemService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity = ( net.ibizsys.psrt.srv.common.entity.TSSDItem)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.TSSDItem.FIELD_TSSDITEMID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_TSSDItem(et,parentEntity );
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
    * 填充数据的父数据信息[任务时刻策略组]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_TSSDGroup(TSSDGroupDetail et,net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {
        et.setTSSDGroupId(parentEntity.getTSSDGroupId());
        et.setTSSDGroupName(parentEntity.getTSSDGroupName());
    }

    /**
    * 填充数据的父数据信息[任务时刻策略项]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_TSSDItem(TSSDGroupDetail et,net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {
        et.setTSSDItemId(parentEntity.getTSSDItemId());
        et.setTSSDItemName(parentEntity.getTSSDItemName());
    }




    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(TSSDGroupDetail et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :TSSDGROUP / 任务时刻策略组
        onFillEntityFullInfo_TSSDGroup(et, bCreate);
        //关系类型 : DER1N ,主实体 :TSSDITEM / 任务时刻策略项
        onFillEntityFullInfo_TSSDItem(et, bCreate);
    }

    /**
    * 填充实体的数据信息 任务时刻策略组
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_TSSDGroup(TSSDGroupDetail et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 任务时刻策略项
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_TSSDItem(TSSDGroupDetail et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(TSSDGroupDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[任务时刻策略组]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<TSSDGroupDetail> selectByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroupBase parentEntity) throws Exception {
        return selectByTSSDGroup( parentEntity,"");
    }
    /**
     * 通过关系[任务时刻策略组]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<TSSDGroupDetail> selectByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroupBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(TSSDGroupDetail.FIELD_TSSDGROUPID, parentEntity.getTSSDGroupId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByTSSDGroupCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[任务时刻策略组]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByTSSDGroupCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略项]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<TSSDGroupDetail> selectByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItemBase parentEntity) throws Exception {
        return selectByTSSDItem( parentEntity,"");
    }
    /**
     * 通过关系[任务时刻策略项]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<TSSDGroupDetail> selectByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItemBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(TSSDGroupDetail.FIELD_TSSDITEMID, parentEntity.getTSSDItemId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByTSSDItemCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[任务时刻策略项]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByTSSDItemCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[任务时刻策略组]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {
    }


    /**
     * 通过关系[任务时刻策略组]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {
        java.util.ArrayList<TSSDGroupDetail> list =  this.selectByTSSDGroup(parentEntity);
        for(TSSDGroupDetail item:list) {
            TSSDGroupDetail item2 = (TSSDGroupDetail)getDEModel().createEntity();
            item2.setTSSDGroupDetailId(item.getTSSDGroupDetailId());
            item2.setTSSDGroupId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[任务时刻策略组]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByTSSDGroup(parentEntity2);
                internalRemoveByTSSDGroup(parentEntity2);
                onAfterRemoveByTSSDGroup(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[任务时刻策略组]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[任务时刻策略组]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {
        java.util.ArrayList<TSSDGroupDetail> removeList = selectByTSSDGroup(parentEntity);
        onBeforeRemoveByTSSDGroup(parentEntity,removeList );

        // 执行删除
        for (TSSDGroupDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByTSSDGroup(parentEntity,removeList );
    }

    /**
     * 通过关系[任务时刻策略组]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略组]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity,java.util.ArrayList<TSSDGroupDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略组]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDGroup(net.ibizsys.psrt.srv.common.entity.TSSDGroup parentEntity,java.util.ArrayList<TSSDGroupDetail> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[任务时刻策略项]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {
    }


    /**
     * 通过关系[任务时刻策略项]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {
        java.util.ArrayList<TSSDGroupDetail> list =  this.selectByTSSDItem(parentEntity);
        for(TSSDGroupDetail item:list) {
            TSSDGroupDetail item2 = (TSSDGroupDetail)getDEModel().createEntity();
            item2.setTSSDGroupDetailId(item.getTSSDGroupDetailId());
            item2.setTSSDItemId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[任务时刻策略项]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByTSSDItem(parentEntity2);
                internalRemoveByTSSDItem(parentEntity2);
                onAfterRemoveByTSSDItem(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[任务时刻策略项]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[任务时刻策略项]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {
        java.util.ArrayList<TSSDGroupDetail> removeList = selectByTSSDItem(parentEntity);
        onBeforeRemoveByTSSDItem(parentEntity,removeList );

        // 执行删除
        for (TSSDGroupDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByTSSDItem(parentEntity,removeList );
    }

    /**
     * 通过关系[任务时刻策略项]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略项]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity,java.util.ArrayList<TSSDGroupDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[任务时刻策略项]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByTSSDItem(net.ibizsys.psrt.srv.common.entity.TSSDItem parentEntity,java.util.ArrayList<TSSDGroupDetail> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(TSSDGroupDetail et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(TSSDGroupDetail et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getTSSDGroupId()!=null) {
            IEntity entity = cloneSession.getEntity("TSSDGROUP",et.getTSSDGroupId());
            if(entity !=null) {
                onFillParentInfo_TSSDGroup(et,(net.ibizsys.psrt.srv.common.entity.TSSDGroup) entity);
            }
        }
        if(et.getTSSDItemId()!=null) {
            IEntity entity = cloneSession.getEntity("TSSDITEM",et.getTSSDItemId());
            if(entity !=null) {
                onFillParentInfo_TSSDItem(et,(net.ibizsys.psrt.srv.common.entity.TSSDItem) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(TSSDGroupDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,TSSDGroupDetail  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 任务时刻策略组明细标识
        entityFieldError = onCheckField_TSSDGroupDetailId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 任务时刻策略组明细名称
        entityFieldError = onCheckField_TSSDGroupDetailName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 任务时刻策略组
        entityFieldError = onCheckField_TSSDGroupId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 任务时刻策略项
        entityFieldError = onCheckField_TSSDItemId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[TSSDGroupDetailId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDGroupDetailId(boolean bBaseMode,TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDGroupDetailIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getTSSDGroupDetailId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPDETAILID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDGroupDetailId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDGroupDetailName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDGroupDetailName(boolean bBaseMode,TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDGroupDetailNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getTSSDGroupDetailName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPDETAILNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDGroupDetailName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDGroupId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDGroupId(boolean bBaseMode,TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDGroupIdDirty()) {
            return null;
        }

        String value = et.getTSSDGroupId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDGroupId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDGROUPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[TSSDItemId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_TSSDItemId(boolean bBaseMode,TSSDGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isTSSDItemIdDirty()) {
            return null;
        }

        String value = et.getTSSDItemId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_TSSDItemId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(TSSDGroupDetail.FIELD_TSSDITEMID);
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
    protected void onSyncEntity(TSSDGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(TSSDGroupDetail et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(TSSDGroupDetail et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_TSSDGROUPDETAILID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDGroupDetailId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_TSSDGROUPDETAILNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDGroupDetailName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_TSSDGROUPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDGroupId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_TSSDGROUPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDGroupName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_TSSDITEMID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDItemId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_TSSDITEMNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_TSSDItemName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,TSSDGroupDetail.FIELD_UPDATEMAN,true)==0)
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
     * 判断值规则[任务时刻策略组明细标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDGroupDetailId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDGROUPDETAILID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务时刻策略组明细名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDGroupDetailName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDGROUPDETAILNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务时刻策略组][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDGroupId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDGROUPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务时刻策略组][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDGroupName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDGROUPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务时刻策略项][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDItemId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDITEMID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[任务时刻策略项][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_TSSDItemName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("TSSDITEMNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, TSSDGroupDetail et) throws Exception {
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
    protected void onUpdateParent(TSSDGroupDetail et)throws Exception {
        super.onUpdateParent(et);
    }


}