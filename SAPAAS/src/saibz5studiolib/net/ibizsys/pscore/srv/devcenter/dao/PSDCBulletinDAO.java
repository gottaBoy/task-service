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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCBulletinDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBulletin;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCBulletinDAO
extends PSCoreSysDAOBase<PSDCBulletin> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCBulletinDEModel pSDCBulletinDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCBulletinDAO";
    }

    public PSDCBulletinDEModel getPSDCBulletinDEModel() {
        if (this.pSDCBulletinDEModel == null) {
            try {
                this.pSDCBulletinDEModel = (PSDCBulletinDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCBulletinDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBulletinDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCBulletinDEModel();
    }
}

