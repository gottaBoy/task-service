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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSpecDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSpec;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevPrdSpecDAO
extends PSCoreSysDAOBase<PSDevPrdSpec> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURVER = "CurVer";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevPrdSpecDEModel pSDevPrdSpecDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDevPrdSpecDAO";
    }

    public PSDevPrdSpecDEModel getPSDevPrdSpecDEModel() {
        if (this.pSDevPrdSpecDEModel == null) {
            try {
                this.pSDevPrdSpecDEModel = (PSDevPrdSpecDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevPrdSpecDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevPrdSpecDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevPrdSpecDEModel();
    }
}

