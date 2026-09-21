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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysBakDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysBakDAO
extends PSCoreSysDAOBase<PSDevSlnSysBak> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysBakDEModel pSDevSlnSysBakDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysBakDAO";
    }

    public PSDevSlnSysBakDEModel getPSDevSlnSysBakDEModel() {
        if (this.pSDevSlnSysBakDEModel == null) {
            try {
                this.pSDevSlnSysBakDEModel = (PSDevSlnSysBakDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysBakDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysBakDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysBakDEModel();
    }
}

