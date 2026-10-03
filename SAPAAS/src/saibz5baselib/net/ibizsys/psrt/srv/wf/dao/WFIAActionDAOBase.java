/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.dao;

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

import net.ibizsys.psrt.srv.wf.demodel.WFIAActionDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFIAAction;
/**
 * 实体[WFIAAction] DAO对象基类
 */
public abstract class WFIAActionDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<WFIAAction> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public WFIAActionDAOBase() {
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
        return "net.ibizsys.psrt.srv.wf.dao.WFIAActionDAO";
    }

    private WFIAActionDEModel wFIAActionDEModel;

    /**
    * 获取实体[WFIAAction]模型对象
    * @return
    */
    public  WFIAActionDEModel getWFIAActionDEModel() {
        if(this.wFIAActionDEModel==null) {
            try {
                this.wFIAActionDEModel = (WFIAActionDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFIAActionDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFIAActionDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWFIAActionDEModel();
    }



}