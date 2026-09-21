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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTranslatorDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysTranslatorDAO
extends PSCoreSysDAOBase<PSSysTranslator> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysTranslatorDEModel pSSysTranslatorDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysTranslatorDAO";
    }

    public PSSysTranslatorDEModel getPSSysTranslatorDEModel() {
        if (this.pSSysTranslatorDEModel == null) {
            try {
                this.pSSysTranslatorDEModel = (PSSysTranslatorDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTranslatorDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTranslatorDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysTranslatorDEModel();
    }
}

