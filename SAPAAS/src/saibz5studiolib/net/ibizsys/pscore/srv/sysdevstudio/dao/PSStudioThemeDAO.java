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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSStudioThemeDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import org.springframework.stereotype.Repository;

@Repository
public class PSStudioThemeDAO
extends PSCoreSysDAOBase<PSStudioTheme> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLDCVALID = "AllDCValid";
    public static final String DATAQUERY_CURDCVALID = "CurDCValid";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSStudioThemeDEModel pSStudioThemeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSStudioThemeDAO";
    }

    public PSStudioThemeDEModel getPSStudioThemeDEModel() {
        if (this.pSStudioThemeDEModel == null) {
            try {
                this.pSStudioThemeDEModel = (PSStudioThemeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSStudioThemeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioThemeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSStudioThemeDEModel();
    }
}

