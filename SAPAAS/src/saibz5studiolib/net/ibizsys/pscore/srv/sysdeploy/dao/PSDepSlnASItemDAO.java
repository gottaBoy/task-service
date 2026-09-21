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
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASItemDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSDepSlnASItemDAO
extends PSCoreSysDAOBase<PSDepSlnASItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDepSlnASItemDEModel pSDepSlnASItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASItemDAO";
    }

    public PSDepSlnASItemDEModel getPSDepSlnASItemDEModel() {
        if (this.pSDepSlnASItemDEModel == null) {
            try {
                this.pSDepSlnASItemDEModel = (PSDepSlnASItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDepSlnASItemDEModel();
    }
}

