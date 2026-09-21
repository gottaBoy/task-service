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
package net.ibizsys.pscore.srv.wfdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFWorkTimeDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFWorkTime;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFWorkTimeDAO
extends PSCoreSysDAOBase<PSWFWorkTime> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFWorkTimeDEModel pSWFWorkTimeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFWorkTimeDAO";
    }

    public PSWFWorkTimeDEModel getPSWFWorkTimeDEModel() {
        if (this.pSWFWorkTimeDEModel == null) {
            try {
                this.pSWFWorkTimeDEModel = (PSWFWorkTimeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFWorkTimeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFWorkTimeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFWorkTimeDEModel();
    }
}

