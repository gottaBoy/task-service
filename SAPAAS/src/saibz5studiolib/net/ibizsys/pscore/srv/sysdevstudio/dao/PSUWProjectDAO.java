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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWProjectDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWProjectDAO
extends PSCoreSysDAOBase<PSUWProject> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWProjectDEModel pSUWProjectDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWProjectDAO";
    }

    public PSUWProjectDEModel getPSUWProjectDEModel() {
        if (this.pSUWProjectDEModel == null) {
            try {
                this.pSUWProjectDEModel = (PSUWProjectDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWProjectDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWProjectDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWProjectDEModel();
    }
}

