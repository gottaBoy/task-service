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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppDERSViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERSView;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppDERSViewDAO
extends PSCoreSysDAOBase<PSAppDERSView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppDERSViewDEModel pSAppDERSViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppDERSViewDAO";
    }

    public PSAppDERSViewDEModel getPSAppDERSViewDEModel() {
        if (this.pSAppDERSViewDEModel == null) {
            try {
                this.pSAppDERSViewDEModel = (PSAppDERSViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppDERSViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppDERSViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppDERSViewDEModel();
    }
}

