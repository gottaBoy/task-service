/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.dao;

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

import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
/**
 * 实体[DSDynaWFVer] DAO对象基类
 */
public abstract class DSDynaWFVerDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DSDynaWFVer> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW0 = "View0";

    public DSDynaWFVerDAOBase() {
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
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO";
    }

    private DSDynaWFVerDEModel dSDynaWFVerDEModel;

    /**
    * 获取实体[DSDynaWFVer]模型对象
    * @return
    */
    public  DSDynaWFVerDEModel getDSDynaWFVerDEModel() {
        if(this.dSDynaWFVerDEModel==null) {
            try {
                this.dSDynaWFVerDEModel = (DSDynaWFVerDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel");
            } catch(Exception ex) {
            }
        }
        return this.dSDynaWFVerDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDSDynaWFVerDEModel();
    }



}