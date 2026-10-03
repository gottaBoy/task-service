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

import net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel;
import net.ibizsys.psrt.srv.common.entity.CodeItem;
/**
 * 实体[CodeItem] DAO对象基类
 */
public abstract class CodeItemDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<CodeItem> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_CURCL = "CurCL";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public CodeItemDAOBase() {
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
        return "net.ibizsys.psrt.srv.common.dao.CodeItemDAO";
    }

    private CodeItemDEModel codeItemDEModel;

    /**
    * 获取实体[CodeItem]模型对象
    * @return
    */
    public  CodeItemDEModel getCodeItemDEModel() {
        if(this.codeItemDEModel==null) {
            try {
                this.codeItemDEModel = (CodeItemDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel");
            } catch(Exception ex) {
            }
        }
        return this.codeItemDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getCodeItemDEModel();
    }



}