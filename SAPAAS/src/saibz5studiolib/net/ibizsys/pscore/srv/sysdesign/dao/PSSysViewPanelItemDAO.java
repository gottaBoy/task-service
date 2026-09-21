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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysViewPanelItemDAO
extends PSCoreSysDAOBase<PSSysViewPanelItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPANEL = "CurPanel";
    public static final String DATAQUERY_CURPANELCONTROL = "CurPanelControl";
    public static final String DATAQUERY_CURPANELCTRLPOS = "CurPanelCtrlPos";
    public static final String DATAQUERY_CURPANELFIELD = "CurPanelField";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysViewPanelItemDEModel pSSysViewPanelItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelItemDAO";
    }

    public PSSysViewPanelItemDEModel getPSSysViewPanelItemDEModel() {
        if (this.pSSysViewPanelItemDEModel == null) {
            try {
                this.pSSysViewPanelItemDEModel = (PSSysViewPanelItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysViewPanelItemDEModel();
    }
}

