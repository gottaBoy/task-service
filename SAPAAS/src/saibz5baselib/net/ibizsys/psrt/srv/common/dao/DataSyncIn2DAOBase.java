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

import net.ibizsys.psrt.srv.common.demodel.DataSyncIn2DEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn2;
/**
 * 实体[DataSyncIn2] DAO对象基类
 */
public abstract class DataSyncIn2DAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DataSyncIn2> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public DataSyncIn2DAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.DataSyncIn2DAO";
    }

    private DataSyncIn2DEModel dataSyncIn2DEModel;

    /**
    * 获取实体[DataSyncIn2]模型对象
    * @return
    */
    public  DataSyncIn2DEModel getDataSyncIn2DEModel() {
        if(this.dataSyncIn2DEModel==null) {
            try {
                this.dataSyncIn2DEModel = (DataSyncIn2DEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncIn2DEModel");
            } catch(Exception ex) {
            }
        }
        return this.dataSyncIn2DEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDataSyncIn2DEModel();
    }



}