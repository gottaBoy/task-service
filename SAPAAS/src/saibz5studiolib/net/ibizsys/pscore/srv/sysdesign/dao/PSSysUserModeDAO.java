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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserModeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserMode;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysUserModeDAO
extends PSCoreSysDAOBase<PSSysUserMode> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysUserModeDEModel pSSysUserModeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserModeDAO";
    }

    public PSSysUserModeDEModel getPSSysUserModeDEModel() {
        if (this.pSSysUserModeDEModel == null) {
            try {
                this.pSSysUserModeDEModel = (PSSysUserModeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserModeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserModeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysUserModeDEModel();
    }
}

