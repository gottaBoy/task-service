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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysAppDAO
extends PSCoreSysDAOBase<PSDevSlnSysApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSER2 = "CurUser2";
    public static final String DATAQUERY_CURUSER3 = "CurUser3";
    public static final String DATAQUERY_CURUSER4 = "CurUser4";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysAppDEModel pSDevSlnSysAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysAppDAO";
    }

    public PSDevSlnSysAppDEModel getPSDevSlnSysAppDEModel() {
        if (this.pSDevSlnSysAppDEModel == null) {
            try {
                this.pSDevSlnSysAppDEModel = (PSDevSlnSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysAppDEModel();
    }
}

