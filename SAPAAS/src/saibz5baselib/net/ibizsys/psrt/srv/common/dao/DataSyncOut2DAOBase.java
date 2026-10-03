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

import net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut2;
/**
 * 实体[DataSyncOut2] DAO对象基类
 */
public abstract class DataSyncOut2DAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DataSyncOut2> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public DataSyncOut2DAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.DataSyncOut2DAO";
    }

    private DataSyncOut2DEModel dataSyncOut2DEModel;

    /**
    * 获取实体[DataSyncOut2]模型对象
    * @return
    */
    public  DataSyncOut2DEModel getDataSyncOut2DEModel() {
        if(this.dataSyncOut2DEModel==null) {
            try {
                this.dataSyncOut2DEModel = (DataSyncOut2DEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel");
            } catch(Exception ex) {
            }
        }
        return this.dataSyncOut2DEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDataSyncOut2DEModel();
    }



}