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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIUpdateDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFIUpdateDAO
extends PSCoreSysDAOBase<PSDEFIUpdate> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURFORM = "CurForm";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEFIUpdateDEModel pSDEFIUpdateDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFIUpdateDAO";
    }

    public PSDEFIUpdateDEModel getPSDEFIUpdateDEModel() {
        if (this.pSDEFIUpdateDEModel == null) {
            try {
                this.pSDEFIUpdateDEModel = (PSDEFIUpdateDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIUpdateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIUpdateDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFIUpdateDEModel();
    }
}

