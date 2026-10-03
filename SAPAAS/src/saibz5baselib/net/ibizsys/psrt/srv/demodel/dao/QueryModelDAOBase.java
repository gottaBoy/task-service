/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.dao;

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

import net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel;
import net.ibizsys.psrt.srv.demodel.entity.QueryModel;
/**
 * 实体[QueryModel] DAO对象基类
 */
public abstract class QueryModelDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<QueryModel> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public QueryModelDAOBase() {
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
        return "net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO";
    }

    private QueryModelDEModel queryModelDEModel;

    /**
    * 获取实体[QueryModel]模型对象
    * @return
    */
    public  QueryModelDEModel getQueryModelDEModel() {
        if(this.queryModelDEModel==null) {
            try {
                this.queryModelDEModel = (QueryModelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel");
            } catch(Exception ex) {
            }
        }
        return this.queryModelDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getQueryModelDEModel();
    }



}