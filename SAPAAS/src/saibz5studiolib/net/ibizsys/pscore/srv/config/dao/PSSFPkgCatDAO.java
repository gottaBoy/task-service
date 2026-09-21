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
import net.ibizsys.pscore.srv.config.demodel.PSSFPkgCatDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgCat;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFPkgCatDAO
extends PSCoreSysDAOBase<PSSFPkgCat> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFPkgCatDEModel pSSFPkgCatDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFPkgCatDAO";
    }

    public PSSFPkgCatDEModel getPSSFPkgCatDEModel() {
        if (this.pSSFPkgCatDEModel == null) {
            try {
                this.pSSFPkgCatDEModel = (PSSFPkgCatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPkgCatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPkgCatDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFPkgCatDEModel();
    }
}

