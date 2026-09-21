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
import net.ibizsys.pscore.srv.systest.demodel.PSSysTCAssertDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCAssert;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysTCAssertDAO
extends PSCoreSysDAOBase<PSSysTCAssert> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURTESTCASE = "CurTestCase";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysTCAssertDEModel pSSysTCAssertDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.systest.dao.PSSysTCAssertDAO";
    }

    public PSSysTCAssertDEModel getPSSysTCAssertDEModel() {
        if (this.pSSysTCAssertDEModel == null) {
            try {
                this.pSSysTCAssertDEModel = (PSSysTCAssertDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTCAssertDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTCAssertDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysTCAssertDEModel();
    }
}

