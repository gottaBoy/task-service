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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemHisDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemHis;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysReqItemHisDAO
extends PSCoreSysDAOBase<PSSysReqItemHis> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysReqItemHisDEModel pSSysReqItemHisDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysReqItemHisDAO";
    }

    public PSSysReqItemHisDEModel getPSSysReqItemHisDEModel() {
        if (this.pSSysReqItemHisDEModel == null) {
            try {
                this.pSSysReqItemHisDEModel = (PSSysReqItemHisDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysReqItemHisDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysReqItemHisDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysReqItemHisDEModel();
    }
}

