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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCRobotDAO
extends PSCoreSysDAOBase<PSDCRobot> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCRobotDEModel pSDCRobotDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotDAO";
    }

    public PSDCRobotDEModel getPSDCRobotDEModel() {
        if (this.pSDCRobotDEModel == null) {
            try {
                this.pSDCRobotDEModel = (PSDCRobotDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCRobotDEModel();
    }
}

