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
import net.ibizsys.pscore.srv.search.demodel.PSSysSearchDocDEModel;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSearchDocDAO
extends PSCoreSysDAOBase<PSSysSearchDoc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSCHEME = "CurScheme";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSearchDocDEModel pSSysSearchDocDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.search.dao.PSSysSearchDocDAO";
    }

    public PSSysSearchDocDEModel getPSSysSearchDocDEModel() {
        if (this.pSSysSearchDocDEModel == null) {
            try {
                this.pSSysSearchDocDEModel = (PSSysSearchDocDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.search.demodel.PSSysSearchDocDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSearchDocDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSearchDocDEModel();
    }
}

