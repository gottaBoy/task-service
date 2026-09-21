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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemDataDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemData;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysReqItemDataDAO
extends PSCoreSysDAOBase<PSSysReqItemData> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysReqItemDataDEModel pSSysReqItemDataDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysReqItemDataDAO";
    }

    public PSSysReqItemDataDEModel getPSSysReqItemDataDEModel() {
        if (this.pSSysReqItemDataDEModel == null) {
            try {
                this.pSSysReqItemDataDEModel = (PSSysReqItemDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysReqItemDataDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysReqItemDataDEModel();
    }
}

