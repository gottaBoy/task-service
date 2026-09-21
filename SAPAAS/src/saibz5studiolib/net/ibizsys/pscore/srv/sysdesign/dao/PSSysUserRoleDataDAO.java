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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserRoleDataDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleData;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysUserRoleDataDAO
extends PSCoreSysDAOBase<PSSysUserRoleData> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysUserRoleDataDEModel pSSysUserRoleDataDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserRoleDataDAO";
    }

    public PSSysUserRoleDataDEModel getPSSysUserRoleDataDEModel() {
        if (this.pSSysUserRoleDataDEModel == null) {
            try {
                this.pSSysUserRoleDataDEModel = (PSSysUserRoleDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserRoleDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserRoleDataDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysUserRoleDataDEModel();
    }
}

