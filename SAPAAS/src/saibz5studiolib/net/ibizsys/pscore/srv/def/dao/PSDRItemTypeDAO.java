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
package net.ibizsys.pscore.srv.def.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.def.demodel.PSDRItemTypeDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDRItemType;
import org.springframework.stereotype.Repository;

@Repository
public class PSDRItemTypeDAO
extends PSCoreSysDAOBase<PSDRItemType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDRItemTypeDEModel pSDRItemTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSDRItemTypeDAO";
    }

    public PSDRItemTypeDEModel getPSDRItemTypeDEModel() {
        if (this.pSDRItemTypeDEModel == null) {
            try {
                this.pSDRItemTypeDEModel = (PSDRItemTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDRItemTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDRItemTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDRItemTypeDEModel();
    }
}

