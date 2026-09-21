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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysGroup;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysGroupDAO
extends PSCoreSysDAOBase<PSDevSlnSysGroup> {
    private static final long serialVersionUID = -1L;
    private PSDevSlnSysGroupDEModel pSDevSlnSysGroupDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysGroupDAO";
    }

    public PSDevSlnSysGroupDEModel getPSDevSlnSysGroupDEModel() {
        if (this.pSDevSlnSysGroupDEModel == null) {
            try {
                this.pSDevSlnSysGroupDEModel = (PSDevSlnSysGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysGroupDEModel();
    }
}

