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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkCondDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFLinkCondDAO
extends PSCoreSysDAOBase<PSWFLinkCond> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWFLinkCondDEModel pSWFLinkCondDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkCondDAO";
    }

    public PSWFLinkCondDEModel getPSWFLinkCondDEModel() {
        if (this.pSWFLinkCondDEModel == null) {
            try {
                this.pSWFLinkCondDEModel = (PSWFLinkCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkCondDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFLinkCondDEModel();
    }
}

