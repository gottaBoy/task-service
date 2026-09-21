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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppMenuDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppMenuDAO
extends PSCoreSysDAOBase<PSAppMenu> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppMenuDEModel pSAppMenuDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppMenuDAO";
    }

    public PSAppMenuDEModel getPSAppMenuDEModel() {
        if (this.pSAppMenuDEModel == null) {
            try {
                this.pSAppMenuDEModel = (PSAppMenuDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppMenuDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppMenuDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppMenuDEModel();
    }
}

