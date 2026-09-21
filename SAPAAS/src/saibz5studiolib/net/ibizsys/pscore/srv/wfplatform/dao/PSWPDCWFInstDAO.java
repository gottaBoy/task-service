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
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCWFInstDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCWFInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSWPDCWFInstDAO
extends PSCoreSysDAOBase<PSWPDCWFInst> {
    private static final long serialVersionUID = -1L;
    private PSWPDCWFInstDEModel pSWPDCWFInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCWFInstDAO";
    }

    public PSWPDCWFInstDEModel getPSWPDCWFInstDEModel() {
        if (this.pSWPDCWFInstDEModel == null) {
            try {
                this.pSWPDCWFInstDEModel = (PSWPDCWFInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCWFInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCWFInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWPDCWFInstDEModel();
    }
}

