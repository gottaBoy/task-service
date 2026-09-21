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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSCodeItemDAO
extends PSCoreSysDAOBase<PSCodeItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCL = "CurCL";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSCodeItemDEModel pSCodeItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSCodeItemDAO";
    }

    public PSCodeItemDEModel getPSCodeItemDEModel() {
        if (this.pSCodeItemDEModel == null) {
            try {
                this.pSCodeItemDEModel = (PSCodeItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSCodeItemDEModel();
    }
}

