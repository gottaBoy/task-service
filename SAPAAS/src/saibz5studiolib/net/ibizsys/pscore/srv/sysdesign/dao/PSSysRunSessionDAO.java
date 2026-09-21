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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRunSessionDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysRunSessionDAO
extends PSCoreSysDAOBase<PSSysRunSession> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYSACTIVE = "CurSysActive";
    public static final String DATAQUERY_CURSYSFINISHED = "CurSysFinished";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysRunSessionDEModel pSSysRunSessionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysRunSessionDAO";
    }

    public PSSysRunSessionDEModel getPSSysRunSessionDEModel() {
        if (this.pSSysRunSessionDEModel == null) {
            try {
                this.pSSysRunSessionDEModel = (PSSysRunSessionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysRunSessionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysRunSessionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysRunSessionDEModel();
    }
}

