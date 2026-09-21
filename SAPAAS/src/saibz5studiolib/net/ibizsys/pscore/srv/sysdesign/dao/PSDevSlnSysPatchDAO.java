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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysPatchDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysPatch;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysPatchDAO
extends PSCoreSysDAOBase<PSDevSlnSysPatch> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysPatchDEModel pSDevSlnSysPatchDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysPatchDAO";
    }

    public PSDevSlnSysPatchDEModel getPSDevSlnSysPatchDEModel() {
        if (this.pSDevSlnSysPatchDEModel == null) {
            try {
                this.pSDevSlnSysPatchDEModel = (PSDevSlnSysPatchDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysPatchDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysPatchDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysPatchDEModel();
    }
}

