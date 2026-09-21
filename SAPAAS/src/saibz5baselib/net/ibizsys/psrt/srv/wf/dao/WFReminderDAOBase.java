/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.wf.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel;
import net.ibizsys.psrt.srv.wf.entity.WFReminder;

public abstract class WFReminderDAOBase
extends PSRuntimeSysDAOBase<WFReminder> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private WFReminderDEModel wFReminderDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.wf.dao.WFReminderDAO";
    }

    public WFReminderDEModel getWFReminderDEModel() {
        if (this.wFReminderDEModel == null) {
            try {
                this.wFReminderDEModel = (WFReminderDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFReminderDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getWFReminderDEModel();
    }
}

