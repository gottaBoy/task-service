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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDESADetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import org.springframework.stereotype.Repository;

@Repository
public class PSDESADetailDAO
extends PSCoreSysDAOBase<PSDESADetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPI = "CurAPI";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDESADetailDEModel pSDESADetailDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDESADetailDAO";
    }

    public PSDESADetailDEModel getPSDESADetailDEModel() {
        if (this.pSDESADetailDEModel == null) {
            try {
                this.pSDESADetailDEModel = (PSDESADetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDESADetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDESADetailDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDESADetailDEModel();
    }
}

