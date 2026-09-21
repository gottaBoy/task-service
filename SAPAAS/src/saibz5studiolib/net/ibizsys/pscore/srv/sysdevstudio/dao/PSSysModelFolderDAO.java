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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolder;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysModelFolderDAO
extends PSCoreSysDAOBase<PSSysModelFolder> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSER2 = "CurUser2";
    public static final String DATAQUERY_CURUSER3 = "CurUser3";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysModelFolderDEModel pSSysModelFolderDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelFolderDAO";
    }

    public PSSysModelFolderDEModel getPSSysModelFolderDEModel() {
        if (this.pSSysModelFolderDEModel == null) {
            try {
                this.pSSysModelFolderDEModel = (PSSysModelFolderDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysModelFolderDEModel();
    }
}

