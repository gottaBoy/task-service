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
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeDimensionDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBICubeDimensionDAO
extends PSCoreSysDAOBase<PSSysBICubeDimension> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCUBE = "CurCube";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBICubeDimensionDEModel pSSysBICubeDimensionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeDimensionDAO";
    }

    public PSSysBICubeDimensionDEModel getPSSysBICubeDimensionDEModel() {
        if (this.pSSysBICubeDimensionDEModel == null) {
            try {
                this.pSSysBICubeDimensionDEModel = (PSSysBICubeDimensionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeDimensionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeDimensionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBICubeDimensionDEModel();
    }
}

