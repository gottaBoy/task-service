/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.sf.json.JSONObject;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IInheritDEServiceProxy;

import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.dao.UserObjectDAO;

import net.ibizsys.psrt.srv.common.service.UserGroupService;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.service.UserService;
import net.ibizsys.psrt.srv.common.entity.User;
/**
 * 继承实体[USEROBJECT]服务操作对象基类
 */
public abstract class UserObjectServiceProxyBase extends UserObjectService<UserObject> implements IInheritDEServiceProxy<UserObject> {

    private static final Log log = LogFactory.getLog(UserObjectServiceProxyBase.class);
    public UserObjectServiceProxyBase() {
        super();

    }
    /**
     * Spring注册后执行构造处理
     * @throws Exception
     */
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(getServiceId(), this);
        ServiceGlobal.registerService(getServiceId()+"Proxy", this);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#getServiceId()
     */
    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.UserObjectService";
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#remove(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    public void remove(UserObject entity) throws Exception {
        if(entity.getUserObjectType()==null) {
            //重新获取
            this.get(entity);
        }

        if(StringHelper.compare(entity.getUserObjectType(),"USERGROUP",true)==0) {
            UserGroupService realService= (UserGroupService)ServiceGlobal.getService(UserGroupService.class,this.getSessionFactory());
            UserGroup realEntity = new  UserGroup();
            realEntity.setUserGroupId(entity.getUserObjectId());
            realService.remove(realEntity );
            return;
        }
        if(StringHelper.compare(entity.getUserObjectType(),"USER",true)==0) {
            UserService realService= (UserService)ServiceGlobal.getService(UserService.class,this.getSessionFactory());
            User realEntity = new  User();
            realEntity.setUserId(entity.getUserObjectId());
            realService.remove(realEntity );
            return;
        }

        throw new Exception(StringHelper.format("无法识别的继承类型[%1$s]",entity.getUserObjectType()));
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IInheritDEServiceProxy#getReal(net.ibizsys.paas.entity.IEntity, boolean)
     */
    @Override
    public UserObject getReal(UserObject entity,boolean bTryMode) throws Exception {
        if(entity.getUserObjectType()==null) {
            //重新获取
            if(!this.get(entity,bTryMode))
                return null;
        }

        if(StringHelper.compare(entity.getUserObjectType(),"USERGROUP",true)==0) {
            UserGroupService realService= (UserGroupService)ServiceGlobal.getService(UserGroupService.class,this.getSessionFactory());
            UserGroup realEntity = new  UserGroup();
            realEntity.setUserGroupId(entity.getUserObjectId());
            if(! realService.get(realEntity,bTryMode ))
                return null;
            return realEntity;
        }
        if(StringHelper.compare(entity.getUserObjectType(),"USER",true)==0) {
            UserService realService= (UserService)ServiceGlobal.getService(UserService.class,this.getSessionFactory());
            User realEntity = new  User();
            realEntity.setUserId(entity.getUserObjectId());
            if(! realService.get(realEntity,bTryMode ))
                return null;
            return realEntity;
        }

        throw new Exception(StringHelper.format("无法识别的继承类型[%1$s]",entity.getUserObjectType()));
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.IInheritDEServiceProxy#getRealService(net.ibizsys.paas.entity.IEntity)
     */
    @Override
    public IService getRealService(UserObject entity) throws Exception {
        if(entity.getUserObjectType()==null) {
            //重新获取
            this.get(entity);
        }

        if(StringHelper.compare(entity.getUserObjectType(),"USERGROUP",true)==0) {
            UserGroupService realService= (UserGroupService)ServiceGlobal.getService(UserGroupService.class,this.getSessionFactory());
            return realService;
        }
        if(StringHelper.compare(entity.getUserObjectType(),"USER",true)==0) {
            UserService realService= (UserService)ServiceGlobal.getService(UserService.class,this.getSessionFactory());
            return realService;
        }

        throw new Exception(StringHelper.format("无法识别的继承类型[%1$s]",entity.getUserObjectType()));
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.service.ServiceBase#onExportCurModel(net.ibizsys.paas.entity.IEntity, java.util.ArrayList)
     */
    @Override
    protected void onExportCurModel(UserObject entity,  ArrayList<JSONObject> list)throws Exception {
        if(StringHelper.compare(entity.getUserObjectType(),"USERGROUP",true)==0) {
            UserGroupService realService= (UserGroupService)ServiceGlobal.getService(UserGroupService.class,this.getSessionFactory());
            UserGroup realEntity = new  UserGroup();
            realEntity.setUserGroupId(entity.getUserObjectId());
            realService.exportModel(realEntity,list );
            return;
        }
        if(StringHelper.compare(entity.getUserObjectType(),"USER",true)==0) {
            UserService realService= (UserService)ServiceGlobal.getService(UserService.class,this.getSessionFactory());
            User realEntity = new  User();
            realEntity.setUserId(entity.getUserObjectId());
            realService.exportModel(realEntity,list );
            return;
        }
        throw new Exception(StringHelper.format("无法识别的继承类型[%1$s]",entity.getUserObjectType()));
    }

}