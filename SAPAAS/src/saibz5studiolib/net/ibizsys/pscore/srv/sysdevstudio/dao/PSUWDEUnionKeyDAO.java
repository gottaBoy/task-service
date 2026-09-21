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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDEUnionKeyDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDEUnionKey;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWDEUnionKeyDAO
extends PSCoreSysDAOBase<PSUWDEUnionKey> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUWDEUnionKeyDEModel pSUWDEUnionKeyDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWDEUnionKeyDAO";
    }

    public PSUWDEUnionKeyDEModel getPSUWDEUnionKeyDEModel() {
        if (this.pSUWDEUnionKeyDEModel == null) {
            try {
                this.pSUWDEUnionKeyDEModel = (PSUWDEUnionKeyDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDEUnionKeyDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWDEUnionKeyDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWDEUnionKeyDEModel();
    }
}

