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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdVerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdVerDAO
extends PSCoreSysDAOBase<PSDevPrdVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPRD = "CurPrd";
    public static final String DATAQUERY_CURPRDROOTVER = "CurPrdRootVer";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevPrdVerDEModel pSDevPrdVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdVerDAO";
    }

    public PSDevPrdVerDEModel getPSDevPrdVerDEModel() {
        if (this.pSDevPrdVerDEModel == null) {
            try {
                this.pSDevPrdVerDEModel = (PSDevPrdVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdVerDEModel();
    }
}

