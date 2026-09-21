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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEItemDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWCreateDEItemDAO
extends PSCoreSysDAOBase<PSUWCreateDEItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWCreateDEItemDEModel pSUWCreateDEItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEItemDAO";
    }

    public PSUWCreateDEItemDEModel getPSUWCreateDEItemDEModel() {
        if (this.pSUWCreateDEItemDEModel == null) {
            try {
                this.pSUWCreateDEItemDEModel = (PSUWCreateDEItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWCreateDEItemDEModel();
    }
}

