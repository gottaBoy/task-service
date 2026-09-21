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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnMSDepFuncDAO
extends PSCoreSysDAOBase<PSDevSlnMSDepFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDEPLOY = "CurDeploy";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnMSDepFuncDEModel pSDevSlnMSDepFuncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnMSDepFuncDAO";
    }

    public PSDevSlnMSDepFuncDEModel getPSDevSlnMSDepFuncDEModel() {
        if (this.pSDevSlnMSDepFuncDEModel == null) {
            try {
                this.pSDevSlnMSDepFuncDEModel = (PSDevSlnMSDepFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepFuncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnMSDepFuncDEModel();
    }
}

