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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplRefDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplRef;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnTemplRefDAO
extends PSCoreSysDAOBase<PSDevSlnTemplRef> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnTemplRefDEModel pSDevSlnTemplRefDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnTemplRefDAO";
    }

    public PSDevSlnTemplRefDEModel getPSDevSlnTemplRefDEModel() {
        if (this.pSDevSlnTemplRefDEModel == null) {
            try {
                this.pSDevSlnTemplRefDEModel = (PSDevSlnTemplRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplRefDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnTemplRefDEModel();
    }
}

