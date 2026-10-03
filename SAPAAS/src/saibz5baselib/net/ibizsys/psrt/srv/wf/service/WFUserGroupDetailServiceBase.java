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



import net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail;
import net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO;
import net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDetailDEModel;

/**
 * 实体[WFUserGroupDetail] 服务对象基类
 */
public abstract class WFUserGroupDetailServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<WFUserGroupDetail> {
    private static final Log log = LogFactory.getLog(WFUserGroupDetailServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public WFUserGroupDetailServiceBase () {
        super();

    }

    /**
     * 获取实体[WFUserGroupDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFUserGroupDetailService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[WFUserGroupDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static WFUserGroupDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (WFUserGroupDetailService)ServiceGlobal.getService(WFUserGroupDetailService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService";
    }

    private WFUserGroupDetailDEModel wFUserGroupDetailDEModel;
    /**
     * 获取实体[WFUserGroupDetail]模型对象
     */
    public  WFUserGroupDetailDEModel getWFUserGroupDetailDEModel() {
        if(this.wFUserGroupDetailDEModel==null) {
            try {
                this.wFUserGroupDetailDEModel = (WFUserGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDetailDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFUserGroupDetailDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFUserGroupDetailDEModel();
    }


    private WFUserGroupDetailDAO wFUserGroupDetailDAO;

    /**
     * 获取实体[WFUserGroupDetail]数据操作对象
     */
    public  WFUserGroupDetailDAO getWFUserGroupDetailDAO() {
        if(this.wFUserGroupDetailDAO==null) {
            try {
                this.wFUserGroupDetailDAO= (WFUserGroupDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.wFUserGroupDetailDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getWFUserGroupDetailDAO();
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
    protected void onFillParentInfo(WFUserGroupDetail et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :WFUSERGROUP / 工作流用户组
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserGroupService",this.getSessionFactory());
            net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity = ( net.ibizsys.psrt.srv.wf.entity.WFUserGroup)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.wf.entity.WFUserGroup.FIELD_WFUSERGROUPID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_WFUserGroup(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID", true)==0)) {
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
    * 填充数据的父数据信息[工作流用户组]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFUserGroup(WFUserGroupDetail et,net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {
        et.setWFUserGroupId(parentEntity.getWFUserGroupId());
        et.setWFUserGroupName(parentEntity.getWFUserGroupName());
    }

    /**
    * 填充数据的父数据信息[工作流用户]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_WFUser(WFUserGroupDetail et,net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity) throws Exception {
        et.setWFUserId(parentEntity.getWFUserId());
        et.setWFUserName(parentEntity.getWFUserName());
    }


    /**
    * 填充主键
     * @param et
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onFillEntityKeyValue(WFUserGroupDetail et,boolean bTempMode) throws Exception {
        StringBuilderEx sb  = new StringBuilderEx();
        //属性 WFUserGroupId - 用户组
        Object objWFUserGroupId = et.get(WFUserGroupDetail.FIELD_WFUSERGROUPID);
        if(objWFUserGroupId==null)
            objWFUserGroupId = "__EMTPY__";
        sb.append("%1$s", objWFUserGroupId);
        //属性 WFUserId - 用户
        sb.append("||");
        Object objWFUserId = et.get(WFUserGroupDetail.FIELD_WFUSERID);
        if(objWFUserId==null)
            objWFUserId = "__EMTPY__";
        sb.append("%1$s", objWFUserId);
        String strValue = sb.toString();
        et.set(this.getWFUserGroupDetailDEModel().getUniTagDEField().getName(),KeyValueHelper.genUniqueId(strValue));
        return true;
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(WFUserGroupDetail et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getWFUserGroupDetailName()==null) {
                et.setWFUserGroupDetailName((String)DefaultValueHelper.getValue(this.getWebContext(),"","工作流用户",25));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :WFUSERGROUP / 工作流用户组
        onFillEntityFullInfo_WFUserGroup(et, bCreate);
        //关系类型 : DER1N ,主实体 :WFUSER / 工作流用户
        onFillEntityFullInfo_WFUser(et, bCreate);
    }

    /**
    * 填充实体的数据信息 工作流用户组
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFUserGroup(WFUserGroupDetail et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 工作流用户
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_WFUser(WFUserGroupDetail et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(WFUserGroupDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[工作流用户组]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFUserGroupDetail> selectByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroupBase parentEntity) throws Exception {
        return selectByWFUserGroup( parentEntity,"");
    }
    /**
     * 通过关系[工作流用户组]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFUserGroupDetail> selectByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroupBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFUserGroupDetail.FIELD_WFUSERGROUPID, parentEntity.getWFUserGroupId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByWFUserGroupCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[工作流用户组]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByWFUserGroupCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<WFUserGroupDetail> selectByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity) throws Exception {
        return selectByWFUser( parentEntity,"");
    }
    /**
     * 通过关系[工作流用户]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<WFUserGroupDetail> selectByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUserBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(WFUserGroupDetail.FIELD_WFUSERID, parentEntity.getWFUserId());
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
     * 判断是否能够通过关系[工作流用户组]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {
        java.util.ArrayList<WFUserGroupDetail> list =  this.selectByWFUserGroup(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("WFUSERGROUP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID","" ,parentDEModel.getName(),"WFUSERGROUPDETAIL",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[工作流用户组]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {
        java.util.ArrayList<WFUserGroupDetail> list =  this.selectByWFUserGroup(parentEntity);
        for(WFUserGroupDetail item:list) {
            WFUserGroupDetail item2 = (WFUserGroupDetail)getDEModel().createEntity();
            item2.setWFUserGroupDetailId(item.getWFUserGroupDetailId());
            item2.setWFUserGroupId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[工作流用户组]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByWFUserGroup(parentEntity2);
                internalRemoveByWFUserGroup(parentEntity2);
                onAfterRemoveByWFUserGroup(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[工作流用户组]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[工作流用户组]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {
        java.util.ArrayList<WFUserGroupDetail> removeList = selectByWFUserGroup(parentEntity);
        onBeforeRemoveByWFUserGroup(parentEntity,removeList );

        // 执行删除
        for (WFUserGroupDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByWFUserGroup(parentEntity,removeList );
    }

    /**
     * 通过关系[工作流用户组]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity) throws Exception {

    }

    /**
     * 通过关系[工作流用户组]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity,java.util.ArrayList<WFUserGroupDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流用户组]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFUserGroup(net.ibizsys.psrt.srv.wf.entity.WFUserGroup parentEntity,java.util.ArrayList<WFUserGroupDetail> removeList) throws Exception {

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
        java.util.ArrayList<WFUserGroupDetail> list =  this.selectByWFUser(parentEntity);
        for(WFUserGroupDetail item:list) {
            WFUserGroupDetail item2 = (WFUserGroupDetail)getDEModel().createEntity();
            item2.setWFUserGroupDetailId(item.getWFUserGroupDetailId());
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
        java.util.ArrayList<WFUserGroupDetail> removeList = selectByWFUser(parentEntity);
        onBeforeRemoveByWFUser(parentEntity,removeList );

        // 执行删除
        for (WFUserGroupDetail item : removeList ) {
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
    protected void onBeforeRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFUserGroupDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[工作流用户]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByWFUser(net.ibizsys.psrt.srv.wf.entity.WFUser parentEntity,java.util.ArrayList<WFUserGroupDetail> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(WFUserGroupDetail et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(WFUserGroupDetail et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getWFUserGroupId()!=null) {
            IEntity entity = cloneSession.getEntity("WFUSERGROUP",et.getWFUserGroupId());
            if(entity !=null) {
                onFillParentInfo_WFUserGroup(et,(net.ibizsys.psrt.srv.wf.entity.WFUserGroup) entity);
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
    protected void onRemoveEntityUncopyValues(WFUserGroupDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,WFUserGroupDetail  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 备注
        entityFieldError = onCheckField_Memo( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流用户组成员标识
        entityFieldError = onCheckField_WFUserGroupDetailId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 工作流用户名称
        entityFieldError = onCheckField_WFUserGroupDetailName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户组
        entityFieldError = onCheckField_WFUserGroupId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户
        entityFieldError = onCheckField_WFUserId( bBaseMode,  et,  bCreate,  bTempMode);
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
    protected EntityFieldError onCheckField_Memo(boolean bBaseMode,WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_MEMO);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserGroupDetailId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserGroupDetailId(boolean bBaseMode,WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserGroupDetailIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFUserGroupDetailId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPDETAILID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserGroupDetailId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserGroupDetailName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserGroupDetailName(boolean bBaseMode,WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserGroupDetailNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getWFUserGroupDetailName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPDETAILNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserGroupDetailName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[WFUserGroupId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_WFUserGroupId(boolean bBaseMode,WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isWFUserGroupIdDirty()) {
            return null;
        }

        String value = et.getWFUserGroupId();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_WFUserGroupId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERGROUPID);
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
    protected EntityFieldError onCheckField_WFUserId(boolean bBaseMode,WFUserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(WFUserGroupDetail.FIELD_WFUSERID);
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
    protected void onSyncEntity(WFUserGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(WFUserGroupDetail et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(WFUserGroupDetail et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        IEntity wFUserGroup =et.getWFUserGroup();
        if(wFUserGroup!=null) {
            if(wFUserGroup.contains(strField)) {
                return wFUserGroup.get(strField);
            }
        }
        IEntity wFUser =et.getWFUser();
        if(wFUser!=null) {
            if(wFUser.contains(strField)) {
                return wFUser.get(strField);
            }
        }
        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_MEMO,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Memo_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_WFUSERGROUPDETAILID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserGroupDetailId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_WFUSERGROUPDETAILNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserGroupDetailName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_WFUSERGROUPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserGroupId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_WFUSERGROUPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserGroupName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_WFUSERID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,WFUserGroupDetail.FIELD_WFUSERNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_WFUserName_Default(et,bCreate,bTempMode);

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
     * 判断值规则[工作流用户组成员标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserGroupDetailId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERGROUPDETAILID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流用户名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserGroupDetailName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERGROUPDETAILNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户组][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserGroupId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERGROUPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[工作流用户组][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_WFUserGroupName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("WFUSERGROUPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户][默认规则]
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
     * 判断值规则[工作流用户][默认规则]
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, WFUserGroupDetail et) throws Exception {
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
    protected void onUpdateParent(WFUserGroupDetail et)throws Exception {
        super.onUpdateParent(et);
    }


}