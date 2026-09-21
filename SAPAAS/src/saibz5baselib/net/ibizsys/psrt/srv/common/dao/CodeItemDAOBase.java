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
import net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel;
import net.ibizsys.psrt.srv.common.entity.CodeItem;

public abstract class CodeItemDAOBase
extends PSRuntimeSysDAOBase<CodeItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURCL = "CurCL";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private CodeItemDEModel codeItemDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.CodeItemDAO";
    }

    public CodeItemDEModel getCodeItemDEModel() {
        if (this.codeItemDEModel == null) {
            try {
                this.codeItemDEModel = (CodeItemDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.codeItemDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getCodeItemDEModel();
    }
}

