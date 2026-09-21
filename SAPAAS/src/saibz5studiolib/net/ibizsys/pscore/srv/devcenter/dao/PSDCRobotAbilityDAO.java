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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotAbilityDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotAbility;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCRobotAbilityDAO
extends PSCoreSysDAOBase<PSDCRobotAbility> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCRobotAbilityDEModel pSDCRobotAbilityDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotAbilityDAO";
    }

    public PSDCRobotAbilityDEModel getPSDCRobotAbilityDEModel() {
        if (this.pSDCRobotAbilityDEModel == null) {
            try {
                this.pSDCRobotAbilityDEModel = (PSDCRobotAbilityDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotAbilityDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotAbilityDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCRobotAbilityDEModel();
    }
}

