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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSyncDataDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSyncData;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSyncDataDAO
extends PSCoreSysDAOBase<PSDCSyncData> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCSyncDataDEModel pSDCSyncDataDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSyncDataDAO";
    }

    public PSDCSyncDataDEModel getPSDCSyncDataDEModel() {
        if (this.pSDCSyncDataDEModel == null) {
            try {
                this.pSDCSyncDataDEModel = (PSDCSyncDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSyncDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSyncDataDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSyncDataDEModel();
    }
}

