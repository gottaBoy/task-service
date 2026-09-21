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
import net.ibizsys.pscore.srv.config.demodel.PSSFCodeTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFCodeTypeDAO
extends PSCoreSysDAOBase<PSSFCodeType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSF = "CurSF";
    public static final String DATAQUERY_CURSF2 = "CurSF2";
    public static final String DATAQUERY_CURSF3 = "CurSF3";
    public static final String DATAQUERY_CURSF4 = "CurSF4";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFCodeTypeDEModel pSSFCodeTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFCodeTypeDAO";
    }

    public PSSFCodeTypeDEModel getPSSFCodeTypeDEModel() {
        if (this.pSSFCodeTypeDEModel == null) {
            try {
                this.pSSFCodeTypeDEModel = (PSSFCodeTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFCodeTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFCodeTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFCodeTypeDEModel();
    }
}

