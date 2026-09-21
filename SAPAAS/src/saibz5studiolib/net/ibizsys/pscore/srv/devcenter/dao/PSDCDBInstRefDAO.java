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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBInstRefDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRef;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCDBInstRefDAO
extends PSCoreSysDAOBase<PSDCDBInstRef> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCDBInstRefDEModel pSDCDBInstRefDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCDBInstRefDAO";
    }

    public PSDCDBInstRefDEModel getPSDCDBInstRefDEModel() {
        if (this.pSDCDBInstRefDEModel == null) {
            try {
                this.pSDCDBInstRefDEModel = (PSDCDBInstRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBInstRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBInstRefDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCDBInstRefDEModel();
    }
}

