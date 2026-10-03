/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.dao;

import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.core.IDEDBCallContext;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.entity.IEntity;
import javax.annotation.PostConstruct;

import net.ibizsys.psrt.srv.common.demodel.UserGroupDEModel;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.dao.UserObjectDAO;
import net.ibizsys.psrt.srv.common.entity.UserObject;
/**
 * 实体[UserGroup] DAO对象基类
 */
public abstract class UserGroupDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<UserGroup> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public UserGroupDAOBase() {
        super();

    }

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(getDAOId(), this);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDAOId()
     */
    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.UserGroupDAO";
    }

    private UserGroupDEModel userGroupDEModel;

    /**
    * 获取实体[UserGroup]模型对象
    * @return
    */
    public  UserGroupDEModel getUserGroupDEModel() {
        if(this.userGroupDEModel==null) {
            try {
                this.userGroupDEModel = (UserGroupDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserGroupDEModel");
            } catch(Exception ex) {
            }
        }
        return this.userGroupDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getUserGroupDEModel();
    }


    private UserObjectDAO userObjectDAO;

    /* (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getInheritDEDAO()
     */
    @Override
    protected  IDAO  getInheritDEDAO() {
        if(this.userObjectDAO==null) {
            try {
                this.userObjectDAO= (UserObjectDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.UserObjectDAO",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.userObjectDAO;
    }

    /**
     * 填充继承实体数据信息
     * @param et
     * @throws Exception
     */
    @Override
    protected void fillInheritEntity(UserGroup et)throws Exception {
        super.fillInheritEntity( et);

        UserObject userObject =  (UserObject)et;
        userObject.setUserObjectId(et.getUserGroupId());
        if(et.isUserGroupNameDirty())
            userObject.setUserObjectName(et.getUserGroupName());
        userObject.set(UserObject.FIELD_USEROBJECTTYPE,"USERGROUP");
    }


}