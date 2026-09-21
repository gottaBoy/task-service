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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEACModeDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEACModeDAO
extends PSCoreSysDAOBase<PSDEACMode> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEACModeDEModel pSDEACModeDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEACModeDAO";
    }

    public PSDEACModeDEModel getPSDEACModeDEModel() {
        if (this.pSDEACModeDEModel == null) {
            try {
                this.pSDEACModeDEModel = (PSDEACModeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEACModeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEACModeDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEACModeDEModel();
    }
}

