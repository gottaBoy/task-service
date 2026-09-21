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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysAppDAO
extends PSCoreSysDAOBase<PSSysApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSMOBAPP = "CurSysMobApp";
    public static final String DATAQUERY_CURSYSMOBWFAPP = "CurSysMobWFApp";
    public static final String DATAQUERY_CURSYSWFAPP = "CurSysWFApp";
    public static final String DATAQUERY_CURSYSWEBAPP = "CurSysWebApp";
    public static final String DATAQUERY_CURSYSWEBWFAPP = "CurSysWebWFApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_MOBAPP = "MobApp";
    public static final String DATAQUERY_WEBAPP = "WebApp";
    private PSSysAppDEModel pSSysAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysAppDAO";
    }

    public PSSysAppDEModel getPSSysAppDEModel() {
        if (this.pSSysAppDEModel == null) {
            try {
                this.pSSysAppDEModel = (PSSysAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysAppDEModel();
    }
}

