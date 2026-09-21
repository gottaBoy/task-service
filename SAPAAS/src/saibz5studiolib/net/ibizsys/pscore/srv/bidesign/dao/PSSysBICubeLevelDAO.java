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
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeLevelDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBICubeLevelDAO
extends PSCoreSysDAOBase<PSSysBICubeLevel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBICubeLevelDEModel pSSysBICubeLevelDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeLevelDAO";
    }

    public PSSysBICubeLevelDEModel getPSSysBICubeLevelDEModel() {
        if (this.pSSysBICubeLevelDEModel == null) {
            try {
                this.pSSysBICubeLevelDEModel = (PSSysBICubeLevelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeLevelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeLevelDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBICubeLevelDEModel();
    }
}

