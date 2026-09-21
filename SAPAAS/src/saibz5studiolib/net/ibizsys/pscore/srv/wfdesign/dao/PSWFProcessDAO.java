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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcessDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFProcessDAO
extends PSCoreSysDAOBase<PSWFProcess> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_IA = "IA";
    private PSWFProcessDEModel pSWFProcessDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcessDAO";
    }

    public PSWFProcessDEModel getPSWFProcessDEModel() {
        if (this.pSWFProcessDEModel == null) {
            try {
                this.pSWFProcessDEModel = (PSWFProcessDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcessDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcessDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFProcessDEModel();
    }
}

