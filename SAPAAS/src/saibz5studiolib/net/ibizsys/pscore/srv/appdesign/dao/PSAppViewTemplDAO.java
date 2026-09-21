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
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewTemplDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewTempl;
import org.springframework.stereotype.Repository;

@Repository
public class PSAppViewTemplDAO
extends PSCoreSysDAOBase<PSAppViewTempl> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAppViewTemplDEModel pSAppViewTemplDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.appdesign.dao.PSAppViewTemplDAO";
    }

    public PSAppViewTemplDEModel getPSAppViewTemplDEModel() {
        if (this.pSAppViewTemplDEModel == null) {
            try {
                this.pSAppViewTemplDEModel = (PSAppViewTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewTemplDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAppViewTemplDEModel();
    }
}

