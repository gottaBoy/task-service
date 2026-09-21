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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevBKTaskDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysDevBKTaskDAO
extends PSCoreSysDAOBase<PSSysDevBKTask> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYSFINISH = "CurSysFinish";
    public static final String DATAQUERY_CURSYSRUN = "CurSysRun";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_RUN = "Run";
    private PSSysDevBKTaskDEModel pSSysDevBKTaskDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysDevBKTaskDAO";
    }

    public PSSysDevBKTaskDEModel getPSSysDevBKTaskDEModel() {
        if (this.pSSysDevBKTaskDEModel == null) {
            try {
                this.pSSysDevBKTaskDEModel = (PSSysDevBKTaskDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysDevBKTaskDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevBKTaskDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysDevBKTaskDEModel();
    }
}

