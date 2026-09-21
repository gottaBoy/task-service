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
import net.ibizsys.pscore.srv.paasmgr.demodel.PSNDFileDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import org.springframework.stereotype.Repository;

@Repository
public class PSNDFileDAO
extends PSCoreSysDAOBase<PSNDFile> {
    private static final long serialVersionUID = -1L;
    private PSNDFileDEModel pSNDFileDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSNDFileDAO";
    }

    public PSNDFileDEModel getPSNDFileDEModel() {
        if (this.pSNDFileDEModel == null) {
            try {
                this.pSNDFileDEModel = (PSNDFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSNDFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSNDFileDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSNDFileDEModel();
    }
}

