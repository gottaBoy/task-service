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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSFPkgVerDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSFPkgVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSFPkgVerDAO
extends PSCoreSysDAOBase<PSDCSFPkgVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCSFPkgVerDEModel pSDCSFPkgVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSFPkgVerDAO";
    }

    public PSDCSFPkgVerDEModel getPSDCSFPkgVerDEModel() {
        if (this.pSDCSFPkgVerDEModel == null) {
            try {
                this.pSDCSFPkgVerDEModel = (PSDCSFPkgVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSFPkgVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSFPkgVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSFPkgVerDEModel();
    }
}

