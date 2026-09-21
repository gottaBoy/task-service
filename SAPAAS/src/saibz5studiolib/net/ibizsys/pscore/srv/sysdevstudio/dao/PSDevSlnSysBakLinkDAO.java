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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysBakLinkDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysBakLinkDAO
extends PSCoreSysDAOBase<PSDevSlnSysBakLink> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysBakLinkDEModel pSDevSlnSysBakLinkDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSDevSlnSysBakLinkDAO";
    }

    public PSDevSlnSysBakLinkDEModel getPSDevSlnSysBakLinkDEModel() {
        if (this.pSDevSlnSysBakLinkDEModel == null) {
            try {
                this.pSDevSlnSysBakLinkDEModel = (PSDevSlnSysBakLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevSlnSysBakLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysBakLinkDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysBakLinkDEModel();
    }
}

