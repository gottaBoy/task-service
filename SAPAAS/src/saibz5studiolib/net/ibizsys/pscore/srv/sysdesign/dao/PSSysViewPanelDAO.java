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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysViewPanelDAO
extends PSCoreSysDAOBase<PSSysViewPanel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSCTRL = "CurSysCtrl";
    public static final String DATAQUERY_CURSYSVIEW = "CurSysView";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEWLAYOUT = "ViewLayout";
    private PSSysViewPanelDEModel pSSysViewPanelDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelDAO";
    }

    public PSSysViewPanelDEModel getPSSysViewPanelDEModel() {
        if (this.pSSysViewPanelDEModel == null) {
            try {
                this.pSSysViewPanelDEModel = (PSSysViewPanelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysViewPanelDEModel();
    }
}

