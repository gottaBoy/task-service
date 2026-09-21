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
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSWPDCAppInstDAO
extends PSCoreSysDAOBase<PSWPDCAppInst> {
    private static final long serialVersionUID = -1L;
    private PSWPDCAppInstDEModel pSWPDCAppInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCAppInstDAO";
    }

    public PSWPDCAppInstDEModel getPSWPDCAppInstDEModel() {
        if (this.pSWPDCAppInstDEModel == null) {
            try {
                this.pSWPDCAppInstDEModel = (PSWPDCAppInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCAppInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWPDCAppInstDEModel();
    }
}

