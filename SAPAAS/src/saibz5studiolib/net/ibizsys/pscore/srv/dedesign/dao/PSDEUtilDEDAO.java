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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUtilDEDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDE;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEUtilDEDAO
extends PSCoreSysDAOBase<PSDEUtilDE> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEUtilDEDEModel pSDEUtilDEDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEUtilDEDAO";
    }

    public PSDEUtilDEDEModel getPSDEUtilDEDEModel() {
        if (this.pSDEUtilDEDEModel == null) {
            try {
                this.pSDEUtilDEDEModel = (PSDEUtilDEDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUtilDEDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUtilDEDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEUtilDEDEModel();
    }
}

