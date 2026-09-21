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
import net.ibizsys.pscore.srv.config.demodel.PSModelPluginDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelPlugin;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelPluginDAO
extends PSCoreSysDAOBase<PSModelPlugin> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelPluginDEModel pSModelPluginDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelPluginDAO";
    }

    public PSModelPluginDEModel getPSModelPluginDEModel() {
        if (this.pSModelPluginDEModel == null) {
            try {
                this.pSModelPluginDEModel = (PSModelPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelPluginDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelPluginDEModel();
    }
}

