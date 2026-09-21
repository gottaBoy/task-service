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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysServiceAPIDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubSysServiceAPIDAO
extends PSCoreSysDAOBase<PSSubSysServiceAPI> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSubSysServiceAPIDEModel pSSubSysServiceAPIDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysServiceAPIDAO";
    }

    public PSSubSysServiceAPIDEModel getPSSubSysServiceAPIDEModel() {
        if (this.pSSubSysServiceAPIDEModel == null) {
            try {
                this.pSSubSysServiceAPIDEModel = (PSSubSysServiceAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysServiceAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysServiceAPIDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubSysServiceAPIDEModel();
    }
}

