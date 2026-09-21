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
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuFuncDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import org.springframework.stereotype.Repository;

@Repository
public class PSWXMenuFuncDAO
extends PSCoreSysDAOBase<PSWXMenuFunc> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURWX = "CurWX";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWXMenuFuncDEModel pSWXMenuFuncDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuFuncDAO";
    }

    public PSWXMenuFuncDEModel getPSWXMenuFuncDEModel() {
        if (this.pSWXMenuFuncDEModel == null) {
            try {
                this.pSWXMenuFuncDEModel = (PSWXMenuFuncDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuFuncDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuFuncDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWXMenuFuncDEModel();
    }
}

