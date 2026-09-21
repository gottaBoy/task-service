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
package net.ibizsys.pscore.srv.dedesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFGridColDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGridCol;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFGridColDAO
extends PSCoreSysDAOBase<PSDEFGridCol> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEFGridColDEModel pSDEFGridColDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFGridColDAO";
    }

    public PSDEFGridColDEModel getPSDEFGridColDEModel() {
        if (this.pSDEFGridColDEModel == null) {
            try {
                this.pSDEFGridColDEModel = (PSDEFGridColDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFGridColDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFGridColDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFGridColDEModel();
    }
}

