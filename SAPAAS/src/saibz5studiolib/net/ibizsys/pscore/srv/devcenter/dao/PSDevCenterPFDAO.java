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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterPFDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterPF;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevCenterPFDAO
extends PSCoreSysDAOBase<PSDevCenterPF> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevCenterPFDEModel pSDevCenterPFDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterPFDAO";
    }

    public PSDevCenterPFDEModel getPSDevCenterPFDEModel() {
        if (this.pSDevCenterPFDEModel == null) {
            try {
                this.pSDevCenterPFDEModel = (PSDevCenterPFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterPFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterPFDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevCenterPFDEModel();
    }
}

