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
import net.ibizsys.pscore.srv.config.demodel.PSPFPkgVerDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFPkgVerDAO
extends PSCoreSysDAOBase<PSPFPkgVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPFPKG = "CurPFPkg";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFPkgVerDEModel pSPFPkgVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFPkgVerDAO";
    }

    public PSPFPkgVerDEModel getPSPFPkgVerDEModel() {
        if (this.pSPFPkgVerDEModel == null) {
            try {
                this.pSPFPkgVerDEModel = (PSPFPkgVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPkgVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPkgVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFPkgVerDEModel();
    }
}

