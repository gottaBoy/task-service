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
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBILevelDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevel;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysBILevelDAO
extends PSCoreSysDAOBase<PSSysBILevel> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURHIERARCHY = "CurHierarchy";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysBILevelDEModel pSSysBILevelDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.bidesign.dao.PSSysBILevelDAO";
    }

    public PSSysBILevelDEModel getPSSysBILevelDEModel() {
        if (this.pSSysBILevelDEModel == null) {
            try {
                this.pSSysBILevelDEModel = (PSSysBILevelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBILevelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBILevelDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysBILevelDEModel();
    }
}

