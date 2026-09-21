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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPITemplDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPITempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSFPITemplDAO
extends PSCoreSysDAOBase<PSSysSFPITempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSFPITemplDEModel pSSysSFPITemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPITemplDAO";
    }

    public PSSysSFPITemplDEModel getPSSysSFPITemplDEModel() {
        if (this.pSSysSFPITemplDEModel == null) {
            try {
                this.pSSysSFPITemplDEModel = (PSSysSFPITemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPITemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPITemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSFPITemplDEModel();
    }
}

