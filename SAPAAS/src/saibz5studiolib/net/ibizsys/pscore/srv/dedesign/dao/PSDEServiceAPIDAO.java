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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEServiceAPIDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEServiceAPIDAO
extends PSCoreSysDAOBase<PSDEServiceAPI> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYSAPI = "CurSysAPI";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEServiceAPIDEModel pSDEServiceAPIDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEServiceAPIDAO";
    }

    public PSDEServiceAPIDEModel getPSDEServiceAPIDEModel() {
        if (this.pSDEServiceAPIDEModel == null) {
            try {
                this.pSDEServiceAPIDEModel = (PSDEServiceAPIDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEServiceAPIDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEServiceAPIDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEServiceAPIDEModel();
    }
}

