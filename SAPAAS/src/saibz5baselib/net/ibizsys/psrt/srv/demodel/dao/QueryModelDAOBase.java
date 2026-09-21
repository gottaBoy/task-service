/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.demodel.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel;
import net.ibizsys.psrt.srv.demodel.entity.QueryModel;

public abstract class QueryModelDAOBase
extends PSRuntimeSysDAOBase<QueryModel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private QueryModelDEModel queryModelDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO";
    }

    public QueryModelDEModel getQueryModelDEModel() {
        if (this.queryModelDEModel == null) {
            try {
                this.queryModelDEModel = (QueryModelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.queryModelDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getQueryModelDEModel();
    }
}

