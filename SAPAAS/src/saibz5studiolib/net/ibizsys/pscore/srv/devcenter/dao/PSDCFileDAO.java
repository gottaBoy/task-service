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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCFileDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCFileDAO
extends PSCoreSysDAOBase<PSDCFile> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCFileDEModel pSDCFileDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCFileDAO";
    }

    public PSDCFileDEModel getPSDCFileDEModel() {
        if (this.pSDCFileDEModel == null) {
            try {
                this.pSDCFileDEModel = (PSDCFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCFileDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCFileDEModel();
    }
}

