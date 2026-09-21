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
import net.ibizsys.pscore.srv.def.demodel.PSDEFVRCodeTypeDEModel;
import net.ibizsys.pscore.srv.def.entity.PSDEFVRCodeType;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFVRCodeTypeDAO
extends PSCoreSysDAOBase<PSDEFVRCodeType> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEFVRCodeTypeDEModel pSDEFVRCodeTypeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.def.dao.PSDEFVRCodeTypeDAO";
    }

    public PSDEFVRCodeTypeDEModel getPSDEFVRCodeTypeDEModel() {
        if (this.pSDEFVRCodeTypeDEModel == null) {
            try {
                this.pSDEFVRCodeTypeDEModel = (PSDEFVRCodeTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSDEFVRCodeTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFVRCodeTypeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFVRCodeTypeDEModel();
    }
}

