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
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXEntAppDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXEntApp;
import org.springframework.stereotype.Repository;

@Repository
public class PSWXEntAppDAO
extends PSCoreSysDAOBase<PSWXEntApp> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURWX = "CurWX";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWXEntAppDEModel pSWXEntAppDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wxdesign.dao.PSWXEntAppDAO";
    }

    public PSWXEntAppDEModel getPSWXEntAppDEModel() {
        if (this.pSWXEntAppDEModel == null) {
            try {
                this.pSWXEntAppDEModel = (PSWXEntAppDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXEntAppDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXEntAppDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWXEntAppDEModel();
    }
}

