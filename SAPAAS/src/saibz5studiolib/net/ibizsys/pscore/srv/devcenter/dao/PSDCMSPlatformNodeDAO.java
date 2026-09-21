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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformNodeDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCMSPlatformNodeDAO
extends PSCoreSysDAOBase<PSDCMSPlatformNode> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_APINODE = "APINode";
    public static final String DATAQUERY_APPNODE = "AppNode";
    public static final String DATAQUERY_CURMSP = "CurMSP";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCMSPlatformNodeDEModel pSDCMSPlatformNodeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformNodeDAO";
    }

    public PSDCMSPlatformNodeDEModel getPSDCMSPlatformNodeDEModel() {
        if (this.pSDCMSPlatformNodeDEModel == null) {
            try {
                this.pSDCMSPlatformNodeDEModel = (PSDCMSPlatformNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformNodeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCMSPlatformNodeDEModel();
    }
}

