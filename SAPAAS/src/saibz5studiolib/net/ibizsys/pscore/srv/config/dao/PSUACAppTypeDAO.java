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
import net.ibizsys.pscore.srv.config.demodel.PSUACAppTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSUACAppType;
import org.springframework.stereotype.Repository;

@Repository
public class PSUACAppTypeDAO
extends PSCoreSysDAOBase<PSUACAppType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUACAppTypeDEModel pSUACAppTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSUACAppTypeDAO";
    }

    public PSUACAppTypeDEModel getPSUACAppTypeDEModel() {
        if (this.pSUACAppTypeDEModel == null) {
            try {
                this.pSUACAppTypeDEModel = (PSUACAppTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSUACAppTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUACAppTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUACAppTypeDEModel();
    }
}

