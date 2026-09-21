/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 */
package net.ibizsys.psrt.srv.common.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.psrt.srv.PSRuntimeSysDAOBase;
import net.ibizsys.psrt.srv.common.demodel.MsgTemplateDEModel;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

public abstract class MsgTemplateDAOBase
extends PSRuntimeSysDAOBase<MsgTemplate> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private MsgTemplateDEModel msgTemplateDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.MsgTemplateDAO";
    }

    public MsgTemplateDEModel getMsgTemplateDEModel() {
        if (this.msgTemplateDEModel == null) {
            try {
                this.msgTemplateDEModel = (MsgTemplateDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgTemplateDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.msgTemplateDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getMsgTemplateDEModel();
    }
}

