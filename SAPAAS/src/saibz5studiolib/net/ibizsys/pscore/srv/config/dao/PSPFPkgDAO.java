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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSPFPkgDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFPkgDAO
extends PSCoreSysDAOBase<PSPFPkg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPF = "CurPF";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFPkgDEModel pSPFPkgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFPkgDAO";
    }

    public PSPFPkgDEModel getPSPFPkgDEModel() {
        if (this.pSPFPkgDEModel == null) {
            try {
                this.pSPFPkgDEModel = (PSPFPkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFPkgDEModel();
    }
}

