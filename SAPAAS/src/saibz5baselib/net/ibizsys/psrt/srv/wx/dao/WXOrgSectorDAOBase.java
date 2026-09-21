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
import net.ibizsys.psrt.srv.wx.demodel.WXOrgSectorDEModel;
import net.ibizsys.psrt.srv.wx.entity.WXOrgSector;

public abstract class WXOrgSectorDAOBase
extends PSRuntimeSysDAOBase<WXOrgSector> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WXOrgSectorDEModel wXOrgSectorDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wx.dao.WXOrgSectorDAO";
    }

    public WXOrgSectorDEModel getWXOrgSectorDEModel() {
        if (this.wXOrgSectorDEModel == null) {
            try {
                this.wXOrgSectorDEModel = (WXOrgSectorDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wx.demodel.WXOrgSectorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wXOrgSectorDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWXOrgSectorDEModel();
    }
}

