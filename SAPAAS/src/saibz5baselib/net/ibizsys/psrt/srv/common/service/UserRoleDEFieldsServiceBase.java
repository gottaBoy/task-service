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



import net.ibizsys.psrt.srv.common.entity.UserRoleDEFields;
import net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel;

/**
 * 实体[UserRoleDEFields] 服务对象基类
 */
public abstract class UserRoleDEFieldsServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<UserRoleDEFields> {
    private static final Log log = LogFactory.getLog(UserRoleDEFieldsServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public UserRoleDEFieldsServiceBase () {
        super();

    }

    /**
     * 获取实体[UserRoleDEFields]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static UserRoleDEFieldsService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[UserRoleDEFields]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static UserRoleDEFieldsService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserRoleDEFieldsService)ServiceGlobal.getService(UserRoleDEFieldsService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsService";
    }

    private UserRoleDEFieldsDEModel userRoleDEFieldsDEModel;
    /**
     * 获取实体[UserRoleDEFields]模型对象
     */
    public  UserRoleDEFieldsDEModel getUserRoleDEFieldsDEModel() {
        if(this.userRoleDEFieldsDEModel==null) {
            try {
                this.userRoleDEFieldsDEModel = (UserRoleDEFieldsDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel");
            } catch(Exception ex) {
            }
        }
        return this.userRoleDEFieldsDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getUserRoleDEFieldsDEModel();
    }


    private UserRoleDEFieldsDAO userRoleDEFieldsDAO;

    /**
     * 获取实体[UserRoleDEFields]数据操作对象
     */
    public  UserRoleDEFieldsDAO getUserRoleDEFieldsDAO() {
        if(this.userRoleDEFieldsDAO==null) {
            try {
                this.userRoleDEFieldsDAO= (UserRoleDEFieldsDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.userRoleDEFieldsDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getUserRoleDEFieldsDAO();
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
    protected void onFillParentInfo(UserRoleDEFields et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :USERROLEDEFIELD / 用户角色实体属性访问
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity = ( net.ibizsys.psrt.srv.common.entity.UserRoleDEField)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.UserRoleDEField.FIELD_USERROLEDEFIELDID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_UserRoleDEField(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :USERROLE / 用户角色
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.UserRole parentEntity = ( net.ibizsys.psrt.srv.common.entity.UserRole)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.UserRole.FIELD_USERROLEID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_UserRole(et,parentEntity );
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
    * 填充数据的父数据信息[用户角色实体属性访问]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_UserRoleDEField(UserRoleDEFields et,net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {
        et.setUserRoleDEFieldId(parentEntity.getUserRoleDEFieldId());
        et.setUserRoleDEFieldName(parentEntity.getUserRoleDEFieldName());
    }

    /**
    * 填充数据的父数据信息[用户角色]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_UserRole(UserRoleDEFields et,net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
        et.setUserRoleId(parentEntity.getUserRoleId());
        et.setUserRoleName(parentEntity.getUserRoleName());
    }


    /**
    * 填充主键
     * @param et
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onFillEntityKeyValue(UserRoleDEFields et,boolean bTempMode) throws Exception {
        StringBuilderEx sb  = new StringBuilderEx();
        //属性 UserRoleId - 用户角色
        Object objUserRoleId = et.get(UserRoleDEFields.FIELD_USERROLEID);
        if(objUserRoleId==null)
            objUserRoleId = "__EMTPY__";
        sb.append("%1$s", objUserRoleId);
        //属性 UserRoleDEFieldId - 实体属性访问能力
        sb.append("||");
        Object objUserRoleDEFieldId = et.get(UserRoleDEFields.FIELD_USERROLEDEFIELDID);
        if(objUserRoleDEFieldId==null)
            objUserRoleDEFieldId = "__EMTPY__";
        sb.append("%1$s", objUserRoleDEFieldId);
        String strValue = sb.toString();
        et.set(this.getUserRoleDEFieldsDEModel().getUniTagDEField().getName(),KeyValueHelper.genUniqueId(strValue));
        return true;
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(UserRoleDEFields et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :USERROLEDEFIELD / 用户角色实体属性访问
        onFillEntityFullInfo_UserRoleDEField(et, bCreate);
        //关系类型 : DER1N ,主实体 :USERROLE / 用户角色
        onFillEntityFullInfo_UserRole(et, bCreate);
    }

    /**
    * 填充实体的数据信息 用户角色实体属性访问
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_UserRoleDEField(UserRoleDEFields et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 用户角色
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_UserRole(UserRoleDEFields et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(UserRoleDEFields et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[用户角色实体属性访问]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDEFields> selectByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEFieldBase parentEntity) throws Exception {
        return selectByUserRoleDEField( parentEntity,"");
    }
    /**
     * 通过关系[用户角色实体属性访问]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDEFields> selectByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEFieldBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(UserRoleDEFields.FIELD_USERROLEDEFIELDID, parentEntity.getUserRoleDEFieldId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByUserRoleDEFieldCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[用户角色实体属性访问]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByUserRoleDEFieldCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[用户角色]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDEFields> selectByUserRole(net.ibizsys.psrt.srv.common.entity.UserRoleBase parentEntity) throws Exception {
        return selectByUserRole( parentEntity,"");
    }
    /**
     * 通过关系[用户角色]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDEFields> selectByUserRole(net.ibizsys.psrt.srv.common.entity.UserRoleBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(UserRoleDEFields.FIELD_USERROLEID, parentEntity.getUserRoleId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByUserRoleCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[用户角色]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByUserRoleCond(SelectCond selectCond) throws Exception {

    }




    /**
     * 判断是否能够通过关系[用户角色实体属性访问]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDEFields> list =  this.selectByUserRoleDEField(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERROLEDEFIELD");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID","" ,parentDEModel.getName(),"USERROLEDEFIELDS",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[用户角色实体属性访问]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDEFields> list =  this.selectByUserRoleDEField(parentEntity);
        for(UserRoleDEFields item:list) {
            UserRoleDEFields item2 = (UserRoleDEFields)getDEModel().createEntity();
            item2.setUserRoleDEFieldsId(item.getUserRoleDEFieldsId());
            item2.setUserRoleDEFieldId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[用户角色实体属性访问]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByUserRoleDEField(parentEntity2);
                internalRemoveByUserRoleDEField(parentEntity2);
                onAfterRemoveByUserRoleDEField(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[用户角色实体属性访问]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[用户角色实体属性访问]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDEFields> removeList = selectByUserRoleDEField(parentEntity);
        onBeforeRemoveByUserRoleDEField(parentEntity,removeList );

        // 执行删除
        for (UserRoleDEFields item : removeList ) {
            remove(item );
        }
        onAfterRemoveByUserRoleDEField(parentEntity,removeList );
    }

    /**
     * 通过关系[用户角色实体属性访问]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity) throws Exception {

    }

    /**
     * 通过关系[用户角色实体属性访问]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity,java.util.ArrayList<UserRoleDEFields> removeList) throws Exception {

    }

    /**
     * 通过关系[用户角色实体属性访问]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByUserRoleDEField(net.ibizsys.psrt.srv.common.entity.UserRoleDEField parentEntity,java.util.ArrayList<UserRoleDEFields> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[用户角色]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDEFields> list =  this.selectByUserRole(parentEntity);
        if(list.size()>0) {
            IDataEntityModel parentDEModel = this.getDEModel().getSystemRuntime().getDataEntityModel("USERROLE");
            parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
            throw new Exception(getRemoveRejectMsg("DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID","" ,parentDEModel.getName(),"USERROLEDEFIELDS",parentDEModel.getDataInfo(parentEntity)));
        }
    }


    /**
     * 通过关系[用户角色]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDEFields> list =  this.selectByUserRole(parentEntity);
        for(UserRoleDEFields item:list) {
            UserRoleDEFields item2 = (UserRoleDEFields)getDEModel().createEntity();
            item2.setUserRoleDEFieldsId(item.getUserRoleDEFieldsId());
            item2.setUserRoleId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[用户角色]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.UserRole parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByUserRole(parentEntity2);
                internalRemoveByUserRole(parentEntity2);
                onAfterRemoveByUserRole(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[用户角色]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[用户角色]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDEFields> removeList = selectByUserRole(parentEntity);
        onBeforeRemoveByUserRole(parentEntity,removeList );

        // 执行删除
        for (UserRoleDEFields item : removeList ) {
            remove(item );
        }
        onAfterRemoveByUserRole(parentEntity,removeList );
    }

    /**
     * 通过关系[用户角色]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {

    }

    /**
     * 通过关系[用户角色]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity,java.util.ArrayList<UserRoleDEFields> removeList) throws Exception {

    }

    /**
     * 通过关系[用户角色]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity,java.util.ArrayList<UserRoleDEFields> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(UserRoleDEFields et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(UserRoleDEFields et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getUserRoleDEFieldId()!=null) {
            IEntity entity = cloneSession.getEntity("USERROLEDEFIELD",et.getUserRoleDEFieldId());
            if(entity !=null) {
                onFillParentInfo_UserRoleDEField(et,(net.ibizsys.psrt.srv.common.entity.UserRoleDEField) entity);
            }
        }
        if(et.getUserRoleId()!=null) {
            IEntity entity = cloneSession.getEntity("USERROLE",et.getUserRoleId());
            if(entity !=null) {
                onFillParentInfo_UserRole(et,(net.ibizsys.psrt.srv.common.entity.UserRole) entity);
            }
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onRemoveEntityUncopyValues(UserRoleDEFields et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,UserRoleDEFields  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
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
        //检查属性 实体属性访问能力
        entityFieldError = onCheckField_UserRoleDEFieldId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户角色相关实体属性访问控制标识
        entityFieldError = onCheckField_UserRoleDEFieldsId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 实体属性访问控制
        entityFieldError = onCheckField_UserRoleDEFieldsName( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户角色
        entityFieldError = onCheckField_UserRoleId( bBaseMode,  et,  bCreate,  bTempMode);
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
    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_RESERVER);
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
    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_RESERVER2);
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
    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_RESERVER3);
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
    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_RESERVER4);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleDEFieldId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleDEFieldId(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleDEFieldIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleDEFieldId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleDEFieldId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleDEFieldsId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleDEFieldsId(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleDEFieldsIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDSID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleDEFieldsId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDSID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleDEFieldsId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDSID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleDEFieldsName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleDEFieldsName(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleDEFieldsNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDSNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleDEFieldsName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDSNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleDEFieldsName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEDEFIELDSNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleId(boolean bBaseMode,UserRoleDEFields et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDEFields.FIELD_USERROLEID);
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
    protected void onSyncEntity(UserRoleDEFields et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(UserRoleDEFields et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(UserRoleDEFields et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        IEntity userRoleDEField =et.getUserRoleDEField();
        if(userRoleDEField!=null) {
            if(userRoleDEField.contains(strField)) {
                return userRoleDEField.get(strField);
            }
        }
        IEntity userRole =et.getUserRole();
        if(userRole!=null) {
            if(userRole.contains(strField)) {
                return userRole.get(strField);
            }
        }
        return null;
    }



    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
     */
    @Override
    protected String onTestValueRule(String strDEFieldName,String strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_RESERVER,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_RESERVER2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_RESERVER3,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver3_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_RESERVER4,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver4_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_USERROLEDEFIELDID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDEFieldId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_USERROLEDEFIELDNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDEFieldName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_USERROLEDEFIELDSID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDEFieldsId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_USERROLEDEFIELDSNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDEFieldsName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_USERROLEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDEFields.FIELD_USERROLENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleName_Default(et,bCreate,bTempMode);

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
     * 判断值规则[实体属性访问能力][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDEFieldId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDEFIELDID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[实体属性控制][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDEFieldName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDEFIELDNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户角色相关实体属性访问控制标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDEFieldsId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDEFIELDSID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[实体属性访问控制][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDEFieldsName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDEFIELDSNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户角色][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户角色][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLENAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserRoleDEFields et) throws Exception {
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
    protected void onUpdateParent(UserRoleDEFields et)throws Exception {
        super.onUpdateParent(et);
    }


}