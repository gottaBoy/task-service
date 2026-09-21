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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMobAppTestDeviceDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCMobAppTestDeviceDAO
extends PSCoreSysDAOBase<PSDCMobAppTestDevice> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCMobAppTestDeviceDEModel pSDCMobAppTestDeviceDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCMobAppTestDeviceDAO";
    }

    public PSDCMobAppTestDeviceDEModel getPSDCMobAppTestDeviceDEModel() {
        if (this.pSDCMobAppTestDeviceDEModel == null) {
            try {
                this.pSDCMobAppTestDeviceDEModel = (PSDCMobAppTestDeviceDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMobAppTestDeviceDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMobAppTestDeviceDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCMobAppTestDeviceDEModel();
    }
}

