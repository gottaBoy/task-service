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
package net.ibizsys.pscore.srv.dynasys.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaSysDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import org.springframework.stereotype.Repository;

@Repository
public class PSDynaSysDAO
extends PSCoreSysDAOBase<PSDynaSys> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDynaSysDEModel pSDynaSysDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dynasys.dao.PSDynaSysDAO";
    }

    public PSDynaSysDEModel getPSDynaSysDEModel() {
        if (this.pSDynaSysDEModel == null) {
            try {
                this.pSDynaSysDEModel = (PSDynaSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaSysDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDynaSysDEModel();
    }
}

