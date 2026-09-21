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
package net.ibizsys.pscore.srv.wfdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcSubWFDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcSubWF;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFProcSubWFDAO
extends PSCoreSysDAOBase<PSWFProcSubWF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFProcSubWFDEModel pSWFProcSubWFDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFProcSubWFDAO";
    }

    public PSWFProcSubWFDEModel getPSWFProcSubWFDEModel() {
        if (this.pSWFProcSubWFDEModel == null) {
            try {
                this.pSWFProcSubWFDEModel = (PSWFProcSubWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFProcSubWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFProcSubWFDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFProcSubWFDEModel();
    }
}

