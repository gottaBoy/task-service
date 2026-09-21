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
import net.ibizsys.pscore.srv.config.demodel.PSModelAPIMethodDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModelAPIMethod;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelAPIMethodDAO
extends PSCoreSysDAOBase<PSModelAPIMethod> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelAPIMethodDEModel pSModelAPIMethodDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSModelAPIMethodDAO";
    }

    public PSModelAPIMethodDEModel getPSModelAPIMethodDEModel() {
        if (this.pSModelAPIMethodDEModel == null) {
            try {
                this.pSModelAPIMethodDEModel = (PSModelAPIMethodDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelAPIMethodDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelAPIMethodDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelAPIMethodDEModel();
    }
}

