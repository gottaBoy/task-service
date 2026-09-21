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
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAISchemeDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysEAISchemeDAO
extends PSCoreSysDAOBase<PSSysEAIScheme> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysEAISchemeDEModel pSSysEAISchemeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAISchemeDAO";
    }

    public PSSysEAISchemeDEModel getPSSysEAISchemeDEModel() {
        if (this.pSSysEAISchemeDEModel == null) {
            try {
                this.pSSysEAISchemeDEModel = (PSSysEAISchemeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAISchemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAISchemeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysEAISchemeDEModel();
    }
}

