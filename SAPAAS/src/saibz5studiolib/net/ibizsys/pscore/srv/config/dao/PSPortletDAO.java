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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSPortletDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPortlet;
import org.springframework.stereotype.Repository;

@Repository
public class PSPortletDAO
extends PSCoreSysDAOBase<PSPortlet> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPortletDEModel pSPortletDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPortletDAO";
    }

    public PSPortletDEModel getPSPortletDEModel() {
        if (this.pSPortletDEModel == null) {
            try {
                this.pSPortletDEModel = (PSPortletDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPortletDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPortletDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPortletDEModel();
    }
}

