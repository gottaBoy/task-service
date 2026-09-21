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
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeListInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaCodeListInstDAO
extends PSCoreSysDAOBase<PSDynaCodeListInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaCodeListInstDEModel pSDynaCodeListInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaCodeListInstDAO";
    }

    public PSDynaCodeListInstDEModel getPSDynaCodeListInstDEModel() {
        if (this.pSDynaCodeListInstDEModel == null) {
            try {
                this.pSDynaCodeListInstDEModel = (PSDynaCodeListInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaCodeListInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaCodeListInstDEModel();
    }
}

