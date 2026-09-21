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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlMsgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import org.springframework.stereotype.Repository;

@Repository
public class PSCtrlMsgDAO
extends PSCoreSysDAOBase<PSCtrlMsg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSALL = "CurSysAll";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCtrlMsgDEModel pSCtrlMsgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlMsgDAO";
    }

    public PSCtrlMsgDEModel getPSCtrlMsgDEModel() {
        if (this.pSCtrlMsgDEModel == null) {
            try {
                this.pSCtrlMsgDEModel = (PSCtrlMsgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlMsgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlMsgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCtrlMsgDEModel();
    }
}

