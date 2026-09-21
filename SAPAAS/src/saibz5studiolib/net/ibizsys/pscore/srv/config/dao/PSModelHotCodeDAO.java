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
import net.ibizsys.pscore.srv.config.demodel.PSModelHotCodeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelHotCode;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelHotCodeDAO
extends PSCoreSysDAOBase<PSModelHotCode> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelHotCodeDEModel pSModelHotCodeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelHotCodeDAO";
    }

    public PSModelHotCodeDEModel getPSModelHotCodeDEModel() {
        if (this.pSModelHotCodeDEModel == null) {
            try {
                this.pSModelHotCodeDEModel = (PSModelHotCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelHotCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelHotCodeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelHotCodeDEModel();
    }
}

