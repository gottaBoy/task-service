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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSBDDevInstDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBDDevInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSBDDevInstDAO
extends PSCoreSysDAOBase<PSBDDevInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSBDDevInstDEModel pSBDDevInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSBDDevInstDAO";
    }

    public PSBDDevInstDEModel getPSBDDevInstDEModel() {
        if (this.pSBDDevInstDEModel == null) {
            try {
                this.pSBDDevInstDEModel = (PSBDDevInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSBDDevInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSBDDevInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSBDDevInstDEModel();
    }
}

