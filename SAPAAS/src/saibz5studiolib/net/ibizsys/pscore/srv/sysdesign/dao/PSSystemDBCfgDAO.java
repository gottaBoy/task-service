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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemDBCfgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import org.springframework.stereotype.Repository;

@Repository
public class PSSystemDBCfgDAO
extends PSCoreSysDAOBase<PSSystemDBCfg> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYS2 = "CurSys2";
    public static final String DATAQUERY_CURSYS3 = "CurSys3";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSystemDBCfgDEModel pSSystemDBCfgDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSystemDBCfgDAO";
    }

    public PSSystemDBCfgDEModel getPSSystemDBCfgDEModel() {
        if (this.pSSystemDBCfgDEModel == null) {
            try {
                this.pSSystemDBCfgDEModel = (PSSystemDBCfgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemDBCfgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemDBCfgDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSystemDBCfgDEModel();
    }
}

