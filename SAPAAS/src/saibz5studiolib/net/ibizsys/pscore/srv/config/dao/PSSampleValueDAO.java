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
import net.ibizsys.pscore.srv.config.demodel.PSSampleValueDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSampleValue;
import org.springframework.stereotype.Repository;

@Repository
public class PSSampleValueDAO
extends PSCoreSysDAOBase<PSSampleValue> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSampleValueDEModel pSSampleValueDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSampleValueDAO";
    }

    public PSSampleValueDEModel getPSSampleValueDEModel() {
        if (this.pSSampleValueDEModel == null) {
            try {
                this.pSSampleValueDEModel = (PSSampleValueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSampleValueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSampleValueDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSampleValueDEModel();
    }
}

