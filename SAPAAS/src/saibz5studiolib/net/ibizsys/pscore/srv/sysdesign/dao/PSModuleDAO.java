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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSModuleDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import org.springframework.stereotype.Repository;

@Repository
public class PSModuleDAO
extends PSCoreSysDAOBase<PSModule> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_COUNTCODENAME = "CountCodeName";
    public static final String DATAQUERY_COUNTDEFFLAG = "CountDefFlag";
    public static final String DATAQUERY_COUNTMODULENAME = "CountModuleName";
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURSYS = "CurSYS";
    public static final String DATAQUERY_CURSYSNOTSUB = "CurSysNotSub";
    public static final String DATAQUERY_CURSYSSUB = "CurSysSub";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModuleDEModel pSModuleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSModuleDAO";
    }

    public PSModuleDEModel getPSModuleDEModel() {
        if (this.pSModuleDEModel == null) {
            try {
                this.pSModuleDEModel = (PSModuleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSModuleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModuleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModuleDEModel();
    }
}

