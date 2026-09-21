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
package net.ibizsys.pscore.srv.paasmgr.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSRobotDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSRobot;
import org.springframework.stereotype.Repository;

@Repository
public class PSRobotDAO
extends PSCoreSysDAOBase<PSRobot> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSRobotDEModel pSRobotDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.paasmgr.dao.PSRobotDAO";
    }

    public PSRobotDEModel getPSRobotDEModel() {
        if (this.pSRobotDEModel == null) {
            try {
                this.pSRobotDEModel = (PSRobotDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSRobotDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRobotDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSRobotDEModel();
    }
}

