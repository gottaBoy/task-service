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
import net.ibizsys.psrt.srv.common.demodel.FileDEModel;
import net.ibizsys.psrt.srv.common.entity.File;

public abstract class FileDAOBase
extends PSRuntimeSysDAOBase<File> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private FileDEModel fileDEModel;

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO(this.getDAOId(), this);
    }

    @Override
    protected String getDAOId() {
        return "net.ibizsys.psrt.srv.common.dao.FileDAO";
    }

    public FileDEModel getFileDEModel() {
        if (this.fileDEModel == null) {
            try {
                this.fileDEModel = (FileDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.FileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.fileDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getFileDEModel();
    }
}

