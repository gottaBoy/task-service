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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMavenRepoDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepo;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCMavenRepoDAO
extends PSCoreSysDAOBase<PSDCMavenRepo> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCMavenRepoDEModel pSDCMavenRepoDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCMavenRepoDAO";
    }

    public PSDCMavenRepoDEModel getPSDCMavenRepoDEModel() {
        if (this.pSDCMavenRepoDEModel == null) {
            try {
                this.pSDCMavenRepoDEModel = (PSDCMavenRepoDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMavenRepoDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMavenRepoDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCMavenRepoDEModel();
    }
}

