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
package net.ibizsys.pscore.srv.sysrt.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysrt.demodel.PSDCOrgSectorDEModel;
import net.ibizsys.pscore.srv.sysrt.entity.PSDCOrgSector;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCOrgSectorDAO
extends PSCoreSysDAOBase<PSDCOrgSector> {
    private static final long serialVersionUID = -1L;
    private PSDCOrgSectorDEModel pSDCOrgSectorDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysrt.dao.PSDCOrgSectorDAO";
    }

    public PSDCOrgSectorDEModel getPSDCOrgSectorDEModel() {
        if (this.pSDCOrgSectorDEModel == null) {
            try {
                this.pSDCOrgSectorDEModel = (PSDCOrgSectorDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysrt.demodel.PSDCOrgSectorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCOrgSectorDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCOrgSectorDEModel();
    }
}

