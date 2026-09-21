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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADEFieldDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import org.springframework.stereotype.Repository;

@Repository
public class PSSubSysSADEFieldDAO
extends PSCoreSysDAOBase<PSSubSysSADEField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSubSysSADEFieldDEModel pSSubSysSADEFieldDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSubSysSADEFieldDAO";
    }

    public PSSubSysSADEFieldDEModel getPSSubSysSADEFieldDEModel() {
        if (this.pSSubSysSADEFieldDEModel == null) {
            try {
                this.pSSubSysSADEFieldDEModel = (PSSubSysSADEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSubSysSADEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSubSysSADEFieldDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSubSysSADEFieldDEModel();
    }
}

