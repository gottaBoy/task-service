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
package net.ibizsys.pscore.srv.eaidesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDEFieldDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEField;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysEAIDEFieldDAO
extends PSCoreSysDAOBase<PSSysEAIDEField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysEAIDEFieldDEModel pSSysEAIDEFieldDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDEFieldDAO";
    }

    public PSSysEAIDEFieldDEModel getPSSysEAIDEFieldDEModel() {
        if (this.pSSysEAIDEFieldDEModel == null) {
            try {
                this.pSSysEAIDEFieldDEModel = (PSSysEAIDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDEFieldDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysEAIDEFieldDEModel();
    }
}

