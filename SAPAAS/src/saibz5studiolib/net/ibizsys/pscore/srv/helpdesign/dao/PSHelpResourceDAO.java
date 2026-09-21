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
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpResourceDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpResource;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpResourceDAO
extends PSCoreSysDAOBase<PSHelpResource> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSIMAGE = "CurSysImage";
    public static final String DATAQUERY_CURSYSLINK = "CurSysLink";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSHelpResourceDEModel pSHelpResourceDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpResourceDAO";
    }

    public PSHelpResourceDEModel getPSHelpResourceDEModel() {
        if (this.pSHelpResourceDEModel == null) {
            try {
                this.pSHelpResourceDEModel = (PSHelpResourceDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpResourceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpResourceDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpResourceDEModel();
    }
}

