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
package net.ibizsys.pscore.srv.dynasys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEViewTemplDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaDEViewTemplDAO
extends PSCoreSysDAOBase<PSDynaDEViewTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDYNADE = "CurDynaDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaDEViewTemplDEModel pSDynaDEViewTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEViewTemplDAO";
    }

    public PSDynaDEViewTemplDEModel getPSDynaDEViewTemplDEModel() {
        if (this.pSDynaDEViewTemplDEModel == null) {
            try {
                this.pSDynaDEViewTemplDEModel = (PSDynaDEViewTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEViewTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEViewTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaDEViewTemplDEModel();
    }
}

