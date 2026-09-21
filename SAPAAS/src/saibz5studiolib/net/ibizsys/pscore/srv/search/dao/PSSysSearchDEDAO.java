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
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSearchDEDAO
extends PSCoreSysDAOBase<PSSysSearchDE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSCHEME = "CurScheme";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSearchDEDEModel pSSysSearchDEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.search.dao.PSSysSearchDEDAO";
    }

    public PSSysSearchDEDEModel getPSSysSearchDEDEModel() {
        if (this.pSSysSearchDEDEModel == null) {
            try {
                this.pSSysSearchDEDEModel = (PSSysSearchDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSearchDEDEModel();
    }
}

