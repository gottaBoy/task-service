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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysConsoleDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysConsoleDAO
extends PSCoreSysDAOBase<PSSysConsole> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysConsoleDEModel pSSysConsoleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysConsoleDAO";
    }

    public PSSysConsoleDEModel getPSSysConsoleDEModel() {
        if (this.pSSysConsoleDEModel == null) {
            try {
                this.pSSysConsoleDEModel = (PSSysConsoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysConsoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysConsoleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysConsoleDEModel();
    }
}

