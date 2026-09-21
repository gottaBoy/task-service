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
package net.ibizsys.pscore.srv.sysdevstudio.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDELogicNodeDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDELogicNode;
import org.springframework.stereotype.Repository;

@Repository
public class PSUWDELogicNodeDAO
extends PSCoreSysDAOBase<PSUWDELogicNode> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW = "VIEW";
    private PSUWDELogicNodeDEModel pSUWDELogicNodeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWDELogicNodeDAO";
    }

    public PSUWDELogicNodeDEModel getPSUWDELogicNodeDEModel() {
        if (this.pSUWDELogicNodeDEModel == null) {
            try {
                this.pSUWDELogicNodeDEModel = (PSUWDELogicNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDELogicNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWDELogicNodeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUWDELogicNodeDEModel();
    }
}

