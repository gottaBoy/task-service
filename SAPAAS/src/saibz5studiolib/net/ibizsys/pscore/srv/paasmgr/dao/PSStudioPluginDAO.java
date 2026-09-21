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
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioPluginDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioPlugin;
import org.springframework.stereotype.Repository;

@Repository
public class PSStudioPluginDAO
extends PSCoreSysDAOBase<PSStudioPlugin> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLDCVALID = "AllDCValid";
    public static final String DATAQUERY_CURDCVALID = "CurDCValid";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VALID = "Valid";
    private PSStudioPluginDEModel pSStudioPluginDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSStudioPluginDAO";
    }

    public PSStudioPluginDEModel getPSStudioPluginDEModel() {
        if (this.pSStudioPluginDEModel == null) {
            try {
                this.pSStudioPluginDEModel = (PSStudioPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSStudioPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSStudioPluginDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSStudioPluginDEModel();
    }
}

