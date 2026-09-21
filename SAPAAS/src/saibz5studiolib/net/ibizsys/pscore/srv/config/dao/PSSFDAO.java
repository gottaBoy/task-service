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
import net.ibizsys.pscore.srv.config.demodel.PSSFDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFDAO
extends PSCoreSysDAOBase<PSSF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VALID = "Valid";
    private PSSFDEModel pSSFDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFDAO";
    }

    public PSSFDEModel getPSSFDEModel() {
        if (this.pSSFDEModel == null) {
            try {
                this.pSSFDEModel = (PSSFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFDEModel();
    }
}

