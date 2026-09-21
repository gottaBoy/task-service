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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterMQDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterMQ;
import org.springframework.stereotype.Repository;

@Repository
public class PSDevCenterMQDAO
extends PSCoreSysDAOBase<PSDevCenterMQ> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDevCenterMQDEModel pSDevCenterMQDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterMQDAO";
    }

    public PSDevCenterMQDEModel getPSDevCenterMQDEModel() {
        if (this.pSDevCenterMQDEModel == null) {
            try {
                this.pSDevCenterMQDEModel = (PSDevCenterMQDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterMQDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterMQDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDevCenterMQDEModel();
    }
}

