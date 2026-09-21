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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCBDInstDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCBDInstDAO
extends PSCoreSysDAOBase<PSDCBDInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCBDInstDEModel pSDCBDInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCBDInstDAO";
    }

    public PSDCBDInstDEModel getPSDCBDInstDEModel() {
        if (this.pSDCBDInstDEModel == null) {
            try {
                this.pSDCBDInstDEModel = (PSDCBDInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCBDInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBDInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCBDInstDEModel();
    }
}

