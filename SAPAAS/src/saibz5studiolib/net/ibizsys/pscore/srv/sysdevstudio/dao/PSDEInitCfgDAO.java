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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDEInitCfgDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEInitCfgDAO
extends PSCoreSysDAOBase<PSDEInitCfg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEInitCfgDEModel pSDEInitCfgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDEInitCfgDAO";
    }

    public PSDEInitCfgDEModel getPSDEInitCfgDEModel() {
        if (this.pSDEInitCfgDEModel == null) {
            try {
                this.pSDEInitCfgDEModel = (PSDEInitCfgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDEInitCfgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEInitCfgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEInitCfgDEModel();
    }
}

