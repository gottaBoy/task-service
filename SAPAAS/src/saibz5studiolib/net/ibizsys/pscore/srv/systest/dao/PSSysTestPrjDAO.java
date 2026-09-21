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
package net.ibizsys.pscore.srv.systest.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.systest.demodel.PSSysTestPrjDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestPrj;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysTestPrjDAO
extends PSCoreSysDAOBase<PSSysTestPrj> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSAPI = "CurSysAPI";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysTestPrjDEModel pSSysTestPrjDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.systest.dao.PSSysTestPrjDAO";
    }

    public PSSysTestPrjDEModel getPSSysTestPrjDEModel() {
        if (this.pSSysTestPrjDEModel == null) {
            try {
                this.pSSysTestPrjDEModel = (PSSysTestPrjDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTestPrjDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestPrjDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysTestPrjDEModel();
    }
}

