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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDEFTypeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDEFType;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysDEFTypeDAO
extends PSCoreSysDAOBase<PSSysDEFType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysDEFTypeDEModel pSSysDEFTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysDEFTypeDAO";
    }

    public PSSysDEFTypeDEModel getPSSysDEFTypeDEModel() {
        if (this.pSSysDEFTypeDEModel == null) {
            try {
                this.pSSysDEFTypeDEModel = (PSSysDEFTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDEFTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDEFTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysDEFTypeDEModel();
    }
}

