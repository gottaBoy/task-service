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



import net.ibizsys.psrt.srv.wf.entity.WFStepInst;
import net.ibizsys.psrt.srv.wf.dao.WFStepInstDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFStepInstDEModel;

/**
 * 实体[WFStepInst] 服务对象基类
 */
public abstract class WFStepInstServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFStepInst> {
    private static final Log log = LogFactory.getLog(WFStepInstServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WFStepInstServiceBase () {
        super();

    }

    /**
     * 获取实体[WFStepInst]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFStepInstService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFStepInst]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFStepInstService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFStepInstService)ServiceGlobal.getService(WFStepInstService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wf.service.WFStepInstService";
    }

    private WFStepInstDEModel wFStepInstDEModel;
    /**
     * 获取实体[WFStepInst]模型对象
     */
    public  WFStepInstDEModel getWFStepInstDEModel() {
        if(this.wFStepInstDEModel==null) {
            try {
                this.wFStepInstDEModel = (WFStepInstDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepInstDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFStepInstDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFStepInstDEModel();
    }


    private WFStepInstDAO wFStepInstDAO;

    /**
     * 获取实体[WFStepInst]数据操作对象
     */
    public  WFStepInstDAO getWFStepInstDAO() {
        if(this.wFStepInstDAO==null) {
            try {
                this.wFStepInstDAO= (WFStepInstDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFStepInstDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFStepInstDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFStepInstDAO();
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
    protected void onFillParentInfo(WFStepInst et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WFINSTANCE / 工作流实例
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID", true)==0)) {
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
        //关系类型 : DER1N ,主实体 :WFSTEP / 工作流步骤
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFSTEPINST_WFSTEP_WFSTEPID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFStep)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFStep.FIELD_WFSTEPID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_Wfstep(et,parentEntity );
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
    protected void onFillParentInfo_WFInstance(WFStepInst et,net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity) throws Exception {
        et.setWFInstanceId(parentEntity.getWFInstanceId());
        et.setWFInstanceName(parentEntity.getWFInstanceName());
    }

    /**
    * 填充数据的父数据信息[工作流步骤]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_Wfstep(WFStepInst et,net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        et.setWFStepId(parentEntity.getWFStepId());
        et.setWFStepName(parentEntity.getWFPLogicName());
    }


    /**
    * 填充主键
     * @param et
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onFillEntityKeyValue(WFStepInst et,boolean bTempMode) throws Exception {
        StringBuilderEx sb  = new StringBuilderEx();
        //属性 WFInstanceId - 子流程实例
        Object objWFInstanceId = et.get(WFStepInst.FIELD_WFINSTANCEID);
        if(objWFInstanceId==null)
            objWFInstanceId = "__EMTPY__";
        sb.append("%1$s", objWFInstanceId);
        //属性 WFStepId - 工作流步骤
        sb.append("||");
        Object objWFStepId = et.get(WFStepInst.FIELD_WFSTEPID);
        if(objWFStepId==null)
            objWFStepId = "__EMTPY__";
        sb.append("%1$s", objWFStepId);
        String strValue = sb.toString();
        et.set(this.getWFStepInstDEModel().getUniTagDEField().getName(),KeyValueHelper.genUniqueId(strValue));
        return true;
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFStepInst et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getWFStepInstName()==null) {
                et.setWFStepInstName((String)DefaultValueHelper.getValue(this.getWebContext(),"","工作流步骤子实例",25));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WFINSTANCE / 工作流实例
        onFillEntityFullInfo_WFInstance(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFSTEP / 工作流步骤
        onFillEntityFullInfo_Wfstep(et, bCreate);
    }

    /**
    * 填充实体的数据信息 工作流实例
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFInstance(WFStepInst et, boolean bCreate) throws Exception {
        if(et.isWFInstanceIdDirty()) {
            if(et.getWFInstanceId()!=null) {
                if((true&&et.getWFInstanceId()==null)||(true&&et.getWFInstanceName()==null)) {
                    net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity  = et.getWFInstance();
                    et.setWFInstanceName(parentEntity.getWFInstanceName());
                }

            } else {
                et.setWFInstanceName(null);
            }
        }
    }
    /**
    * 填充实体的数据信息 工作流步骤
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_Wfstep(WFStepInst et, boolean bCreate) throws Exception {
        if(et.isWFStepIdDirty()) {
            if(et.getWFStepId()!=null) {
                if((true&&et.getWFStepId()==null)||(true&&et.getWFStepName()==null)) {
                    net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity  = et.getWfstep();
                    et.setWFStepName(parentEntity.getWFPLogicName());
                }

            } else {
                et.setWFStepName(null);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFStepInst et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[工作流实例]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFStepInst> selectByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstanceBase parentEntity) throws Exception {
        return selectByWFInstance( parentEntity,"");
    }
    /**
     * 通过关系[工作流实例]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFStepInst> selectByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstanceBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFStepInst.FIELD_WFINSTANCEID, parentEntity.getWFInstanceId());
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
     * 通过关系[工作流步骤]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFStepInst> selectByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStepBase parentEntity) throws Exception {
        return selectByWfstep( parentEntity,"");
    }
    /**
     * 通过关系[工作流步骤]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFStepInst> selectByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStepBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFStepInst.FIELD_WFSTEPID, parentEntity.getWFStepId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWfstepCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流步骤]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWfstepCond(SelectCond selectCond) throws Exception {

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
        java.util.ArrayList<WFStepInst> list =  this.selectByWFInstance(parentEntity);
        for(WFStepInst item:list) {
            WFStepInst item2 = (WFStepInst)getDEModel().createEntity();
            item2.setWFStepInstId(item.getWFStepInstId());
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
        java.util.ArrayList<WFStepInst> removeList = selectByWFInstance(parentEntity);
        onBeforeRemoveByWFInstance(parentEntity,removeList );

        // 执行删除
        for (WFStepInst item : removeList ) {
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
    protected void onBeforeRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity,java.util.ArrayList<WFStepInst> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流实例]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFInstance(net.ibizsys.psrt.srv.wf.entity.WFInstance parentEntity,java.util.ArrayList<WFStepInst> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[工作流步骤]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        java.util.ArrayList<WFStepInst> list =  this.selectByWfstep(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFSTEP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFSTEPINST_WFSTEP_WFSTEPID","" ,parentDEModel.getName(),"WFSTEPINST",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[工作流步骤]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        java.util.ArrayList<WFStepInst> list =  this.selectByWfstep(parentEntity);
        for(WFStepInst item:list) {
            WFStepInst item2 = (WFStepInst)getDEModel().createEntity();
            item2.setWFStepInstId(item.getWFStepInstId());
            item2.setWFStepId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流步骤]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWfstep(parentEntity2);
                internalRemoveByWfstep(parentEntity2);
                onAfterRemoveByWfstep(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流步骤]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流步骤]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {
        java.util.ArrayList<WFStepInst> removeList = selectByWfstep(parentEntity);
        onBeforeRemoveByWfstep(parentEntity,removeList );

        // 执行删除
        for (WFStepInst item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWfstep(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流步骤]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流步骤]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity,java.util.ArrayList<WFStepInst> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流步骤]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWfstep(net.ibizsys.psrt.srv.wf.entity.WFStep parentEntity,java.util.ArrayList<WFStepInst> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFStepInst et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFStepInst et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWFInstanceId()!=null) {
            IEntity entity = cloneSession.getEntity("WFINSTANCE",et.getWFInstanceId());
            if(entity !=null) {
                onFillParentInfo_WFInstance(et,(net.ibizsys.psrt.srv.wf.entity.WFInstance) entity);
            }
        }
        if(et.getWFStepId()!=null) {
            IEntity entity = cloneSession.getEntity("WFSTEP",et.getWFStepId());
            if(entity !=null) {
                onFillParentInfo_Wfstep(et,(net.ibizsys.psrt.srv.wf.entity.WFStep) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(WFStepInst et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFStepInst  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 实例关闭标志
        entityFieldError = onCheckField_CloseFlag( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 流程返回值
        entityFieldError = onCheckField_ReturnData( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 子流程实例
        entityFieldError = onCheckField_WFInstanceId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 子流程实例
        entityFieldError = onCheckField_WFInstanceName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流步骤
        entityFieldError = onCheckField_WFStepId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流步骤子实例标识
        entityFieldError = onCheckField_WFStepInstId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流步骤子实例名称
        entityFieldError = onCheckField_WFStepInstName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 步骤语言资源
        entityFieldError = onCheckField_WFStepLanResTag( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流步骤
        entityFieldError = onCheckField_WFStepName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[CloseFlag]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_CloseFlag(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isCloseFlagDirty()) {
            return null;
        }

        Integer value = et.getCloseFlag();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_CloseFlag_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_CLOSEFLAG);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[ReturnData]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_ReturnData(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isReturnDataDirty()) {
            return null;
        }

        String value = et.getReturnData();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_ReturnData_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_RETURNDATA);
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
    protected EntityFieldError onCheckField_WFInstanceId(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFInstanceIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFINSTANCEID);
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
                    entityFieldError.setFieldName(WFStepInst.FIELD_WFINSTANCEID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFInstanceId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFINSTANCEID);
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
    protected EntityFieldError onCheckField_WFInstanceName(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFInstanceNameDirty()) {
            return null;
        }

        String value = et.getWFInstanceName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFInstanceName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFINSTANCENAME);
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
    protected EntityFieldError onCheckField_WFStepId(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFStepId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStepInstId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStepInstId(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepInstIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPINSTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFStepInstId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPINSTID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepInstId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPINSTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStepInstName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStepInstName(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepInstNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPINSTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFStepInstName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPINSTNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepInstName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPINSTNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStepLanResTag]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStepLanResTag(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepLanResTagDirty()) {
            return null;
        }

        String value = et.getWFStepLanResTag();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepLanResTag_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPLANRESTAG);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFStepName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFStepName(boolean bBaseMode,WFStepInst et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFStepNameDirty()) {
            return null;
        }

        String value = et.getWFStepName();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFStepName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFStepInst.FIELD_WFSTEPNAME);
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
    protected void onSyncEntity(WFStepInst et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFStepInst et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFStepInst et,String strField,IDataContextParam iDataContextParam)throws Exception {
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
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_CLOSEFLAG,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CloseFlag_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_RETURNDATA,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_ReturnData_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFINSTANCEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFInstanceId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFINSTANCENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFInstanceName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFSTEPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFSTEPINSTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepInstId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFSTEPINSTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepInstName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFSTEPLANRESTAG,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepLanResTag_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFStepInst.FIELD_WFSTEPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFStepName_Default(et,bCreate,bTempMode);

        return super.onTestValueRule( strDEFieldName, strRule, et,bCreate, bTempMode);
    }

    /**
     * 判断值规则[实例关闭标志][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_CloseFlag_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        return null;
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
     * 判断值规则[流程返回值][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_ReturnData_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("RETURNDATA", et, bTempMode,null,false,500,true,"内容长度必须小于等于[500]",false)))
                return null;
            return "内容长度必须小于等于[500]";
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
     * 判断值规则[子流程实例][默认规则]
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
     * 判断值规则[子流程实例][默认规则]
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
     * 判断值规则[工作流步骤][默认规则]
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
     * 判断值规则[工作流步骤子实例标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepInstId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPINSTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流步骤子实例名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepInstName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPINSTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[步骤语言资源][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepLanResTag_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPLANRESTAG", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流步骤][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFStepName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFSTEPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFStepInst et) throws Exception {
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
    protected void onUpdateParent(WFStepInst et)throws Exception {
        super.onUpdateParent(et);
    }


}