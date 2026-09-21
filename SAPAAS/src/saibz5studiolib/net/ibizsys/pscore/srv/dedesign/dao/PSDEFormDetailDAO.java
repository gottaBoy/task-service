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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFormDetailDAO
extends PSCoreSysDAOBase<PSDEFormDetail> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURFORMFI = "CurFormFI";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_FI = "FI";
    public static final String DATAQUERY_FORMFI = "FormFI";
    private PSDEFormDetailDEModel pSDEFormDetailDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFormDetailDAO";
    }

    public PSDEFormDetailDEModel getPSDEFormDetailDEModel() {
        if (this.pSDEFormDetailDEModel == null) {
            try {
                this.pSDEFormDetailDEModel = (PSDEFormDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDetailDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFormDetailDEModel();
    }
}

