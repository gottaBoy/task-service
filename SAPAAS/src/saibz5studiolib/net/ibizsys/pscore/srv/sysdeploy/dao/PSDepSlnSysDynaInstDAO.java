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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDynaInstDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnSysDynaInstDAO
extends PSCoreSysDAOBase<PSDepSlnSysDynaInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLN2 = "CurSln2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnSysDynaInstDEModel pSDepSlnSysDynaInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysDynaInstDAO";
    }

    public PSDepSlnSysDynaInstDEModel getPSDepSlnSysDynaInstDEModel() {
        if (this.pSDepSlnSysDynaInstDEModel == null) {
            try {
                this.pSDepSlnSysDynaInstDEModel = (PSDepSlnSysDynaInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysDynaInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysDynaInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnSysDynaInstDEModel();
    }
}

