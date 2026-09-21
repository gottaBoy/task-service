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
package net.ibizsys.pscore.srv.wxdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import org.springframework.stereotype.Repository;

@Repository
public class PSWXMenuDAO
extends PSCoreSysDAOBase<PSWXMenu> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWXMenuDEModel pSWXMenuDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuDAO";
    }

    public PSWXMenuDEModel getPSWXMenuDEModel() {
        if (this.pSWXMenuDEModel == null) {
            try {
                this.pSWXMenuDEModel = (PSWXMenuDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWXMenuDEModel();
    }
}

