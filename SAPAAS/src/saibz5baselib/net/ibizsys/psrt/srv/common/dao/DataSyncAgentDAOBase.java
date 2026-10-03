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

import net.ibizsys.psrt.srv.common.demodel.DataSyncAgentDEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;
/**
 * 实体[DataSyncAgent] DAO对象基类
 */
public abstract class DataSyncAgentDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DataSyncAgent> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public DataSyncAgentDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.DataSyncAgentDAO";
    }

    private DataSyncAgentDEModel dataSyncAgentDEModel;

    /**
    * 获取实体[DataSyncAgent]模型对象
    * @return
    */
    public  DataSyncAgentDEModel getDataSyncAgentDEModel() {
        if(this.dataSyncAgentDEModel==null) {
            try {
                this.dataSyncAgentDEModel = (DataSyncAgentDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncAgentDEModel");
            } catch(Exception ex) {
            }
        }
        return this.dataSyncAgentDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDataSyncAgentDEModel();
    }



}