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

import net.ibizsys.psrt.srv.common.demodel.OrgTypeDEModel;
import net.ibizsys.psrt.srv.common.entity.OrgType;
/**
 * 实体[OrgType] DAO对象基类
 */
public abstract class OrgTypeDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<OrgType> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public OrgTypeDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.OrgTypeDAO";
    }

    private OrgTypeDEModel orgTypeDEModel;

    /**
    * 获取实体[OrgType]模型对象
    * @return
    */
    public  OrgTypeDEModel getOrgTypeDEModel() {
        if(this.orgTypeDEModel==null) {
            try {
                this.orgTypeDEModel = (OrgTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgTypeDEModel");
            } catch(Exception ex) {
            }
        }
        return this.orgTypeDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getOrgTypeDEModel();
    }



}