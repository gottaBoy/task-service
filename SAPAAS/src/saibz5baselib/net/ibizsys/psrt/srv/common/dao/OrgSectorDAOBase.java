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

import net.ibizsys.psrt.srv.common.demodel.OrgSectorDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
/**
 * 实体[OrgSector] DAO对象基类
 */
public abstract class OrgSectorDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<OrgSector> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_CURCHILD = "CurChild";
    public static final String DATAQUERY_CURORG = "CurOrg";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ORGROOT = "OrgRoot";
    public static final String DATAQUERY_USERORG = "UserOrg";
    public static final String DATAQUERY_USERORGSECTOR = "UserOrgSector";

    public OrgSectorDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.OrgSectorDAO";
    }

    private OrgSectorDEModel orgSectorDEModel;

    /**
    * 获取实体[OrgSector]模型对象
    * @return
    */
    public  OrgSectorDEModel getOrgSectorDEModel() {
        if(this.orgSectorDEModel==null) {
            try {
                this.orgSectorDEModel = (OrgSectorDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgSectorDEModel");
            } catch(Exception ex) {
            }
        }
        return this.orgSectorDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getOrgSectorDEModel();
    }



}