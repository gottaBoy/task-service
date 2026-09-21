/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  org.springframework.stereotype.Repository
 */
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrd;
import org.springframework.stereotype.Repository;

@Repository
public class PSCorePrdDAO
extends PSCoreSysDAOBase<PSCorePrd> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCAT = "CurCat";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCorePrdDEModel pSCorePrdDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdDAO";
    }

    public PSCorePrdDEModel getPSCorePrdDEModel() {
        if (this.pSCorePrdDEModel == null) {
            try {
                this.pSCorePrdDEModel = (PSCorePrdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCorePrdDEModel();
    }
}

