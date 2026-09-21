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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSFPreviewActionDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSFPreviewAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFPreviewActionDAO
extends PSCoreSysDAOBase<PSSFPreviewAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFPreviewActionDEModel pSSFPreviewActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSFPreviewActionDAO";
    }

    public PSSFPreviewActionDEModel getPSSFPreviewActionDEModel() {
        if (this.pSSFPreviewActionDEModel == null) {
            try {
                this.pSSFPreviewActionDEModel = (PSSFPreviewActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSFPreviewActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPreviewActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFPreviewActionDEModel();
    }
}

