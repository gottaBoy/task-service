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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGrpDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGrpDetail;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEVRGrpDetailDAO
extends PSCoreSysDAOBase<PSDEVRGrpDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEVRGrpDetailDEModel pSDEVRGrpDetailDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEVRGrpDetailDAO";
    }

    public PSDEVRGrpDetailDEModel getPSDEVRGrpDetailDEModel() {
        if (this.pSDEVRGrpDetailDEModel == null) {
            try {
                this.pSDEVRGrpDetailDEModel = (PSDEVRGrpDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEVRGrpDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEVRGrpDetailDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEVRGrpDetailDEModel();
    }
}

