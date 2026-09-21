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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeListDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import org.springframework.stereotype.Repository;

@Repository
public class PSCodeListDAO
extends PSCoreSysDAOBase<PSCodeList> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURINST = "CurInst";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCodeListDEModel pSCodeListDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSCodeListDAO";
    }

    public PSCodeListDEModel getPSCodeListDEModel() {
        if (this.pSCodeListDEModel == null) {
            try {
                this.pSCodeListDEModel = (PSCodeListDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeListDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCodeListDEModel();
    }
}

