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

import net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFDEModel;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
/**
 * 实体[DSDynaWF] DAO对象基类
 */
public abstract class DSDynaWFDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<DSDynaWF> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public DSDynaWFDAOBase() {
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
        return "net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFDAO";
    }

    private DSDynaWFDEModel dSDynaWFDEModel;

    /**
    * 获取实体[DSDynaWF]模型对象
    * @return
    */
    public  DSDynaWFDEModel getDSDynaWFDEModel() {
        if(this.dSDynaWFDEModel==null) {
            try {
                this.dSDynaWFDEModel = (DSDynaWFDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFDEModel");
            } catch(Exception ex) {
            }
        }
        return this.dSDynaWFDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getDSDynaWFDEModel();
    }



}