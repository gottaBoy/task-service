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
import net.ibizsys.pscore.srv.config.demodel.PSVTStyleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSVTStyle;
import org.springframework.stereotype.Repository;

@Repository
public class PSVTStyleDAO
extends PSCoreSysDAOBase<PSVTStyle> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSVTStyleDEModel pSVTStyleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSVTStyleDAO";
    }

    public PSVTStyleDEModel getPSVTStyleDEModel() {
        if (this.pSVTStyleDEModel == null) {
            try {
                this.pSVTStyleDEModel = (PSVTStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSVTStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTStyleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSVTStyleDEModel();
    }
}

