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
import net.ibizsys.pscore.srv.config.demodel.PSPFCDNDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFCDN;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFCDNDAO
extends PSCoreSysDAOBase<PSPFCDN> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCDN = "CurCDN";
    public static final String DATAQUERY_CURCDN2 = "CurCDN2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFCDNDEModel pSPFCDNDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFCDNDAO";
    }

    public PSPFCDNDEModel getPSPFCDNDEModel() {
        if (this.pSPFCDNDEModel == null) {
            try {
                this.pSPFCDNDEModel = (PSPFCDNDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFCDNDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFCDNDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFCDNDEModel();
    }
}

