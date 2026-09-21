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
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchSchemeDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSearchSchemeDAO
extends PSCoreSysDAOBase<PSSysSearchScheme> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSearchSchemeDEModel pSSysSearchSchemeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.search.dao.PSSysSearchSchemeDAO";
    }

    public PSSysSearchSchemeDEModel getPSSysSearchSchemeDEModel() {
        if (this.pSSysSearchSchemeDEModel == null) {
            try {
                this.pSSysSearchSchemeDEModel = (PSSysSearchSchemeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchSchemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchSchemeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSearchSchemeDEModel();
    }
}

