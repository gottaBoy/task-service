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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEToolbarDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEToolbarDAO
extends PSCoreSysDAOBase<PSDEToolbar> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYSTEMPL = "CurSysTempl";
    public static final String DATAQUERY_DERANGE = "DERange";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_SYSRANGE = "SysRange";
    private PSDEToolbarDEModel pSDEToolbarDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEToolbarDAO";
    }

    public PSDEToolbarDEModel getPSDEToolbarDEModel() {
        if (this.pSDEToolbarDEModel == null) {
            try {
                this.pSDEToolbarDEModel = (PSDEToolbarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEToolbarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEToolbarDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEToolbarDEModel();
    }
}

