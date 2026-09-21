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
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import org.springframework.stereotype.Repository;

@Repository
public class PSWFLinkDAO
extends PSCoreSysDAOBase<PSWFLink> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_IA = "IA";
    private PSWFLinkDEModel pSWFLinkDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wfdesign.dao.PSWFLinkDAO";
    }

    public PSWFLinkDEModel getPSWFLinkDEModel() {
        if (this.pSWFLinkDEModel == null) {
            try {
                this.pSWFLinkDEModel = (PSWFLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFLinkDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWFLinkDEModel();
    }
}

