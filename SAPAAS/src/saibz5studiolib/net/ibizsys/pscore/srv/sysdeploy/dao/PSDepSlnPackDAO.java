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
package net.ibizsys.pscore.srv.sysdeploy.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPackDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPack;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnPackDAO
extends PSCoreSysDAOBase<PSDepSlnPack> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnPackDEModel pSDepSlnPackDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnPackDAO";
    }

    public PSDepSlnPackDEModel getPSDepSlnPackDEModel() {
        if (this.pSDepSlnPackDEModel == null) {
            try {
                this.pSDepSlnPackDEModel = (PSDepSlnPackDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPackDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnPackDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnPackDEModel();
    }
}

