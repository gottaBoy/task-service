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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlLogicGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import org.springframework.stereotype.Repository;

@Repository
public class PSCtrlLogicGroupDAO
extends PSCoreSysDAOBase<PSCtrlLogicGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSALL = "CurSysAll";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCtrlLogicGroupDEModel pSCtrlLogicGroupDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlLogicGroupDAO";
    }

    public PSCtrlLogicGroupDEModel getPSCtrlLogicGroupDEModel() {
        if (this.pSCtrlLogicGroupDEModel == null) {
            try {
                this.pSCtrlLogicGroupDEModel = (PSCtrlLogicGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlLogicGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlLogicGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCtrlLogicGroupDEModel();
    }
}

