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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseLiteDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseLite;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEViewBaseLiteDAO
extends PSCoreSysDAOBase<PSDEViewBaseLite> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_VIEW = "VIEW";
    private PSDEViewBaseLiteDEModel pSDEViewBaseLiteDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEViewBaseLiteDAO";
    }

    public PSDEViewBaseLiteDEModel getPSDEViewBaseLiteDEModel() {
        if (this.pSDEViewBaseLiteDEModel == null) {
            try {
                this.pSDEViewBaseLiteDEModel = (PSDEViewBaseLiteDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseLiteDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewBaseLiteDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEViewBaseLiteDEModel();
    }
}

