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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppResourceDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppResource;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppResourceDAO
extends PSCoreSysDAOBase<PSAppResource> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppResourceDEModel pSAppResourceDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppResourceDAO";
    }

    public PSAppResourceDEModel getPSAppResourceDEModel() {
        if (this.pSAppResourceDEModel == null) {
            try {
                this.pSAppResourceDEModel = (PSAppResourceDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppResourceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppResourceDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppResourceDEModel();
    }
}

