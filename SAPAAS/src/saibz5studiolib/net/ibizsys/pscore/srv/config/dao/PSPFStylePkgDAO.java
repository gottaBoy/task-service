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
import net.ibizsys.pscore.srv.config.demodel.PSPFStylePkgDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFStylePkg;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFStylePkgDAO
extends PSCoreSysDAOBase<PSPFStylePkg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFStylePkgDEModel pSPFStylePkgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFStylePkgDAO";
    }

    public PSPFStylePkgDEModel getPSPFStylePkgDEModel() {
        if (this.pSPFStylePkgDEModel == null) {
            try {
                this.pSPFStylePkgDEModel = (PSPFStylePkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFStylePkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStylePkgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFStylePkgDEModel();
    }
}

