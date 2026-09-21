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
import net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXMedia;

public abstract class WXMediaDAOBase
extends PSRuntimeSysDAOBase<WXMedia> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WXMediaDEModel wXMediaDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wx.dao.WXMediaDAO";
    }

    public WXMediaDEModel getWXMediaDEModel() {
        if (this.wXMediaDEModel == null) {
            try {
                this.wXMediaDEModel = (WXMediaDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXMediaDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWXMediaDEModel();
    }
}

