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
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWF;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaWFDAO
extends PSCoreSysDAOBase<PSDynaWF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaWFDEModel pSDynaWFDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaWFDAO";
    }

    public PSDynaWFDEModel getPSDynaWFDEModel() {
        if (this.pSDynaWFDEModel == null) {
            try {
                this.pSDynaWFDEModel = (PSDynaWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaWFDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaWFDEModel();
    }
}

