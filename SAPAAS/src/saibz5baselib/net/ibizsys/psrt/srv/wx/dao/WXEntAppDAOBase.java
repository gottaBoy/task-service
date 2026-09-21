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
import net.ibizsys.psrt.srv.wx.demodel.WXEntAppDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;

public abstract class WXEntAppDAOBase
extends PSRuntimeSysDAOBase<WXEntApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WXEntAppDEModel wXEntAppDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wx.dao.WXEntAppDAO";
    }

    public WXEntAppDEModel getWXEntAppDEModel() {
        if (this.wXEntAppDEModel == null) {
            try {
                this.wXEntAppDEModel = (WXEntAppDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXEntAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXEntAppDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWXEntAppDEModel();
    }
}

