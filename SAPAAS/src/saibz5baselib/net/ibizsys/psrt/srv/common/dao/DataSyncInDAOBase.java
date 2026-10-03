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

import net.ibizsys.psrt.srv.common.demodel.DataSyncInDEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
/**
 * 实体[DataSyncIn] DAO对象基类
 */
public abstract class DataSyncInDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DataSyncIn> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public DataSyncInDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.DataSyncInDAO";
    }

    private DataSyncInDEModel dataSyncInDEModel;

    /**
    * 获取实体[DataSyncIn]模型对象
    * @return
    */
    public  DataSyncInDEModel getDataSyncInDEModel() {
        if(this.dataSyncInDEModel==null) {
            try {
                this.dataSyncInDEModel = (DataSyncInDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncInDEModel");
            } catch(Exception ex) {
            }
        }
        return this.dataSyncInDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDataSyncInDEModel();
    }



}