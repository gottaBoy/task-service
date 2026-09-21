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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCResHoursDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResHours;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCResHoursDAO
extends PSCoreSysDAOBase<PSDCResHours> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCResHoursDEModel pSDCResHoursDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCResHoursDAO";
    }

    public PSDCResHoursDEModel getPSDCResHoursDEModel() {
        if (this.pSDCResHoursDEModel == null) {
            try {
                this.pSDCResHoursDEModel = (PSDCResHoursDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCResHoursDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCResHoursDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCResHoursDEModel();
    }
}

