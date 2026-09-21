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
package net.ibizsys.pscore.srv.dynasys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysDynaInstDAO
extends PSCoreSysDAOBase<PSDevSlnSysDynaInst> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSER3 = "CurUser3";
    public static final String DATAQUERY_CURUSER4 = "CurUser4";
    public static final String DATAQUERY_CURUSER5 = "CurUser5";
    public static final String DATAQUERY_CURUSER6 = "CurUser6";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnSysDynaInstDEModel pSDevSlnSysDynaInstDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDevSlnSysDynaInstDAO";
    }

    public PSDevSlnSysDynaInstDEModel getPSDevSlnSysDynaInstDEModel() {
        if (this.pSDevSlnSysDynaInstDEModel == null) {
            try {
                this.pSDevSlnSysDynaInstDEModel = (PSDevSlnSysDynaInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDevSlnSysDynaInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDynaInstDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDynaInstDEModel();
    }
}

