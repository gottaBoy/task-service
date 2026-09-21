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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFSubWFDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFSubWF;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFSubWFDAO
extends PSCoreSysDAOBase<PSWFSubWF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFSubWFDEModel pSWFSubWFDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFSubWFDAO";
    }

    public PSWFSubWFDEModel getPSWFSubWFDEModel() {
        if (this.pSWFSubWFDEModel == null) {
            try {
                this.pSWFSubWFDEModel = (PSWFSubWFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFSubWFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFSubWFDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFSubWFDEModel();
    }
}

