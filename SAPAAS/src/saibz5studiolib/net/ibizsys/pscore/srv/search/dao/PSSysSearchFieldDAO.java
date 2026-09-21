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
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchFieldDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchField;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSearchFieldDAO
extends PSCoreSysDAOBase<PSSysSearchField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDOC = "CurDoc";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSearchFieldDEModel pSSysSearchFieldDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.search.dao.PSSysSearchFieldDAO";
    }

    public PSSysSearchFieldDEModel getPSSysSearchFieldDEModel() {
        if (this.pSSysSearchFieldDEModel == null) {
            try {
                this.pSSysSearchFieldDEModel = (PSSysSearchFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchFieldDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSearchFieldDEModel();
    }
}

