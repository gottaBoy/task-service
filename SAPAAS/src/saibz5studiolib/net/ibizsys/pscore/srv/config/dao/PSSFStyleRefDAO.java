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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSSFStyleRefDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleRef;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFStyleRefDAO
extends PSCoreSysDAOBase<PSSFStyleRef> {
    private static final long serialVersionUID = -1L;
    private PSSFStyleRefDEModel pSSFStyleRefDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFStyleRefDAO";
    }

    public PSSFStyleRefDEModel getPSSFStyleRefDEModel() {
        if (this.pSSFStyleRefDEModel == null) {
            try {
                this.pSSFStyleRefDEModel = (PSSFStyleRefDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStyleRefDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleRefDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFStyleRefDEModel();
    }
}

