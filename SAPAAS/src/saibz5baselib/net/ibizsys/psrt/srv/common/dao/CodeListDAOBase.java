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
import net.ibizsys.psrt.srv.common.demodel.CodeListDEModel;
import net.ibizsys.psrt.srv.common.entity.CodeList;

public abstract class CodeListDAOBase
extends PSRuntimeSysDAOBase<CodeList> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private CodeListDEModel codeListDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.CodeListDAO";
    }

    public CodeListDEModel getCodeListDEModel() {
        if (this.codeListDEModel == null) {
            try {
                this.codeListDEModel = (CodeListDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.CodeListDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.codeListDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getCodeListDEModel();
    }
}

