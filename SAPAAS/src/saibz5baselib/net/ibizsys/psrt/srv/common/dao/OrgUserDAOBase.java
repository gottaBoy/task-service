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

import net.ibizsys.psrt.srv.common.demodel.OrgUserDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
/**
 * 实体[OrgUser] DAO对象基类
 */
public abstract class OrgUserDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<OrgUser> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_CURORG = "CurOrg";
    public static final String DATAQUERY_CURORGSECTOR = "CurOrgSector";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_USERORG = "UserOrg";
    public static final String DATAQUERY_USERORGSECTOR = "UserOrgSector";

    public OrgUserDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.OrgUserDAO";
    }

    private OrgUserDEModel orgUserDEModel;

    /**
    * 获取实体[OrgUser]模型对象
    * @return
    */
    public  OrgUserDEModel getOrgUserDEModel() {
        if(this.orgUserDEModel==null) {
            try {
                this.orgUserDEModel = (OrgUserDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgUserDEModel");
            } catch(Exception ex) {
            }
        }
        return this.orgUserDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getOrgUserDEModel();
    }



}