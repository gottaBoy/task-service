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
import net.ibizsys.pscore.srv.config.demodel.PSModelDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelDAO
extends PSCoreSysDAOBase<PSModel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelDEModel pSModelDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelDAO";
    }

    public PSModelDEModel getPSModelDEModel() {
        if (this.pSModelDEModel == null) {
            try {
                this.pSModelDEModel = (PSModelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelDEModel();
    }
}

