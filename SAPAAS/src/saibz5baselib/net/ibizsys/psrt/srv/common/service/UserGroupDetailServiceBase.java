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



import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;
import net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO;
import net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel;

/**
 * 实体[UserGroupDetail] 服务对象基类
 */
public abstract class UserGroupDetailServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<UserGroupDetail> {
    private static final Log log = LogFactory.getLog(UserGroupDetailServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public UserGroupDetailServiceBase () {
        super();

    }

    /**
     * 获取实体[UserGroupDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static UserGroupDetailService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[UserGroupDetail]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static UserGroupDetailService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserGroupDetailService)ServiceGlobal.getService(UserGroupDetailService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.UserGroupDetailService";
    }

    private UserGroupDetailDEModel userGroupDetailDEModel;
    /**
     * 获取实体[UserGroupDetail]模型对象
     */
    public  UserGroupDetailDEModel getUserGroupDetailDEModel() {
        if(this.userGroupDetailDEModel==null) {
            try {
                this.userGroupDetailDEModel = (UserGroupDetailDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel");
            } catch(Exception ex) {
            }
        }
        return this.userGroupDetailDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getUserGroupDetailDEModel();
    }


    private UserGroupDetailDAO userGroupDetailDAO;

    /**
     * 获取实体[UserGroupDetail]数据操作对象
     */
    public  UserGroupDetailDAO getUserGroupDetailDAO() {
        if(this.userGroupDetailDAO==null) {
            try {
                this.userGroupDetailDAO= (UserGroupDetailDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.userGroupDetailDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getUserGroupDetailDAO();
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
    protected void onFillParentInfo(UserGroupDetail et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :USERGROUP / 用户组
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserGroupService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity = ( net.ibizsys.psrt.srv.common.entity.UserGroup)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.UserGroup.FIELD_USERGROUPID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_UserGroup(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :USEROBJECT / 用户对象
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserObjectService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.UserObject parentEntity = ( net.ibizsys.psrt.srv.common.entity.UserObject)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.UserObject.FIELD_USEROBJECTID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_UserObject(et,parentEntity );
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
    * 填充数据的父数据信息[用户组]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_UserGroup(UserGroupDetail et,net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {
        et.setUserGroupId(parentEntity.getUserGroupId());
        et.setUserGroupName(parentEntity.getUserGroupName());
    }

    /**
    * 填充数据的父数据信息[用户对象]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_UserObject(UserGroupDetail et,net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {
        et.setUserObjectId(parentEntity.getUserObjectId());
        et.setUserObjectName(parentEntity.getUserObjectName());
    }


    /**
    * 填充主键
     * @param et
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onFillEntityKeyValue(UserGroupDetail et,boolean bTempMode) throws Exception {
        StringBuilderEx sb  = new StringBuilderEx();
        //属性 UserGroupId - 用户组
        Object objUserGroupId = et.get(UserGroupDetail.FIELD_USERGROUPID);
        if(objUserGroupId==null)
            objUserGroupId = "__EMTPY__";
        sb.append("%1$s", objUserGroupId);
        //属性 UserObjectId - 用户对象
        sb.append("||");
        Object objUserObjectId = et.get(UserGroupDetail.FIELD_USEROBJECTID);
        if(objUserObjectId==null)
            objUserObjectId = "__EMTPY__";
        sb.append("%1$s", objUserObjectId);
        String strValue = sb.toString();
        et.set(this.getUserGroupDetailDEModel().getUniTagDEField().getName(),KeyValueHelper.genUniqueId(strValue));
        return true;
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(UserGroupDetail et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getUserGroupDetailName()==null) {
                et.setUserGroupDetailName((String)DefaultValueHelper.getValue(this.getWebContext(),"","成员名称",25));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :USERGROUP / 用户组
        onFillEntityFullInfo_UserGroup(et, bCreate);
        //关系类型 : DER1N ,主实体 :USEROBJECT / 用户对象
        onFillEntityFullInfo_UserObject(et, bCreate);
    }

    /**
    * 填充实体的数据信息 用户组
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_UserGroup(UserGroupDetail et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 用户对象
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_UserObject(UserGroupDetail et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(UserGroupDetail et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[用户组]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<UserGroupDetail> selectByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroupBase parentEntity) throws Exception {
        return selectByUserGroup( parentEntity,"");
    }
    /**
     * 通过关系[用户组]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<UserGroupDetail> selectByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroupBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(UserGroupDetail.FIELD_USERGROUPID, parentEntity.getUserGroupId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByUserGroupCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[用户组]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByUserGroupCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[用户对象]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<UserGroupDetail> selectByUserObject(net.ibizsys.psrt.srv.common.entity.UserObjectBase parentEntity) throws Exception {
        return selectByUserObject( parentEntity,"");
    }
    /**
     * 通过关系[用户对象]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<UserGroupDetail> selectByUserObject(net.ibizsys.psrt.srv.common.entity.UserObjectBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(UserGroupDetail.FIELD_USEROBJECTID, parentEntity.getUserObjectId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByUserObjectCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[用户对象]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByUserObjectCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[用户组]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {
        java.util.ArrayList<UserGroupDetail> list =  this.selectByUserGroup(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERGROUP");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID","" ,parentDEModel.getName(),"USERGROUPDETAIL",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[用户组]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {
        java.util.ArrayList<UserGroupDetail> list =  this.selectByUserGroup(parentEntity);
        for(UserGroupDetail item:list) {
            UserGroupDetail item2 = (UserGroupDetail)getDEModel().createEntity();
            item2.setUserGroupDetailId(item.getUserGroupDetailId());
            item2.setUserGroupId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[用户组]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByUserGroup(parentEntity2);
                internalRemoveByUserGroup(parentEntity2);
                onAfterRemoveByUserGroup(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[用户组]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[用户组]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {
        java.util.ArrayList<UserGroupDetail> removeList = selectByUserGroup(parentEntity);
        onBeforeRemoveByUserGroup(parentEntity,removeList );

        // 执行删除
        for (UserGroupDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByUserGroup(parentEntity,removeList );
    }

    /**
     * 通过关系[用户组]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity) throws Exception {

    }

    /**
     * 通过关系[用户组]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity,java.util.ArrayList<UserGroupDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[用户组]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByUserGroup(net.ibizsys.psrt.srv.common.entity.UserGroup parentEntity,java.util.ArrayList<UserGroupDetail> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[用户对象]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {
    }


    /**
     * 通过关系[用户对象]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {
        java.util.ArrayList<UserGroupDetail> list =  this.selectByUserObject(parentEntity);
        for(UserGroupDetail item:list) {
            UserGroupDetail item2 = (UserGroupDetail)getDEModel().createEntity();
            item2.setUserGroupDetailId(item.getUserGroupDetailId());
            item2.setUserObjectId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[用户对象]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.UserObject parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByUserObject(parentEntity2);
                internalRemoveByUserObject(parentEntity2);
                onAfterRemoveByUserObject(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[用户对象]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[用户对象]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {
        java.util.ArrayList<UserGroupDetail> removeList = selectByUserObject(parentEntity);
        onBeforeRemoveByUserObject(parentEntity,removeList );

        // 执行删除
        for (UserGroupDetail item : removeList ) {
            remove(item );
        }
        onAfterRemoveByUserObject(parentEntity,removeList );
    }

    /**
     * 通过关系[用户对象]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity) throws Exception {

    }

    /**
     * 通过关系[用户对象]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity,java.util.ArrayList<UserGroupDetail> removeList) throws Exception {

    }

    /**
     * 通过关系[用户对象]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByUserObject(net.ibizsys.psrt.srv.common.entity.UserObject parentEntity,java.util.ArrayList<UserGroupDetail> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(UserGroupDetail et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(UserGroupDetail et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getUserGroupId()!=null) {
            IEntity entity = cloneSession.getEntity("USERGROUP",et.getUserGroupId());
            if(entity !=null) {
                onFillParentInfo_UserGroup(et,(net.ibizsys.psrt.srv.common.entity.UserGroup) entity);
            }
        }
        if(et.getUserObjectId()!=null) {
            IEntity entity = cloneSession.getEntity("USEROBJECT",et.getUserObjectId());
            if(entity !=null) {
                onFillParentInfo_UserObject(et,(net.ibizsys.psrt.srv.common.entity.UserObject) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(UserGroupDetail et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,UserGroupDetail  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        //检查属性 用户数据
        entityFieldError = onCheckField_UserData( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户数据2
        entityFieldError = onCheckField_UserData2( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户组成员标识
        entityFieldError = onCheckField_UserGroupDetailId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户组成员名称
        entityFieldError = onCheckField_UserGroupDetailName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户组
        entityFieldError = onCheckField_UserGroupId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户对象
        entityFieldError = onCheckField_UserObjectId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode,et,  bCreate,bTempMode,entityError);
    }


    /**
     * 获取属性[UserData]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserData(boolean bBaseMode,UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserDataDirty()) {
            return null;
        }

        String value = et.getUserData();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserData_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERDATA);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserData2]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserData2(boolean bBaseMode,UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserData2Dirty()) {
            return null;
        }

        String value = et.getUserData2();
        if(bBaseMode) {
            if(bCreate) {
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserData2_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERDATA2);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserGroupDetailId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserGroupDetailId(boolean bBaseMode,UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserGroupDetailIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserGroupDetailId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPDETAILID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserGroupDetailId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPDETAILID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserGroupDetailName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserGroupDetailName(boolean bBaseMode,UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserGroupDetailNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserGroupDetailName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPDETAILNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserGroupDetailName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPDETAILNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserGroupId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserGroupId(boolean bBaseMode,UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserGroupIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserGroupId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserGroupId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USERGROUPID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserObjectId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserObjectId(boolean bBaseMode,UserGroupDetail et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserObjectIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USEROBJECTID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserObjectId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserGroupDetail.FIELD_USEROBJECTID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserObjectId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserGroupDetail.FIELD_USEROBJECTID);
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
    protected void onSyncEntity(UserGroupDetail et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(UserGroupDetail et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(UserGroupDetail et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        IEntity userGroup =et.getUserGroup();
        if(userGroup!=null) {
            if(userGroup.contains(strField)) {
                return userGroup.get(strField);
            }
        }
        IEntity userObject =et.getUserObject();
        if(userObject!=null) {
            if(userObject.contains(strField)) {
                return userObject.get(strField);
            }
        }
        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USERDATA,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USERDATA2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserData2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USERGROUPDETAILID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserGroupDetailId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USERGROUPDETAILNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserGroupDetailName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USERGROUPID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserGroupId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USERGROUPNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserGroupName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USEROBJECTID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserObjectId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserGroupDetail.FIELD_USEROBJECTNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserObjectName_Default(et,bCreate,bTempMode);

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
     * 判断值规则[用户数据][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserData_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATA", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户数据2][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserData2_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERDATA2", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户组成员标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserGroupDetailId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERGROUPDETAILID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户组成员名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserGroupDetailName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERGROUPDETAILNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected String onTestValueRule_UserGroupId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERGROUPID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
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
    protected String onTestValueRule_UserGroupName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERGROUPNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户对象][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserObjectId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USEROBJECTID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户对象][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserObjectName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USEROBJECTNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserGroupDetail et) throws Exception {
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
    protected void onUpdateParent(UserGroupDetail et)throws Exception {
        super.onUpdateParent(et);
    }


}