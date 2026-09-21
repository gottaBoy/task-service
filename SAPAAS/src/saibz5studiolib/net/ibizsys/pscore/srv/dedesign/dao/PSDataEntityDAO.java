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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDataEntityDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PSDataEntityDAO
extends PSCoreSysDAOBase<PSDataEntity> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURMODULE = "CurModule";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSAPP = "CurSysApp";
    public static final String DATAQUERY_CURSYSMODTAG = "CurSysModTag";
    public static final String DATAQUERY_CURSYSNOTSUBSYSDE = "CurSysNotSubSysDE";
    public static final String DATAQUERY_CURSYSNOTSUBSYSDE2 = "CurSysNotSubSysDE2";
    public static final String DATAQUERY_CURSYSSUBSYSDE = "CurSysSubSysDE";
    public static final String DATAQUERY_CURSYSSUBSYSDE2 = "CurSysSubSysDE2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_PSDE = "PSDE";
    public static final String DATAQUERY_RECENT = "Recent";
    private PSDataEntityDEModel pSDataEntityDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDataEntityDAO";
    }

    public PSDataEntityDEModel getPSDataEntityDEModel() {
        if (this.pSDataEntityDEModel == null) {
            try {
                this.pSDataEntityDEModel = (PSDataEntityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDataEntityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDataEntityDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDataEntityDEModel();
    }
}

