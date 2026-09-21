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
import net.ibizsys.pscore.srv.config.demodel.PSSFStyleParamDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleParam;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFStyleParamDAO
extends PSCoreSysDAOBase<PSSFStyleParam> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLDCVALID = "AllDCValid";
    public static final String DATAQUERY_ALLDCVALID2 = "AllDCValid2";
    public static final String DATAQUERY_CURDCVALID = "CurDCValid";
    public static final String DATAQUERY_CURDCVALID2 = "CurDCValid2";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFStyleParamDEModel pSSFStyleParamDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFStyleParamDAO";
    }

    public PSSFStyleParamDEModel getPSSFStyleParamDEModel() {
        if (this.pSSFStyleParamDEModel == null) {
            try {
                this.pSSFStyleParamDEModel = (PSSFStyleParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStyleParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleParamDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFStyleParamDEModel();
    }
}

