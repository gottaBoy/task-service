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
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysEAIElementDAO
extends PSCoreSysDAOBase<PSSysEAIElement> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSCHEME = "CurScheme";
    public static final String DATAQUERY_CURSCHEMEAG = "CurSchemeAG";
    public static final String DATAQUERY_CURSCHEMECP = "CurSchemeCP";
    public static final String DATAQUERY_CURSCHEMEEG = "CurSchemeEG";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysEAIElementDEModel pSSysEAIElementDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementDAO";
    }

    public PSSysEAIElementDEModel getPSSysEAIElementDEModel() {
        if (this.pSSysEAIElementDEModel == null) {
            try {
                this.pSSysEAIElementDEModel = (PSSysEAIElementDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysEAIElementDEModel();
    }
}

