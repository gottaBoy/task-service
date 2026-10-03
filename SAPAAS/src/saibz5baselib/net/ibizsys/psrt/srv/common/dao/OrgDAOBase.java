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

import net.ibizsys.psrt.srv.common.demodel.OrgDEModel;
import net.ibizsys.psrt.srv.common.entity.Org;
/**
 * 实体[Org] DAO对象基类
 */
public abstract class OrgDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<Org> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_ALLROOT = "AllRoot";
    public static final String DATAQUERY_CURCAT = "CurCat";
    public static final String DATAQUERY_CURCHILD = "CurChild";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public OrgDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.OrgDAO";
    }

    private OrgDEModel orgDEModel;

    /**
    * 获取实体[Org]模型对象
    * @return
    */
    public  OrgDEModel getOrgDEModel() {
        if(this.orgDEModel==null) {
            try {
                this.orgDEModel = (OrgDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgDEModel");
            } catch(Exception ex) {
            }
        }
        return this.orgDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getOrgDEModel();
    }



}