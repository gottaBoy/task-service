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
import net.ibizsys.pscore.srv.config.demodel.PSPFPluginDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFPluginDAO
extends PSCoreSysDAOBase<PSPFPlugin> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLVALID = "AllValid";
    public static final String DATAQUERY_DCVALID = "DCValid";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFPluginDEModel pSPFPluginDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFPluginDAO";
    }

    public PSPFPluginDEModel getPSPFPluginDEModel() {
        if (this.pSPFPluginDEModel == null) {
            try {
                this.pSPFPluginDEModel = (PSPFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPluginDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFPluginDEModel();
    }
}

