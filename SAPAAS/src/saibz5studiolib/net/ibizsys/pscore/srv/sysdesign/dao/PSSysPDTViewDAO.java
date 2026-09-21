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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysPDTViewDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysPDTViewDAO
extends PSCoreSysDAOBase<PSSysPDTView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysPDTViewDEModel pSSysPDTViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysPDTViewDAO";
    }

    public PSSysPDTViewDEModel getPSSysPDTViewDEModel() {
        if (this.pSSysPDTViewDEModel == null) {
            try {
                this.pSSysPDTViewDEModel = (PSSysPDTViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysPDTViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPDTViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysPDTViewDEModel();
    }
}

