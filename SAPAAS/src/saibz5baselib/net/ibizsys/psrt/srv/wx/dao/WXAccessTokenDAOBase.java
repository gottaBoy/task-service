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
import net.ibizsys.psrt.srv.wx.demodel.WXAccessTokenDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXAccessToken;

public abstract class WXAccessTokenDAOBase
extends PSRuntimeSysDAOBase<WXAccessToken> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WXAccessTokenDEModel wXAccessTokenDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wx.dao.WXAccessTokenDAO";
    }

    public WXAccessTokenDEModel getWXAccessTokenDEModel() {
        if (this.wXAccessTokenDEModel == null) {
            try {
                this.wXAccessTokenDEModel = (WXAccessTokenDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXAccessTokenDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXAccessTokenDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWXAccessTokenDEModel();
    }
}

