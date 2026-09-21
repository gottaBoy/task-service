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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCSyncData2DEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSyncData2;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCSyncData2DAO
extends PSCoreSysDAOBase<PSDCSyncData2> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCSyncData2DEModel pSDCSyncData2DEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCSyncData2DAO";
    }

    public PSDCSyncData2DEModel getPSDCSyncData2DEModel() {
        if (this.pSDCSyncData2DEModel == null) {
            try {
                this.pSDCSyncData2DEModel = (PSDCSyncData2DEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCSyncData2DEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCSyncData2DEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCSyncData2DEModel();
    }
}

