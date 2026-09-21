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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBInstBKDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCDBInstBKDAO
extends PSCoreSysDAOBase<PSDCDBInstBK> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCDBInstBKDEModel pSDCDBInstBKDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCDBInstBKDAO";
    }

    public PSDCDBInstBKDEModel getPSDCDBInstBKDEModel() {
        if (this.pSDCDBInstBKDEModel == null) {
            try {
                this.pSDCDBInstBKDEModel = (PSDCDBInstBKDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCDBInstBKDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCDBInstBKDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCDBInstBKDEModel();
    }
}

