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
import net.ibizsys.pscore.srv.config.demodel.PSSFSAHandlerDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFSAHandler;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFSAHandlerDAO
extends PSCoreSysDAOBase<PSSFSAHandler> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFSAHandlerDEModel pSSFSAHandlerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFSAHandlerDAO";
    }

    public PSSFSAHandlerDEModel getPSSFSAHandlerDEModel() {
        if (this.pSSFSAHandlerDEModel == null) {
            try {
                this.pSSFSAHandlerDEModel = (PSSFSAHandlerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFSAHandlerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFSAHandlerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFSAHandlerDEModel();
    }
}

