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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADEDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADE;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubSysSADEDAO
extends PSCoreSysDAOBase<PSSubSysSADE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSA = "CurSA";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSubSysSADEDEModel pSSubSysSADEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADEDAO";
    }

    public PSSubSysSADEDEModel getPSSubSysSADEDEModel() {
        if (this.pSSubSysSADEDEModel == null) {
            try {
                this.pSSubSysSADEDEModel = (PSSubSysSADEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubSysSADEDEModel();
    }
}

