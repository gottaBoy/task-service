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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPrdDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnPrdDAO
extends PSCoreSysDAOBase<PSDepSlnPrd> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDEPSLN = "CurDepSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnPrdDEModel pSDepSlnPrdDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnPrdDAO";
    }

    public PSDepSlnPrdDEModel getPSDepSlnPrdDEModel() {
        if (this.pSDepSlnPrdDEModel == null) {
            try {
                this.pSDepSlnPrdDEModel = (PSDepSlnPrdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnPrdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnPrdDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnPrdDEModel();
    }
}

