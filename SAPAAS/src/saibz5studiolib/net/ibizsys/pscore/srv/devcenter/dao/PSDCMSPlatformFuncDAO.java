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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformFuncDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformFunc;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCMSPlatformFuncDAO
extends PSCoreSysDAOBase<PSDCMSPlatformFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCMSPlatformFuncDEModel pSDCMSPlatformFuncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCMSPlatformFuncDAO";
    }

    public PSDCMSPlatformFuncDEModel getPSDCMSPlatformFuncDEModel() {
        if (this.pSDCMSPlatformFuncDEModel == null) {
            try {
                this.pSDCMSPlatformFuncDEModel = (PSDCMSPlatformFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformFuncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCMSPlatformFuncDEModel();
    }
}

