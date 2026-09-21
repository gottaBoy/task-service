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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEDERDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEDER;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWCreateDEDERDAO
extends PSCoreSysDAOBase<PSUWCreateDEDER> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWCreateDEDERDEModel pSUWCreateDEDERDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEDERDAO";
    }

    public PSUWCreateDEDERDEModel getPSUWCreateDEDERDEModel() {
        if (this.pSUWCreateDEDERDEModel == null) {
            try {
                this.pSUWCreateDEDERDEModel = (PSUWCreateDEDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEDERDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEDERDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWCreateDEDERDEModel();
    }
}

