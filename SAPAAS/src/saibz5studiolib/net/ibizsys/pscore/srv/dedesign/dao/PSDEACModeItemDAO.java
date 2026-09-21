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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEACModeItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEACModeItemDAO
extends PSCoreSysDAOBase<PSDEACModeItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEACModeItemDEModel pSDEACModeItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEACModeItemDAO";
    }

    public PSDEACModeItemDEModel getPSDEACModeItemDEModel() {
        if (this.pSDEACModeItemDEModel == null) {
            try {
                this.pSDEACModeItemDEModel = (PSDEACModeItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEACModeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEACModeItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEACModeItemDEModel();
    }
}

