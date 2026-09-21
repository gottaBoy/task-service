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
import net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppEntityDEModel;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PSWPDCAppEntityDAO
extends PSCoreSysDAOBase<PSWPDCAppEntity> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWPDCAppEntityDEModel pSWPDCAppEntityDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfplatform.dao.PSWPDCAppEntityDAO";
    }

    public PSWPDCAppEntityDEModel getPSWPDCAppEntityDEModel() {
        if (this.pSWPDCAppEntityDEModel == null) {
            try {
                this.pSWPDCAppEntityDEModel = (PSWPDCAppEntityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfplatform.demodel.PSWPDCAppEntityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWPDCAppEntityDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWPDCAppEntityDEModel();
    }
}

