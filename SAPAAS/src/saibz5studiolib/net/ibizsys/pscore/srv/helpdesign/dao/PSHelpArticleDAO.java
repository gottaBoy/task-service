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
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpArticleDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpArticleDAO
extends PSCoreSysDAOBase<PSHelpArticle> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSHelpArticleDEModel pSHelpArticleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpArticleDAO";
    }

    public PSHelpArticleDEModel getPSHelpArticleDEModel() {
        if (this.pSHelpArticleDEModel == null) {
            try {
                this.pSHelpArticleDEModel = (PSHelpArticleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpArticleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpArticleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpArticleDEModel();
    }
}

