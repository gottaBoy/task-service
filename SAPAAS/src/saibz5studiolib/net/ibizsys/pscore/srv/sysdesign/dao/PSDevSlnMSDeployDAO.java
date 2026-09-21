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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDeployDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnMSDeployDAO
extends PSCoreSysDAOBase<PSDevSlnMSDeploy> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnMSDeployDEModel pSDevSlnMSDeployDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDeployDAO";
    }

    public PSDevSlnMSDeployDEModel getPSDevSlnMSDeployDEModel() {
        if (this.pSDevSlnMSDeployDEModel == null) {
            try {
                this.pSDevSlnMSDeployDEModel = (PSDevSlnMSDeployDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDeployDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDeployDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDeployDEModel();
    }
}

