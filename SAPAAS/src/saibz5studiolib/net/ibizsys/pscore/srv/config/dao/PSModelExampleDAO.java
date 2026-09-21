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
import net.ibizsys.pscore.srv.config.demodel.PSModelExampleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelExampleDAO
extends PSCoreSysDAOBase<PSModelExample> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelExampleDEModel pSModelExampleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelExampleDAO";
    }

    public PSModelExampleDEModel getPSModelExampleDEModel() {
        if (this.pSModelExampleDEModel == null) {
            try {
                this.pSModelExampleDEModel = (PSModelExampleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelExampleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelExampleDEModel();
    }
}

