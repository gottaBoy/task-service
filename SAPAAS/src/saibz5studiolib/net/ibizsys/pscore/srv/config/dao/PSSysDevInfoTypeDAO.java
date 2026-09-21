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
import net.ibizsys.pscore.srv.config.demodel.PSSysDevInfoTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysDevInfoType;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysDevInfoTypeDAO
extends PSCoreSysDAOBase<PSSysDevInfoType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysDevInfoTypeDEModel pSSysDevInfoTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSysDevInfoTypeDAO";
    }

    public PSSysDevInfoTypeDEModel getPSSysDevInfoTypeDEModel() {
        if (this.pSSysDevInfoTypeDEModel == null) {
            try {
                this.pSSysDevInfoTypeDEModel = (PSSysDevInfoTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysDevInfoTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDevInfoTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysDevInfoTypeDEModel();
    }
}

