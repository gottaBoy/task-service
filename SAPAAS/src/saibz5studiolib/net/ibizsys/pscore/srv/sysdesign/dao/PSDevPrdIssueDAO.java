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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssueDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdIssue;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdIssueDAO
extends PSCoreSysDAOBase<PSDevPrdIssue> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPRD = "CurPrd";
    public static final String DATAQUERY_CURPRDVER = "CurPrdVer";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevPrdIssueDEModel pSDevPrdIssueDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdIssueDAO";
    }

    public PSDevPrdIssueDEModel getPSDevPrdIssueDEModel() {
        if (this.pSDevPrdIssueDEModel == null) {
            try {
                this.pSDevPrdIssueDEModel = (PSDevPrdIssueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdIssueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdIssueDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdIssueDEModel();
    }
}

