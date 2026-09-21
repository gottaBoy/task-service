/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.common.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.common.demodel.OrgDEModel;
import net.ibizsys.psrt.srv.common.entity.Org;

public abstract class OrgDAOBase
extends PSRuntimeSysDAOBase<Org> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLROOT = "AllRoot";
    public static final String DATAQUERY_CURCAT = "CurCat";
    public static final String DATAQUERY_CURCHILD = "CurChild";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private OrgDEModel orgDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.OrgDAO";
    }

    public OrgDEModel getOrgDEModel() {
        if (this.orgDEModel == null) {
            try {
                this.orgDEModel = (OrgDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getOrgDEModel();
    }
}

