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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewEngineDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEViewEngineDAO
extends PSCoreSysDAOBase<PSDEViewEngine> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEViewEngineDEModel pSDEViewEngineDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEViewEngineDAO";
    }

    public PSDEViewEngineDEModel getPSDEViewEngineDEModel() {
        if (this.pSDEViewEngineDEModel == null) {
            try {
                this.pSDEViewEngineDEModel = (PSDEViewEngineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewEngineDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEViewEngineDEModel();
    }
}

