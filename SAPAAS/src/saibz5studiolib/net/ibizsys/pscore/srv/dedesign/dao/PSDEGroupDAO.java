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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEGroupDAO
extends PSCoreSysDAOBase<PSDEGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYS2 = "CurSys2";
    public static final String DATAQUERY_CURSYSALL = "CurSysAll";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEGroupDEModel pSDEGroupDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEGroupDAO";
    }

    public PSDEGroupDEModel getPSDEGroupDEModel() {
        if (this.pSDEGroupDEModel == null) {
            try {
                this.pSDEGroupDEModel = (PSDEGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEGroupDEModel();
    }
}

