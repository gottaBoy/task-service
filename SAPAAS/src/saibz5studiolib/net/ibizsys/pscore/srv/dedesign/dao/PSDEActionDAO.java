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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEActionDAO
extends PSCoreSysDAOBase<PSDEAction> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSNOTBUILTIN = "CurSysNotBuiltin";
    public static final String DATAQUERY_CURSYSNOTSUBSYS = "CurSysNotSubSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEActionDEModel pSDEActionDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEActionDAO";
    }

    public PSDEActionDEModel getPSDEActionDEModel() {
        if (this.pSDEActionDEModel == null) {
            try {
                this.pSDEActionDEModel = (PSDEActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEActionDEModel();
    }
}

