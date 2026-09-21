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
import net.ibizsys.pscore.srv.config.demodel.PSViewEngineDEModel;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import org.springframework.stereotype.Repository;

@Repository
public class PSViewEngineDAO
extends PSCoreSysDAOBase<PSViewEngine> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VALIDPLUGIN = "ValidPlugin";
    public static final String DATAQUERY_VALIDVIEW = "ValidView";
    private PSViewEngineDEModel pSViewEngineDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSViewEngineDAO";
    }

    public PSViewEngineDEModel getPSViewEngineDEModel() {
        if (this.pSViewEngineDEModel == null) {
            try {
                this.pSViewEngineDEModel = (PSViewEngineDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewEngineDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewEngineDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSViewEngineDEModel();
    }
}

