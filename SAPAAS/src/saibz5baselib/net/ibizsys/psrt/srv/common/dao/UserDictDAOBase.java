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

import net.ibizsys.psrt.srv.common.demodel.UserDictDEModel;
import net.ibizsys.psrt.srv.common.entity.UserDict;
/**
 * 实体[UserDict] DAO对象基类
 */
public abstract class UserDictDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<UserDict> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public UserDictDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.UserDictDAO";
    }

    private UserDictDEModel userDictDEModel;

    /**
    * 获取实体[UserDict]模型对象
    * @return
    */
    public  UserDictDEModel getUserDictDEModel() {
        if(this.userDictDEModel==null) {
            try {
                this.userDictDEModel = (UserDictDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserDictDEModel");
            } catch(Exception ex) {
            }
        }
        return this.userDictDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getUserDictDEModel();
    }



}