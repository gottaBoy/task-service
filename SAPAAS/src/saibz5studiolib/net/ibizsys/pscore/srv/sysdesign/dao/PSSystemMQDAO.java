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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemMQDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemMQ;
import org.springframework.stereotype.Repository;

@Repository
public class PSSystemMQDAO
extends PSCoreSysDAOBase<PSSystemMQ> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSystemMQDEModel pSSystemMQDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSystemMQDAO";
    }

    public PSSystemMQDEModel getPSSystemMQDEModel() {
        if (this.pSSystemMQDEModel == null) {
            try {
                this.pSSystemMQDEModel = (PSSystemMQDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSystemMQDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSystemMQDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSystemMQDEModel();
    }
}

