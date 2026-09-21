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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMapViewDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysMapViewDAO
extends PSCoreSysDAOBase<PSSysMapView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysMapViewDEModel pSSysMapViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysMapViewDAO";
    }

    public PSSysMapViewDEModel getPSSysMapViewDEModel() {
        if (this.pSSysMapViewDEModel == null) {
            try {
                this.pSSysMapViewDEModel = (PSSysMapViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysMapViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysMapViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysMapViewDEModel();
    }
}

