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
package net.ibizsys.pscore.srv.def.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.def.demodel.PSFormDetailTypeDEModel;
import net.ibizsys.pscore.srv.def.entity.PSFormDetailType;
import org.springframework.stereotype.Repository;

@Repository
public class PSFormDetailTypeDAO
extends PSCoreSysDAOBase<PSFormDetailType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSFormDetailTypeDEModel pSFormDetailTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSFormDetailTypeDAO";
    }

    public PSFormDetailTypeDEModel getPSFormDetailTypeDEModel() {
        if (this.pSFormDetailTypeDEModel == null) {
            try {
                this.pSFormDetailTypeDEModel = (PSFormDetailTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSFormDetailTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSFormDetailTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSFormDetailTypeDEModel();
    }
}

