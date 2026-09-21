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
package net.ibizsys.pscore.srv.helpdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModArtDEModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpModArt;
import org.springframework.stereotype.Repository;

@Repository
public class PSHelpModArtDAO
extends PSCoreSysDAOBase<PSHelpModArt> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSHelpModArtDEModel pSHelpModArtDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.helpdesign.dao.PSHelpModArtDAO";
    }

    public PSHelpModArtDEModel getPSHelpModArtDEModel() {
        if (this.pSHelpModArtDEModel == null) {
            try {
                this.pSHelpModArtDEModel = (PSHelpModArtDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.helpdesign.demodel.PSHelpModArtDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSHelpModArtDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSHelpModArtDEModel();
    }
}

