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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnTemplDAO
extends PSCoreSysDAOBase<PSDevSlnTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLNTRUNK = "CurSlnTrunk";
    public static final String DATAQUERY_CURTEMPLBRANCH = "CurTemplBranch";
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSER3 = "CurUser3";
    public static final String DATAQUERY_CURUSER4 = "CurUser4";
    public static final String DATAQUERY_CURUSER5 = "CurUser5";
    public static final String DATAQUERY_CURUSER6 = "CurUser6";
    public static final String DATAQUERY_CURUSERTRUNK = "CurUserTrunk";
    public static final String DATAQUERY_CURUSERTRUNK3 = "CurUserTrunk3";
    public static final String DATAQUERY_CURUSERTRUNK4 = "CurUserTrunk4";
    public static final String DATAQUERY_CURUSERTRUNK5 = "CurUserTrunk5";
    public static final String DATAQUERY_CURUSERTRUNK6 = "CurUserTrunk6";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevSlnTemplDEModel pSDevSlnTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnTemplDAO";
    }

    public PSDevSlnTemplDEModel getPSDevSlnTemplDEModel() {
        if (this.pSDevSlnTemplDEModel == null) {
            try {
                this.pSDevSlnTemplDEModel = (PSDevSlnTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnTemplDEModel();
    }
}

