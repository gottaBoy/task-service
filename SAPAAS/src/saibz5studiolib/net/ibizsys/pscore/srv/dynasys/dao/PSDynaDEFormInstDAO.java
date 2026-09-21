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
package net.ibizsys.pscore.srv.dynasys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaDEFormInstDAO
extends PSCoreSysDAOBase<PSDynaDEFormInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaDEFormInstDEModel pSDynaDEFormInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormInstDAO";
    }

    public PSDynaDEFormInstDEModel getPSDynaDEFormInstDEModel() {
        if (this.pSDynaDEFormInstDEModel == null) {
            try {
                this.pSDynaDEFormInstDEModel = (PSDynaDEFormInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaDEFormInstDEModel();
    }
}

