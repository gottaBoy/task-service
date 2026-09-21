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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSConsoleDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDSConsole;
import org.springframework.stereotype.Repository;

@Repository
public class PSDSConsoleDAO
extends PSCoreSysDAOBase<PSDSConsole> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDSConsoleDEModel pSDSConsoleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSConsoleDAO";
    }

    public PSDSConsoleDEModel getPSDSConsoleDEModel() {
        if (this.pSDSConsoleDEModel == null) {
            try {
                this.pSDSConsoleDEModel = (PSDSConsoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSConsoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSConsoleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDSConsoleDEModel();
    }
}

