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

import net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEFields;
/**
 * 实体[UserRoleDEFields] DAO对象基类
 */
public abstract class UserRoleDEFieldsDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<UserRoleDEFields> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public UserRoleDEFieldsDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO";
    }

    private UserRoleDEFieldsDEModel userRoleDEFieldsDEModel;

    /**
    * 获取实体[UserRoleDEFields]模型对象
    * @return
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

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getUserRoleDEFieldsDEModel();
    }



}