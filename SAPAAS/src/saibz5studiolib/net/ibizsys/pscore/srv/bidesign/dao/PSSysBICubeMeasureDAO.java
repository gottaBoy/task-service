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
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMeasureDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBICubeMeasureDAO
extends PSCoreSysDAOBase<PSSysBICubeMeasure> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCUBE = "CurCube";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBICubeMeasureDEModel pSSysBICubeMeasureDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMeasureDAO";
    }

    public PSSysBICubeMeasureDEModel getPSSysBICubeMeasureDEModel() {
        if (this.pSSysBICubeMeasureDEModel == null) {
            try {
                this.pSSysBICubeMeasureDEModel = (PSSysBICubeMeasureDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMeasureDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMeasureDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBICubeMeasureDEModel();
    }
}

