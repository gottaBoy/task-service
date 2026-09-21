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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSyncDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEDataSyncDAO
extends PSCoreSysDAOBase<PSDEDataSync> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDEIN = "CurDEIn";
    public static final String DATAQUERY_CURDEOUT = "CurDEOut";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEDataSyncDEModel pSDEDataSyncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEDataSyncDAO";
    }

    public PSDEDataSyncDEModel getPSDEDataSyncDEModel() {
        if (this.pSDEDataSyncDEModel == null) {
            try {
                this.pSDEDataSyncDEModel = (PSDEDataSyncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSyncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSyncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEDataSyncDEModel();
    }
}

