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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSepcPlanXXXXDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSepcPlanXXXX;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdSepcPlanXXXXDAO
extends PSCoreSysDAOBase<PSDevPrdSepcPlanXXXX> {
    private static final long serialVersionUID = -1L;
    private PSDevPrdSepcPlanXXXXDEModel pSDevPrdSepcPlanXXXXDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSepcPlanXXXXDAO";
    }

    public PSDevPrdSepcPlanXXXXDEModel getPSDevPrdSepcPlanXXXXDEModel() {
        if (this.pSDevPrdSepcPlanXXXXDEModel == null) {
            try {
                this.pSDevPrdSepcPlanXXXXDEModel = (PSDevPrdSepcPlanXXXXDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSepcPlanXXXXDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSepcPlanXXXXDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdSepcPlanXXXXDEModel();
    }
}

