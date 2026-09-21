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
import net.ibizsys.pscore.srv.config.demodel.PSUILogicTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSUILogicType;
import org.springframework.stereotype.Repository;

@Repository
public class PSUILogicTypeDAO
extends PSCoreSysDAOBase<PSUILogicType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSUILogicTypeDEModel pSUILogicTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSUILogicTypeDAO";
    }

    public PSUILogicTypeDEModel getPSUILogicTypeDEModel() {
        if (this.pSUILogicTypeDEModel == null) {
            try {
                this.pSUILogicTypeDEModel = (PSUILogicTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSUILogicTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUILogicTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSUILogicTypeDEModel();
    }
}

