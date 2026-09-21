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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEWizardDAO
extends PSCoreSysDAOBase<PSDEWizard> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURAPPSTATE = "CurAppState";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDESTATE = "CurDEState";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSSTATE = "CurSysState";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEWizardDEModel pSDEWizardDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardDAO";
    }

    public PSDEWizardDEModel getPSDEWizardDEModel() {
        if (this.pSDEWizardDEModel == null) {
            try {
                this.pSDEWizardDEModel = (PSDEWizardDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEWizardDEModel();
    }
}

