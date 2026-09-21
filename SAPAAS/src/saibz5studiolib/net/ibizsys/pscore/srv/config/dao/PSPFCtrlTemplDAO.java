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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSPFCtrlTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFCtrlTemplDAO
extends PSCoreSysDAOBase<PSPFCtrlTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFCtrlTemplDEModel pSPFCtrlTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFCtrlTemplDAO";
    }

    public PSPFCtrlTemplDEModel getPSPFCtrlTemplDEModel() {
        if (this.pSPFCtrlTemplDEModel == null) {
            try {
                this.pSPFCtrlTemplDEModel = (PSPFCtrlTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFCtrlTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCtrlTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFCtrlTemplDEModel();
    }
}

