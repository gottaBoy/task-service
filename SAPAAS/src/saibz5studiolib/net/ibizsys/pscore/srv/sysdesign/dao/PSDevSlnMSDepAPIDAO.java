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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAPIDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnMSDepAPIDAO
extends PSCoreSysDAOBase<PSDevSlnMSDepAPI> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPI = "CurAPI";
    public static final String DATAQUERY_CURDEPLOY = "CurDeploy";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLNUNUSED = "CurSlnUnused";
    public static final String DATAQUERY_CURSLNUSED = "CurSlnUsed";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnMSDepAPIDEModel pSDevSlnMSDepAPIDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepAPIDAO";
    }

    public PSDevSlnMSDepAPIDEModel getPSDevSlnMSDepAPIDEModel() {
        if (this.pSDevSlnMSDepAPIDEModel == null) {
            try {
                this.pSDevSlnMSDepAPIDEModel = (PSDevSlnMSDepAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepAPIDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepAPIDEModel();
    }
}

