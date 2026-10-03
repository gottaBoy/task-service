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

import net.ibizsys.psrt.srv.common.demodel.DALogDEModel;
import net.ibizsys.psrt.srv.common.entity.DALog;
/**
 * 实体[DALog] DAO对象基类
 */
public abstract class DALogDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DALog> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public DALogDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.DALogDAO";
    }

    private DALogDEModel dALogDEModel;

    /**
    * 获取实体[DALog]模型对象
    * @return
    */
    public  DALogDEModel getDALogDEModel() {
        if(this.dALogDEModel==null) {
            try {
                this.dALogDEModel = (DALogDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DALogDEModel");
            } catch(Exception ex) {
            }
        }
        return this.dALogDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDALogDEModel();
    }



}