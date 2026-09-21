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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysGDDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGD;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysGDDAO
extends PSCoreSysDAOBase<PSDevSlnSysGD> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysGDDEModel pSDevSlnSysGDDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysGDDAO";
    }

    public PSDevSlnSysGDDEModel getPSDevSlnSysGDDEModel() {
        if (this.pSDevSlnSysGDDEModel == null) {
            try {
                this.pSDevSlnSysGDDEModel = (PSDevSlnSysGDDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysGDDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysGDDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysGDDEModel();
    }
}

