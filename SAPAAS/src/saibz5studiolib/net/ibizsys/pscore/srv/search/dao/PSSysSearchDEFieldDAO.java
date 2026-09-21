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
package net.ibizsys.pscore.srv.search.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEFieldDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEField;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSearchDEFieldDAO
extends PSCoreSysDAOBase<PSSysSearchDEField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSearchDEFieldDEModel pSSysSearchDEFieldDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.search.dao.PSSysSearchDEFieldDAO";
    }

    public PSSysSearchDEFieldDEModel getPSSysSearchDEFieldDEModel() {
        if (this.pSSysSearchDEFieldDEModel == null) {
            try {
                this.pSSysSearchDEFieldDEModel = (PSSysSearchDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDEFieldDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSearchDEFieldDEModel();
    }
}

