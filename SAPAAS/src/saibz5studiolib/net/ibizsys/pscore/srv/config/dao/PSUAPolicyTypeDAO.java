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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSUAPolicyTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSUAPolicyType;
import org.springframework.stereotype.Repository;

@Repository
public class PSUAPolicyTypeDAO
extends PSCoreSysDAOBase<PSUAPolicyType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUAPolicyTypeDEModel pSUAPolicyTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSUAPolicyTypeDAO";
    }

    public PSUAPolicyTypeDEModel getPSUAPolicyTypeDEModel() {
        if (this.pSUAPolicyTypeDEModel == null) {
            try {
                this.pSUAPolicyTypeDEModel = (PSUAPolicyTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSUAPolicyTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUAPolicyTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUAPolicyTypeDEModel();
    }
}

