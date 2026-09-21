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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCBKTaskDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCBKTaskDAO
extends PSCoreSysDAOBase<PSDCBKTask> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURRUN = "CurRun";
    public static final String DATAQUERY_CURSLNFINISH = "CurSlnFinish";
    public static final String DATAQUERY_CURSLNRUN = "CurSlnRun";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_FINISH = "Finish";
    private PSDCBKTaskDEModel pSDCBKTaskDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCBKTaskDAO";
    }

    public PSDCBKTaskDEModel getPSDCBKTaskDEModel() {
        if (this.pSDCBKTaskDEModel == null) {
            try {
                this.pSDCBKTaskDEModel = (PSDCBKTaskDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCBKTaskDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCBKTaskDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCBKTaskDEModel();
    }
}

