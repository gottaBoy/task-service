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
package net.ibizsys.pscore.srv.helpdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpArticleCatDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticleCat;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpArticleCatDAO
extends PSCoreSysDAOBase<PSHelpArticleCat> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE2 = "CurDE2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSHelpArticleCatDEModel pSHelpArticleCatDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpArticleCatDAO";
    }

    public PSHelpArticleCatDEModel getPSHelpArticleCatDEModel() {
        if (this.pSHelpArticleCatDEModel == null) {
            try {
                this.pSHelpArticleCatDEModel = (PSHelpArticleCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpArticleCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleCatDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpArticleCatDEModel();
    }
}

