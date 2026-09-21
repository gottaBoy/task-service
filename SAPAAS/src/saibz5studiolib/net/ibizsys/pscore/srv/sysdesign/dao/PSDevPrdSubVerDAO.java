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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSubVerDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSubVer;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdSubVerDAO
extends PSCoreSysDAOBase<PSDevPrdSubVer> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSUBVER = "CurSubVer";
    public static final String DATAQUERY_CURVER = "CurVer";
    public static final String DATAQUERY_CURVERROOT = "CurVerRoot";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_ROOT = "Root";
    private PSDevPrdSubVerDEModel pSDevPrdSubVerDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSubVerDAO";
    }

    public PSDevPrdSubVerDEModel getPSDevPrdSubVerDEModel() {
        if (this.pSDevPrdSubVerDEModel == null) {
            try {
                this.pSDevPrdSubVerDEModel = (PSDevPrdSubVerDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSubVerDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSubVerDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdSubVerDEModel();
    }
}

