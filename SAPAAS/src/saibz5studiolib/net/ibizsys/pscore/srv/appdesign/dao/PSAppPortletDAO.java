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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppPortletDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortlet;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppPortletDAO
extends PSCoreSysDAOBase<PSAppPortlet> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppPortletDEModel pSAppPortletDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppPortletDAO";
    }

    public PSAppPortletDEModel getPSAppPortletDEModel() {
        if (this.pSAppPortletDEModel == null) {
            try {
                this.pSAppPortletDEModel = (PSAppPortletDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppPortletDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPortletDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppPortletDEModel();
    }
}

