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
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaDEFormDAO
extends PSCoreSysDAOBase<PSDynaDEForm> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaDEFormDEModel pSDynaDEFormDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormDAO";
    }

    public PSDynaDEFormDEModel getPSDynaDEFormDEModel() {
        if (this.pSDynaDEFormDEModel == null) {
            try {
                this.pSDynaDEFormDEModel = (PSDynaDEFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaDEFormDEModel();
    }
}

