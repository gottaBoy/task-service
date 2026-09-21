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
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpSectionDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpSectionDAO
extends PSCoreSysDAOBase<PSHelpSection> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURART = "CurArt";
    public static final String DATAQUERY_CURARTROOT = "CurArtRoot";
    public static final String DATAQUERY_CURCHILD = "CurChild";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ROOT = "Root";
    public static final String DATAQUERY_VALID = "Valid";
    public static final String DATAQUERY_VALIDROOT = "ValidRoot";
    private PSHelpSectionDEModel pSHelpSectionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpSectionDAO";
    }

    public PSHelpSectionDEModel getPSHelpSectionDEModel() {
        if (this.pSHelpSectionDEModel == null) {
            try {
                this.pSHelpSectionDEModel = (PSHelpSectionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpSectionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpSectionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpSectionDEModel();
    }
}

