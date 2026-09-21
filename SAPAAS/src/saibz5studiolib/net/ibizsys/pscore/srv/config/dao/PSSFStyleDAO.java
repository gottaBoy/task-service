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
import net.ibizsys.pscore.srv.config.demodel.PSSFStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import org.springframework.stereotype.Repository;

@Repository
public class PSSFStyleDAO
extends PSCoreSysDAOBase<PSSFStyle> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURDC2 = "CurDC2";
    public static final String DATAQUERY_CURDCDOC = "CurDCDoc";
    public static final String DATAQUERY_CURDCDOC2 = "CurDCDoc2";
    public static final String DATAQUERY_CURDCDOC3 = "CurDCDoc3";
    public static final String DATAQUERY_CURDCSF = "CurDCSF";
    public static final String DATAQUERY_CURDCSF2 = "CurDCSF2";
    public static final String DATAQUERY_CURDCSF3 = "CurDCSF3";
    public static final String DATAQUERY_CURSF = "CurSF";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSFStyleDEModel pSSFStyleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSFStyleDAO";
    }

    public PSSFStyleDEModel getPSSFStyleDEModel() {
        if (this.pSSFStyleDEModel == null) {
            try {
                this.pSSFStyleDEModel = (PSSFStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStyleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSFStyleDEModel();
    }
}

