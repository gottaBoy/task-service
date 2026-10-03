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



import net.ibizsys.psrt.srv.common.entity.UserRoleDatas;
import net.ibizsys.psrt.srv.common.dao.UserRoleDatasDAO;
import net.ibizsys.psrt.srv.common.demodel.UserRoleDatasDEModel;

/**
 * 实体[UserRoleDatas] 服务对象基类
 */
public abstract class UserRoleDatasServiceBase extends net.ibizsys.psrt.srv.PSRuntimeSysServiceBase<UserRoleDatas> {
    private static final Log log = LogFactory.getLog(UserRoleDatasServiceBase.class);
    /**
     * 实体数据集合[DEFAULT]标识
     */
    public final static String DATASET_DEFAULT = "DEFAULT";


    public UserRoleDatasServiceBase () {
        super();

    }

    /**
     * 获取实体[UserRoleDatas]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static UserRoleDatasService getInstance() throws Exception {
        return getInstance(null);
    }

    /**
     * 获取实体[UserRoleDatas]服务对象
     * @param sessionFactory
     * @return
     * @throws Exception
     */
    public static UserRoleDatasService getInstance(SessionFactory sessionFactory) throws Exception {
        return (UserRoleDatasService)ServiceGlobal.getService(UserRoleDatasService.class, sessionFactory);
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
        return "net.ibizsys.psrt.srv.common.service.UserRoleDatasService";
    }

    private UserRoleDatasDEModel userRoleDatasDEModel;
    /**
     * 获取实体[UserRoleDatas]模型对象
     */
    public  UserRoleDatasDEModel getUserRoleDatasDEModel() {
        if(this.userRoleDatasDEModel==null) {
            try {
                this.userRoleDatasDEModel = (UserRoleDatasDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleDatasDEModel");
            } catch(Exception ex) {
            }
        }
        return this.userRoleDatasDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getUserRoleDatasDEModel();
    }


    private UserRoleDatasDAO userRoleDatasDAO;

    /**
     * 获取实体[UserRoleDatas]数据操作对象
     */
    public  UserRoleDatasDAO getUserRoleDatasDAO() {
        if(this.userRoleDatasDAO==null) {
            try {
                this.userRoleDatasDAO= (UserRoleDatasDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserRoleDatasDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.userRoleDatasDAO;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IService#getDAO()
     */
    @Override
    public  IDAO getDAO() {
        return this.getUserRoleDatasDAO();
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
    protected void onFillParentInfo(UserRoleDatas et,String strParentType,String strTypeParam,String strParentKey) throws Exception {
        //关系类型 : DER1N ,主实体 :USERROLEDATA / 数据对象能力
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID", true)==0)) {
            IService iService= ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleDataService",this.getSessionFactory());
            net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity = ( net.ibizsys.psrt.srv.common.entity.UserRoleData)iService.getDEModel().createEntity();
            parentEntity.set(net.ibizsys.psrt.srv.common.entity.UserRoleData.FIELD_USERROLEDATAID,DataTypeHelper.parse(25,strParentKey));
            if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
                iService.getTemp(parentEntity);
            else
                iService.get(parentEntity);
            this.onFillParentInfo_UserRoleData(et,parentEntity );
            return;
        }
        //关系类型 : DER1N ,主实体 :USERROLE / 用户角色
        if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0)
                ||(StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0))
                && (StringHelper.compare(strTypeParam, "DER1N_USERROLEDATAS_USERROLE_USERROLEID", true)==0)) {
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
    * 填充数据的父数据信息[数据对象能力]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_UserRoleData(UserRoleDatas et,net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {
        et.setDEName(parentEntity.getDEName());
        et.setUserRoleDataId(parentEntity.getUserRoleDataId());
        et.setUserRoleDataName(parentEntity.getUserRoleDataName());
    }

    /**
    * 填充数据的父数据信息[用户角色]
    * @param et 当前数据对象
    * @param parentEntity 父数据对象
    * @throws Exception
    */
    protected void onFillParentInfo_UserRole(UserRoleDatas et,net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
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
    protected boolean onFillEntityKeyValue(UserRoleDatas et,boolean bTempMode) throws Exception {
        StringBuilderEx sb  = new StringBuilderEx();
        //属性 UserRoleId - 用户角色
        Object objUserRoleId = et.get(UserRoleDatas.FIELD_USERROLEID);
        if(objUserRoleId==null)
            objUserRoleId = "__EMTPY__";
        sb.append("%1$s", objUserRoleId);
        //属性 UserRoleDataId - 实体数据角色能力
        sb.append("||");
        Object objUserRoleDataId = et.get(UserRoleDatas.FIELD_USERROLEDATAID);
        if(objUserRoleDataId==null)
            objUserRoleDataId = "__EMTPY__";
        sb.append("%1$s", objUserRoleDataId);
        String strValue = sb.toString();
        et.set(this.getUserRoleDatasDEModel().getUniTagDEField().getName(),KeyValueHelper.genUniqueId(strValue));
        return true;
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onFillEntityFullInfo(UserRoleDatas et, boolean bCreate) throws Exception {
        //填充新建默认值
        if(bCreate) {
            if(et.getUserRoleDatasName()==null) {
                et.setUserRoleDatasName((String)DefaultValueHelper.getValue(this.getWebContext(),"","用户角色数据能力",25));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);

        //填充物理化外键相关属性
        //关系类型 : DER1N ,主实体 :USERROLEDATA / 数据对象能力
        onFillEntityFullInfo_UserRoleData(et, bCreate);
        //关系类型 : DER1N ,主实体 :USERROLE / 用户角色
        onFillEntityFullInfo_UserRole(et, bCreate);
    }

    /**
    * 填充实体的数据信息 数据对象能力
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_UserRoleData(UserRoleDatas et, boolean bCreate) throws Exception {
    }
    /**
    * 填充实体的数据信息 用户角色
    * @param et
    * @param bCreate 是否建立
    * @throws Exception
    */
    protected void onFillEntityFullInfo_UserRole(UserRoleDatas et, boolean bCreate) throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onWriteBackParent(UserRoleDatas et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }




    /**
     * 通过关系[数据对象能力]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDatas> selectByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleDataBase parentEntity) throws Exception {
        return selectByUserRoleData( parentEntity,"");
    }
    /**
     * 通过关系[数据对象能力]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDatas> selectByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleDataBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(UserRoleDatas.FIELD_USERROLEDATAID, parentEntity.getUserRoleDataId());
        selectCond.setOrderInfo(strOrderInfo);
        onFillSelectByUserRoleDataCond(selectCond);
        return this.select(selectCond);
    }

    /**
     * 填充关系[数据对象能力]父数据查询附加条件
     * @param selectCond 查询条件对象
     * @throws Exception
     */
    protected void onFillSelectByUserRoleDataCond(SelectCond selectCond) throws Exception {

    }

    /**
     * 通过关系[用户角色]父数据查询数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDatas> selectByUserRole(net.ibizsys.psrt.srv.common.entity.UserRoleBase parentEntity) throws Exception {
        return selectByUserRole( parentEntity,"");
    }
    /**
     * 通过关系[用户角色]父数据查询数据
     * @param parentEntity 父数据
     * @param strOrderInfo 排序信息
     * @throws Exception
     */
    public java.util.ArrayList<UserRoleDatas> selectByUserRole(net.ibizsys.psrt.srv.common.entity.UserRoleBase parentEntity,String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon(UserRoleDatas.FIELD_USERROLEID, parentEntity.getUserRoleId());
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
     * 判断是否能够通过关系[数据对象能力]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {
    }


    /**
     * 通过关系[数据对象能力]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDatas> list =  this.selectByUserRoleData(parentEntity);
        for(UserRoleDatas item:list) {
            UserRoleDatas item2 = (UserRoleDatas)getDEModel().createEntity();
            item2.setUserRoleDatasId(item.getUserRoleDatasId());
            item2.setUserRoleDataId(null);
            this.update(item2);
        }
    }


    /**
     * 通过关系[数据对象能力]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void removeByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {
        final net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                onBeforeRemoveByUserRoleData(parentEntity2);
                internalRemoveByUserRoleData(parentEntity2);
                onAfterRemoveByUserRoleData(parentEntity2);
            }
        });
    }

    /**
     * 通过关系[数据对象能力]删除数据之前调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onBeforeRemoveByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {

    }

    /**
    * 内部删除数据，通过关系[数据对象能力]
    * @param parentEntity 父数据
    * @throws Exception
    */
    protected void internalRemoveByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDatas> removeList = selectByUserRoleData(parentEntity);
        onBeforeRemoveByUserRoleData(parentEntity,removeList );

        // 执行删除
        for (UserRoleDatas item : removeList ) {
            remove(item );
        }
        onAfterRemoveByUserRoleData(parentEntity,removeList );
    }

    /**
     * 通过关系[数据对象能力]删除数据之后调用
     * @param parentEntity 父数据
     * @throws Exception
     */
    protected void onAfterRemoveByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity) throws Exception {

    }

    /**
     * 通过关系[数据对象能力]删除数据之前调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onBeforeRemoveByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity,java.util.ArrayList<UserRoleDatas> removeList) throws Exception {

    }

    /**
     * 通过关系[数据对象能力]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByUserRoleData(net.ibizsys.psrt.srv.common.entity.UserRoleData parentEntity,java.util.ArrayList<UserRoleDatas> removeList) throws Exception {

    }

    /**
     * 判断是否能够通过关系[用户角色]删除数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void testRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
    }


    /**
     * 通过关系[用户角色]重置数据
     * @param parentEntity 父数据
     * @throws Exception
     */
    public void resetUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity) throws Exception {
        java.util.ArrayList<UserRoleDatas> list =  this.selectByUserRole(parentEntity);
        for(UserRoleDatas item:list) {
            UserRoleDatas item2 = (UserRoleDatas)getDEModel().createEntity();
            item2.setUserRoleDatasId(item.getUserRoleDatasId());
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
        java.util.ArrayList<UserRoleDatas> removeList = selectByUserRole(parentEntity);
        onBeforeRemoveByUserRole(parentEntity,removeList );

        // 执行删除
        for (UserRoleDatas item : removeList ) {
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
    protected void onBeforeRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity,java.util.ArrayList<UserRoleDatas> removeList) throws Exception {

    }

    /**
     * 通过关系[用户角色]删除数据之后调用
     * @param parentEntity 父数据
     * @param removeList 要删除的数据清单
     * @throws Exception
     */
    protected void onAfterRemoveByUserRole(net.ibizsys.psrt.srv.common.entity.UserRole parentEntity,java.util.ArrayList<UserRoleDatas> removeList) throws Exception {

    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    protected void onBeforeRemove(UserRoleDatas et) throws Exception {
        super.onBeforeRemove(et);
    }





    /**
     * 替换父数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void replaceParentInfo(UserRoleDatas et,CloneSession cloneSession) throws Exception {
        super.replaceParentInfo(et, cloneSession);
        //循环所有的从关系，判断有误替换
        if(et.getUserRoleDataId()!=null) {
            IEntity entity = cloneSession.getEntity("USERROLEDATA",et.getUserRoleDataId());
            if(entity !=null) {
                onFillParentInfo_UserRoleData(et,(net.ibizsys.psrt.srv.common.entity.UserRoleData) entity);
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
    protected void onRemoveEntityUncopyValues(UserRoleDatas et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et,  bTempMode);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean, net.ibizsys.paas.entity.IEntity, boolean, boolean, net.ibizsys.paas.entity.EntityError)
     */
    @Override
    protected void onCheckEntity(boolean bBaseMode,UserRoleDatas  et, boolean bCreate, boolean bTempMode,EntityError entityError) throws Exception {
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
        //检查属性 实体数据角色能力
        entityFieldError = onCheckField_UserRoleDataId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户角色数据能力标识
        entityFieldError = onCheckField_UserRoleDatasId( bBaseMode,  et,  bCreate,  bTempMode);
        if(entityFieldError!=null) {
            entityError.register(entityFieldError);
        }
        //检查属性 用户角色数据能力名称
        entityFieldError = onCheckField_UserRoleDatasName( bBaseMode,  et,  bCreate,  bTempMode);
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
    protected EntityFieldError onCheckField_Reserver(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDatas.FIELD_RESERVER);
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
    protected EntityFieldError onCheckField_Reserver2(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDatas.FIELD_RESERVER2);
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
    protected EntityFieldError onCheckField_Reserver3(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDatas.FIELD_RESERVER3);
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
    protected EntityFieldError onCheckField_Reserver4(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
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
                entityFieldError.setFieldName(UserRoleDatas.FIELD_RESERVER4);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleDataId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleDataId(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleDataIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATAID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleDataId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATAID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleDataId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATAID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleDatasId]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleDatasId(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleDatasIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATASID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleDatasId();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATASID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleDatasId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATASID);
                entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        } else {
        }
        return null;
    }


    /**
     * 获取属性[UserRoleDatasName]值错误
     * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据
     * @param bTempMode 是否为临时数据模式
     * @throws Exception
     */
    protected EntityFieldError onCheckField_UserRoleDatasName(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleDatasNameDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATASNAME);
                entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                return entityFieldError;
            }
            return null;
        }

        String value = et.getUserRoleDatasName();
        if(bBaseMode) {
            if(bCreate) {
                if(StringHelper.isNullOrEmpty(value)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATASNAME);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleDatasName_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEDATASNAME);
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
    protected EntityFieldError onCheckField_UserRoleId(boolean bBaseMode,UserRoleDatas et, boolean bCreate, boolean bTempMode) throws Exception {
        //判断是否有值
        if(!et.isUserRoleIdDirty()) {
            if(bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEID);
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
                    entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEID);
                    entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
                    return entityFieldError;
                }
            }

            String strRuleInfo  = null;
            //检查值规则[默认规则]
            strRuleInfo =onTestValueRule_UserRoleId_Default( et,  bCreate,  bTempMode);
            if(!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName(UserRoleDatas.FIELD_USERROLEID);
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
    protected void onSyncEntity(UserRoleDatas et, boolean bRemove) throws Exception {
        super.onSyncEntity( et,  bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    protected void onSyncIndexEntities(UserRoleDatas et,boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et,bRemove);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity, java.lang.String, net.ibizsys.paas.service.IDataContextParam)
     */
    @Override
    public Object getDataContextValue(UserRoleDatas et,String strField,IDataContextParam iDataContextParam)throws Exception {
        Object objValue = null;
        if(iDataContextParam!=null) {
        }

        objValue = super.getDataContextValue(et,strField,iDataContextParam);
        if(objValue!=null)
            return objValue;

        IEntity userRoleData =et.getUserRoleData();
        if(userRoleData!=null) {
            if(userRoleData.contains(strField)) {
                return userRoleData.get(strField);
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
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_CREATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_CREATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_CreateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_DENAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_DEName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_RESERVER,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_RESERVER2,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver2_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_RESERVER3,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver3_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_RESERVER4,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_Reserver4_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_UPDATEDATE,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateDate_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_UPDATEMAN,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UpdateMan_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_USERROLEDATAID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDataId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_USERROLEDATANAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDataName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_USERROLEDATASID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDatasId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_USERROLEDATASNAME,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleDatasName_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_USERROLEID,true)==0)
                &&(StringHelper.compare(strRule,"DEFAULT",true)==0))
            return onTestValueRule_UserRoleId_Default(et,bCreate,bTempMode);
        if((StringHelper.compare(strDEFieldName,UserRoleDatas.FIELD_USERROLENAME,true)==0)
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
     * 判断值规则[数据对象][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_DEName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("DENAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
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
     * 判断值规则[实体数据角色能力][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDataId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDATAID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[实体数据能力][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDataName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDATANAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
                return null;
            return "内容长度必须小于等于[200]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户角色数据能力标识][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDatasId_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDATASID", et, bTempMode,null,false,100,true,"内容长度必须小于等于[100]",false)))
                return null;
            return "内容长度必须小于等于[100]";
        } catch(Exception ex) {
            return ex.getMessage();
        }
    }

    /**
     * 判断值规则[用户角色数据能力名称][默认规则]
     * @param et 当前数据对象
     * @param bCreate 是否为新建数据模式
     * @param bTempMode 是否为临时数据模式
     * @return
     * @throws Exception
     */
    protected String onTestValueRule_UserRoleDatasName_Default(IEntity et,boolean bCreate,boolean bTempMode) throws Exception {
        try {
            if((checkFieldStringLengthRule("USERROLEDATASNAME", et, bTempMode,null,false,200,true,"内容长度必须小于等于[200]",false)))
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
    protected boolean onMergeChild(String strChildType, String strTypeParam, UserRoleDatas et) throws Exception {
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
    protected void onUpdateParent(UserRoleDatas et)throws Exception {
        super.onUpdateParent(et);
    }


}