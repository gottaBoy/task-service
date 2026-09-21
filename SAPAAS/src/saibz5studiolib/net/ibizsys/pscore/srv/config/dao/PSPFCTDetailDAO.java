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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSPFCTDetailDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFCTDetail;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFCTDetailDAO
extends PSCoreSysDAOBase<PSPFCTDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFCTDetailDEModel pSPFCTDetailDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFCTDetailDAO";
    }

    public PSPFCTDetailDEModel getPSPFCTDetailDEModel() {
        if (this.pSPFCTDetailDEModel == null) {
            try {
                this.pSPFCTDetailDEModel = (PSPFCTDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFCTDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCTDetailDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFCTDetailDEModel();
    }
}

