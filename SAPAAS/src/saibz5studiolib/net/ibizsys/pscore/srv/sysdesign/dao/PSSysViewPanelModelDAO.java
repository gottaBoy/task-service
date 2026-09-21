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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelModelDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysViewPanelModelDAO
extends PSCoreSysDAOBase<PSSysViewPanelModel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPANEL = "CurPanel";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysViewPanelModelDEModel pSSysViewPanelModelDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelModelDAO";
    }

    public PSSysViewPanelModelDEModel getPSSysViewPanelModelDEModel() {
        if (this.pSSysViewPanelModelDEModel == null) {
            try {
                this.pSSysViewPanelModelDEModel = (PSSysViewPanelModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelModelDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysViewPanelModelDEModel();
    }
}

