/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.dao;

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

import net.ibizsys.psrt.srv.wf.demodel.WFSystemUserDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFSystemUser;
/**
 * 实体[WFSystemUser] DAO对象基类
 */
public abstract class WFSystemUserDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<WFSystemUser> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public WFSystemUserDAOBase() {
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
        return "net.ibizsys.psrt.srv.wf.dao.WFSystemUserDAO";
    }

    private WFSystemUserDEModel wFSystemUserDEModel;

    /**
    * 获取实体[WFSystemUser]模型对象
    * @return
    */
    public  WFSystemUserDEModel getWFSystemUserDEModel() {
        if(this.wFSystemUserDEModel==null) {
            try {
                this.wFSystemUserDEModel = (WFSystemUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFSystemUserDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFSystemUserDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFSystemUserDEModel();
    }



}