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
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaCodeListDAO
extends PSCoreSysDAOBase<PSDynaCodeList> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaCodeListDEModel pSDynaCodeListDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaCodeListDAO";
    }

    public PSDynaCodeListDEModel getPSDynaCodeListDEModel() {
        if (this.pSDynaCodeListDEModel == null) {
            try {
                this.pSDynaCodeListDEModel = (PSDynaCodeListDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaCodeListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaCodeListDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaCodeListDEModel();
    }
}

