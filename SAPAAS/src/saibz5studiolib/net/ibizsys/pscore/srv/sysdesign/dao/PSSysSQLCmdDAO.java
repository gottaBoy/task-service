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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSQLCmdDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmd;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysSQLCmdDAO
extends PSCoreSysDAOBase<PSSysSQLCmd> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysSQLCmdDEModel pSSysSQLCmdDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysSQLCmdDAO";
    }

    public PSSysSQLCmdDEModel getPSSysSQLCmdDEModel() {
        if (this.pSSysSQLCmdDEModel == null) {
            try {
                this.pSSysSQLCmdDEModel = (PSSysSQLCmdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSQLCmdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSQLCmdDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysSQLCmdDEModel();
    }
}

