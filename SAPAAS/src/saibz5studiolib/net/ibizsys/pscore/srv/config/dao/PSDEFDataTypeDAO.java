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
import net.ibizsys.pscore.srv.config.demodel.PSDEFDataTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFDataTypeDAO
extends PSCoreSysDAOBase<PSDEFDataType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VALID = "Valid";
    private PSDEFDataTypeDEModel pSDEFDataTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSDEFDataTypeDAO";
    }

    public PSDEFDataTypeDEModel getPSDEFDataTypeDEModel() {
        if (this.pSDEFDataTypeDEModel == null) {
            try {
                this.pSDEFDataTypeDEModel = (PSDEFDataTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEFDataTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDataTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFDataTypeDEModel();
    }
}

