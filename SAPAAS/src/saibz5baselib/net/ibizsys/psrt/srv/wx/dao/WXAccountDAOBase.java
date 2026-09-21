/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.wx.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.wx.demodel.WXAccountDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXAccount;

public abstract class WXAccountDAOBase
extends PSRuntimeSysDAOBase<WXAccount> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WXAccountDEModel wXAccountDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wx.dao.WXAccountDAO";
    }

    public WXAccountDEModel getWXAccountDEModel() {
        if (this.wXAccountDEModel == null) {
            try {
                this.wXAccountDEModel = (WXAccountDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXAccountDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXAccountDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWXAccountDEModel();
    }
}

