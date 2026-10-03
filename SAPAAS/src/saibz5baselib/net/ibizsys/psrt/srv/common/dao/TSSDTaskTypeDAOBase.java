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

import net.ibizsys.psrt.srv.common.demodel.TSSDTaskTypeDEModel;
import net.ibizsys.psrt.srv.common.entity.TSSDTaskType;
/**
 * 实体[TSSDTaskType] DAO对象基类
 */
public abstract class TSSDTaskTypeDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<TSSDTaskType> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public TSSDTaskTypeDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.TSSDTaskTypeDAO";
    }

    private TSSDTaskTypeDEModel tSSDTaskTypeDEModel;

    /**
    * 获取实体[TSSDTaskType]模型对象
    * @return
    */
    public  TSSDTaskTypeDEModel getTSSDTaskTypeDEModel() {
        if(this.tSSDTaskTypeDEModel==null) {
            try {
                this.tSSDTaskTypeDEModel = (TSSDTaskTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.TSSDTaskTypeDEModel");
            } catch(Exception ex) {
            }
        }
        return this.tSSDTaskTypeDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getTSSDTaskTypeDEModel();
    }



}