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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAppDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnMSDepAppDAO
extends PSCoreSysDAOBase<PSDevSlnMSDepApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURDEPLOY = "CurDeploy";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLNUNUSED = "CurSlnUnused";
    public static final String DATAQUERY_CURSLNUSED = "CurSlnUsed";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnMSDepAppDEModel pSDevSlnMSDepAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepAppDAO";
    }

    public PSDevSlnMSDepAppDEModel getPSDevSlnMSDepAppDEModel() {
        if (this.pSDevSlnMSDepAppDEModel == null) {
            try {
                this.pSDevSlnMSDepAppDEModel = (PSDevSlnMSDepAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepAppDEModel();
    }
}

