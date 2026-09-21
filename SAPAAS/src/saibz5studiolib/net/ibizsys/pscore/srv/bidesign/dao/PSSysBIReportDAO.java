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
package net.ibizsys.pscore.srv.bidesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIReportDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBIReportDAO
extends PSCoreSysDAOBase<PSSysBIReport> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSCHEME = "CurScheme";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBIReportDEModel pSSysBIReportDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bidesign.dao.PSSysBIReportDAO";
    }

    public PSSysBIReportDEModel getPSSysBIReportDEModel() {
        if (this.pSSysBIReportDEModel == null) {
            try {
                this.pSSysBIReportDEModel = (PSSysBIReportDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBIReportDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBIReportDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBIReportDEModel();
    }
}

