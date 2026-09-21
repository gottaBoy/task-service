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
import net.ibizsys.psrt.srv.common.demodel.DEDataChg2DEModel;
import net.ibizsys.psrt.srv.common.entity.DEDataChg2;

public abstract class DEDataChg2DAOBase
extends PSRuntimeSysDAOBase<DEDataChg2> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private DEDataChg2DEModel dEDataChg2DEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.DEDataChg2DAO";
    }

    public DEDataChg2DEModel getDEDataChg2DEModel() {
        if (this.dEDataChg2DEModel == null) {
            try {
                this.dEDataChg2DEModel = (DEDataChg2DEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.DEDataChg2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dEDataChg2DEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getDEDataChg2DEModel();
    }
}

