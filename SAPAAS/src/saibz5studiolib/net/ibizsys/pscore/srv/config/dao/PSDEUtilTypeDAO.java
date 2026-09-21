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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSDEUtilTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDEUtilType;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEUtilTypeDAO
extends PSCoreSysDAOBase<PSDEUtilType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEUtilTypeDEModel pSDEUtilTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSDEUtilTypeDAO";
    }

    public PSDEUtilTypeDEModel getPSDEUtilTypeDEModel() {
        if (this.pSDEUtilTypeDEModel == null) {
            try {
                this.pSDEUtilTypeDEModel = (PSDEUtilTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEUtilTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUtilTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEUtilTypeDEModel();
    }
}

