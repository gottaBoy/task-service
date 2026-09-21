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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicParamDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import org.springframework.stereotype.Repository;

@Repository
public class PSPanelLogicParamDAO
extends PSCoreSysDAOBase<PSPanelLogicParam> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURLOGIC = "CurLogic";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPanelLogicParamDEModel pSPanelLogicParamDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSPanelLogicParamDAO";
    }

    public PSPanelLogicParamDEModel getPSPanelLogicParamDEModel() {
        if (this.pSPanelLogicParamDEModel == null) {
            try {
                this.pSPanelLogicParamDEModel = (PSPanelLogicParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSPanelLogicParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPanelLogicParamDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPanelLogicParamDEModel();
    }
}

