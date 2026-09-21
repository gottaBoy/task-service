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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderItemDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysModelFolderItemDAO
extends PSCoreSysDAOBase<PSSysModelFolderItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSER2 = "CurUser2";
    public static final String DATAQUERY_CURUSER3 = "CurUser3";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysModelFolderItemDEModel pSSysModelFolderItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelFolderItemDAO";
    }

    public PSSysModelFolderItemDEModel getPSSysModelFolderItemDEModel() {
        if (this.pSSysModelFolderItemDEModel == null) {
            try {
                this.pSSysModelFolderItemDEModel = (PSSysModelFolderItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysModelFolderItemDEModel();
    }
}

