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
import net.ibizsys.pscore.srv.def.demodel.PSASTypeDEModel;
import net.ibizsys.pscore.srv.def.entity.PSASType;
import org.springframework.stereotype.Repository;

@Repository
public class PSASTypeDAO
extends PSCoreSysDAOBase<PSASType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSASTypeDEModel pSASTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSASTypeDAO";
    }

    public PSASTypeDEModel getPSASTypeDEModel() {
        if (this.pSASTypeDEModel == null) {
            try {
                this.pSASTypeDEModel = (PSASTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSASTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSASTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSASTypeDEModel();
    }
}

