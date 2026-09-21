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
package net.ibizsys.pscore.srv.wfplatform.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSWPAppDAO
extends PSCoreSysDAOBase<PSWPApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWPAppDEModel pSWPAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfplatform.dao.PSWPAppDAO";
    }

    public PSWPAppDEModel getPSWPAppDEModel() {
        if (this.pSWPAppDEModel == null) {
            try {
                this.pSWPAppDEModel = (PSWPAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWPAppDEModel();
    }
}

