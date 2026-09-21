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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelMsgDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelMsg;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysModelMsgDAO
extends PSCoreSysDAOBase<PSSysModelMsg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysModelMsgDEModel pSSysModelMsgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSSysModelMsgDAO";
    }

    public PSSysModelMsgDEModel getPSSysModelMsgDEModel() {
        if (this.pSSysModelMsgDEModel == null) {
            try {
                this.pSSysModelMsgDEModel = (PSSysModelMsgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelMsgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelMsgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysModelMsgDEModel();
    }
}

