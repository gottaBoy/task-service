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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCodeServerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnCodeServer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnCodeServerDAO
extends PSCoreSysDAOBase<PSDevSlnCodeServer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnCodeServerDEModel pSDevSlnCodeServerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnCodeServerDAO";
    }

    public PSDevSlnCodeServerDEModel getPSDevSlnCodeServerDEModel() {
        if (this.pSDevSlnCodeServerDEModel == null) {
            try {
                this.pSDevSlnCodeServerDEModel = (PSDevSlnCodeServerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnCodeServerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnCodeServerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnCodeServerDEModel();
    }
}

