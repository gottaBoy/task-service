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
package net.ibizsys.pscore.srv.appdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.appdesign.demodel.PSModelPFCodeDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSModelPFCode;
import org.springframework.stereotype.Repository;

@Repository
public class PSModelPFCodeDAO
extends PSCoreSysDAOBase<PSModelPFCode> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSModelPFCodeDEModel pSModelPFCodeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSModelPFCodeDAO";
    }

    public PSModelPFCodeDEModel getPSModelPFCodeDEModel() {
        if (this.pSModelPFCodeDEModel == null) {
            try {
                this.pSModelPFCodeDEModel = (PSModelPFCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSModelPFCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelPFCodeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSModelPFCodeDEModel();
    }
}

