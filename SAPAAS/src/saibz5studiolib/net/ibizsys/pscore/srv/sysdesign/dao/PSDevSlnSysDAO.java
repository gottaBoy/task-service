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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevSlnSysDAO
extends PSCoreSysDAOBase<PSDevSlnSys> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLNTRUNK = "CurSlnTrunk";
    public static final String DATAQUERY_CURSYSBRANCH = "CurSysBranch";
    public static final String DATAQUERY_CURUSER = "CurUser";
    public static final String DATAQUERY_CURUSER2 = "CurUser2";
    public static final String DATAQUERY_CURUSER3 = "CurUser3";
    public static final String DATAQUERY_CURUSER4 = "CurUser4";
    public static final String DATAQUERY_CURUSER5 = "CurUser5";
    public static final String DATAQUERY_CURUSER6 = "CurUser6";
    public static final String DATAQUERY_CURUSERTRUNK = "CurUserTrunk";
    public static final String DATAQUERY_CURUSERTRUNK2 = "CurUserTrunk2";
    public static final String DATAQUERY_CURUSERTRUNK3 = "CurUserTrunk3";
    public static final String DATAQUERY_CURUSERTRUNK4 = "CurUserTrunk4";
    public static final String DATAQUERY_CURUSERTRUNK5 = "CurUserTrunk5";
    public static final String DATAQUERY_CURUSERTRUNK6 = "CurUserTrunk6";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ONLINE = "Online";
    public static final String DATAQUERY_TRUNK = "Trunk";
    private PSDevSlnSysDEModel pSDevSlnSysDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysDAO";
    }

    public PSDevSlnSysDEModel getPSDevSlnSysDEModel() {
        if (this.pSDevSlnSysDEModel == null) {
            try {
                this.pSDevSlnSysDEModel = (PSDevSlnSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDEModel();
    }
}

