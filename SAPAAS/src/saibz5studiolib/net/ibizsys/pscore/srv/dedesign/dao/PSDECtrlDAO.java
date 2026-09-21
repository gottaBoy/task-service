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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDECtrlDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDECtrl;
import org.springframework.stereotype.Repository;

@Repository
public class PSDECtrlDAO
extends PSCoreSysDAOBase<PSDECtrl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDECtrlDEModel pSDECtrlDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDECtrlDAO";
    }

    public PSDECtrlDEModel getPSDECtrlDEModel() {
        if (this.pSDECtrlDEModel == null) {
            try {
                this.pSDECtrlDEModel = (PSDECtrlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDECtrlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDECtrlDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDECtrlDEModel();
    }
}

