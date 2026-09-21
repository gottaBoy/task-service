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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCAbilityDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCAbility;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCAbilityDAO
extends PSCoreSysDAOBase<PSDCAbility> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCAbilityDEModel pSDCAbilityDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCAbilityDAO";
    }

    public PSDCAbilityDEModel getPSDCAbilityDEModel() {
        if (this.pSDCAbilityDEModel == null) {
            try {
                this.pSDCAbilityDEModel = (PSDCAbilityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCAbilityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCAbilityDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCAbilityDEModel();
    }
}

