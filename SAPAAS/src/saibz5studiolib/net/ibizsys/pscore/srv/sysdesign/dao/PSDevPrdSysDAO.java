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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSys;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdSysDAO
extends PSCoreSysDAOBase<PSDevPrdSys> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURPRD = "CurPrd";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevPrdSysDEModel pSDevPrdSysDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSysDAO";
    }

    public PSDevPrdSysDEModel getPSDevPrdSysDEModel() {
        if (this.pSDevPrdSysDEModel == null) {
            try {
                this.pSDevPrdSysDEModel = (PSDevPrdSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSysDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdSysDEModel();
    }
}

