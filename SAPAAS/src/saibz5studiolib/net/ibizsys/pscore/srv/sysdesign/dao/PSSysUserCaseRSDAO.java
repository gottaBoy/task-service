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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserCaseRSDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseRS;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysUserCaseRSDAO
extends PSCoreSysDAOBase<PSSysUserCaseRS> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysUserCaseRSDEModel pSSysUserCaseRSDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserCaseRSDAO";
    }

    public PSSysUserCaseRSDEModel getPSSysUserCaseRSDEModel() {
        if (this.pSSysUserCaseRSDEModel == null) {
            try {
                this.pSSysUserCaseRSDEModel = (PSSysUserCaseRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserCaseRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserCaseRSDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysUserCaseRSDEModel();
    }
}

