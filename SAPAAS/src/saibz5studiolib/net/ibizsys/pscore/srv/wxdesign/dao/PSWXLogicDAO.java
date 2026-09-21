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
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXLogicDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXLogic;
import org.springframework.stereotype.Repository;

@Repository
public class PSWXLogicDAO
extends PSCoreSysDAOBase<PSWXLogic> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURWX = "CurWX";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSWXLogicDEModel pSWXLogicDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.wxdesign.dao.PSWXLogicDAO";
    }

    public PSWXLogicDEModel getPSWXLogicDEModel() {
        if (this.pSWXLogicDEModel == null) {
            try {
                this.pSWXLogicDEModel = (PSWXLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXLogicDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSWXLogicDEModel();
    }
}

