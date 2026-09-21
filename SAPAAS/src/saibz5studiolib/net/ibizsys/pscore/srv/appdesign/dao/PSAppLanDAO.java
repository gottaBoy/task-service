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
package net.ibizsys.pscore.srv.appdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppLanDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLan;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppLanDAO
extends PSCoreSysDAOBase<PSAppLan> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppLanDEModel pSAppLanDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppLanDAO";
    }

    public PSAppLanDEModel getPSAppLanDEModel() {
        if (this.pSAppLanDEModel == null) {
            try {
                this.pSAppLanDEModel = (PSAppLanDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppLanDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppLanDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppLanDEModel();
    }
}

