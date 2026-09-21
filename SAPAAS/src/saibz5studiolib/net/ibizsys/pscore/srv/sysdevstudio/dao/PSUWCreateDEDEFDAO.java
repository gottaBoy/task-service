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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEDEFDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEDEF;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWCreateDEDEFDAO
extends PSCoreSysDAOBase<PSUWCreateDEDEF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWCreateDEDEFDEModel pSUWCreateDEDEFDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWCreateDEDEFDAO";
    }

    public PSUWCreateDEDEFDEModel getPSUWCreateDEDEFDEModel() {
        if (this.pSUWCreateDEDEFDEModel == null) {
            try {
                this.pSUWCreateDEDEFDEModel = (PSUWCreateDEDEFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWCreateDEDEFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWCreateDEDEFDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWCreateDEDEFDEModel();
    }
}

