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
import net.ibizsys.pscore.srv.config.demodel.PSViewTypeCatDEModel;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeCat;
import org.springframework.stereotype.Repository;

@Repository
public class PSViewTypeCatDAO
extends PSCoreSysDAOBase<PSViewTypeCat> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ROOTCAT = "RootCat";
    private PSViewTypeCatDEModel pSViewTypeCatDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSViewTypeCatDAO";
    }

    public PSViewTypeCatDEModel getPSViewTypeCatDEModel() {
        if (this.pSViewTypeCatDEModel == null) {
            try {
                this.pSViewTypeCatDEModel = (PSViewTypeCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewTypeCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewTypeCatDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSViewTypeCatDEModel();
    }
}

