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
import net.ibizsys.pscore.srv.config.demodel.PSDBValueOPDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import org.springframework.stereotype.Repository;

@Repository
public class PSDBValueOPDAO
extends PSCoreSysDAOBase<PSDBValueOP> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DBMODE = "DBMode";
    public static final String DATAQUERY_DLMODE = "DLMode";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDBValueOPDEModel pSDBValueOPDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSDBValueOPDAO";
    }

    public PSDBValueOPDEModel getPSDBValueOPDEModel() {
        if (this.pSDBValueOPDEModel == null) {
            try {
                this.pSDBValueOPDEModel = (PSDBValueOPDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDBValueOPDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBValueOPDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDBValueOPDEModel();
    }
}

