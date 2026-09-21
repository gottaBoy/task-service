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
import net.ibizsys.pscore.srv.config.demodel.PSPFViewTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFViewType;
import org.springframework.stereotype.Repository;

@Repository
public class PSPFViewTypeDAO
extends PSCoreSysDAOBase<PSPFViewType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSPFViewTypeDEModel pSPFViewTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSPFViewTypeDAO";
    }

    public PSPFViewTypeDEModel getPSPFViewTypeDEModel() {
        if (this.pSPFViewTypeDEModel == null) {
            try {
                this.pSPFViewTypeDEModel = (PSPFViewTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFViewTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFViewTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSPFViewTypeDEModel();
    }
}

