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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSModelAPIRSDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSModelAPIRS;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelAPIRSDAO
extends PSCoreSysDAOBase<PSModelAPIRS> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelAPIRSDEModel pSModelAPIRSDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSModelAPIRSDAO";
    }

    public PSModelAPIRSDEModel getPSModelAPIRSDEModel() {
        if (this.pSModelAPIRSDEModel == null) {
            try {
                this.pSModelAPIRSDEModel = (PSModelAPIRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSModelAPIRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIRSDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelAPIRSDEModel();
    }
}

