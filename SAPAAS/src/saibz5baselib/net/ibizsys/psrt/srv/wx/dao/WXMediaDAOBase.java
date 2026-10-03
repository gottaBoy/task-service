/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.dao;

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

import net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXMedia;
/**
 * 实体[WXMedia] DAO对象基类
 */
public abstract class WXMediaDAOBase extends net.ibizsys.psrt.srv.PSRuntimeSysDAOBase<WXMedia> {

    private static final long serialVersionUID = -1L;

    public static final String DATAQUERY_DEFAULT = "DEFAULT";

    public WXMediaDAOBase() {
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
        return "net.ibizsys.psrt.srv.wx.dao.WXMediaDAO";
    }

    private WXMediaDEModel wXMediaDEModel;

    /**
    * 获取实体[WXMedia]模型对象
    * @return
    */
    public  WXMediaDEModel getWXMediaDEModel() {
        if(this.wXMediaDEModel==null) {
            try {
                this.wXMediaDEModel = (WXMediaDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wXMediaDEModel;
    }

    /*
     * (non-Javadoc)
     * @see net.ibizsys.paas.dao.DAOBase#getDEModel()
     */
    @Override
    public  IDataEntityModel getDEModel() {
        return this.getWXMediaDEModel();
    }



}