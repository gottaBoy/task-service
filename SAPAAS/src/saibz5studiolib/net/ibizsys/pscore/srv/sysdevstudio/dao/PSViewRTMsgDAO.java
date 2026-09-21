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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSViewRTMsgDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSViewRTMsg;
import org.springframework.stereotype.Repository;

@Repository
public class PSViewRTMsgDAO
extends PSCoreSysDAOBase<PSViewRTMsg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURVIEW = "CurView";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSViewRTMsgDEModel pSViewRTMsgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSViewRTMsgDAO";
    }

    public PSViewRTMsgDEModel getPSViewRTMsgDEModel() {
        if (this.pSViewRTMsgDEModel == null) {
            try {
                this.pSViewRTMsgDEModel = (PSViewRTMsgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSViewRTMsgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewRTMsgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSViewRTMsgDEModel();
    }
}

