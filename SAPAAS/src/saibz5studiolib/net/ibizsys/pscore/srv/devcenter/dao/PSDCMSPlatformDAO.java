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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCMSPlatformDAO
extends PSCoreSysDAOBase<PSDCMSPlatform> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCMSPlatformDEModel pSDCMSPlatformDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformDAO";
    }

    public PSDCMSPlatformDEModel getPSDCMSPlatformDEModel() {
        if (this.pSDCMSPlatformDEModel == null) {
            try {
                this.pSDCMSPlatformDEModel = (PSDCMSPlatformDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCMSPlatformDEModel();
    }
}

