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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUIActionDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEUIActionDAO
extends PSCoreSysDAOBase<PSDEUIAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSDE = "CurSysDE";
    public static final String DATAQUERY_CURSYSNOWF = "CurSysNoWF";
    public static final String DATAQUERY_CURSYSWF = "CurSysWF";
    public static final String DATAQUERY_DECODENAMECNT = "DECodeNameCnt";
    public static final String DATAQUERY_DERANGE = "DERange";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_SYSRANGE = "SysRange";
    public static final String DATAQUERY_SYSRANGE2 = "SysRange2";
    private PSDEUIActionDEModel pSDEUIActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEUIActionDAO";
    }

    public PSDEUIActionDEModel getPSDEUIActionDEModel() {
        if (this.pSDEUIActionDEModel == null) {
            try {
                this.pSDEUIActionDEModel = (PSDEUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUIActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEUIActionDEModel();
    }
}

