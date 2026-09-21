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
import net.ibizsys.pscore.srv.systest.demodel.PSSysTCInputDEModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInput;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysTCInputDAO
extends PSCoreSysDAOBase<PSSysTCInput> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURTESTCASE = "CurTestCase";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysTCInputDEModel pSSysTCInputDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.systest.dao.PSSysTCInputDAO";
    }

    public PSSysTCInputDEModel getPSSysTCInputDEModel() {
        if (this.pSSysTCInputDEModel == null) {
            try {
                this.pSSysTCInputDEModel = (PSSysTCInputDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTCInputDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTCInputDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysTCInputDEModel();
    }
}

