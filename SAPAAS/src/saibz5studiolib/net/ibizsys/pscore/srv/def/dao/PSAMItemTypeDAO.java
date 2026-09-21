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
import net.ibizsys.pscore.srv.def.demodel.PSAMItemTypeDEModel;
import net.ibizsys.pscore.srv.def.entity.PSAMItemType;
import org.springframework.stereotype.Repository;

@Repository
public class PSAMItemTypeDAO
extends PSCoreSysDAOBase<PSAMItemType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSAMItemTypeDEModel pSAMItemTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSAMItemTypeDAO";
    }

    public PSAMItemTypeDEModel getPSAMItemTypeDEModel() {
        if (this.pSAMItemTypeDEModel == null) {
            try {
                this.pSAMItemTypeDEModel = (PSAMItemTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSAMItemTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAMItemTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSAMItemTypeDEModel();
    }
}

