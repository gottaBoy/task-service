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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdCatDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSCorePrdCat;
import org.springframework.stereotype.Repository;

@Repository
public class PSCorePrdCatDAO
extends PSCoreSysDAOBase<PSCorePrdCat> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCorePrdCatDEModel pSCorePrdCatDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSCorePrdCatDAO";
    }

    public PSCorePrdCatDEModel getPSCorePrdCatDEModel() {
        if (this.pSCorePrdCatDEModel == null) {
            try {
                this.pSCorePrdCatDEModel = (PSCorePrdCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSCorePrdCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCorePrdCatDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCorePrdCatDEModel();
    }
}

