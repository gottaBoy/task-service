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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEUAGroupDAO
extends PSCoreSysDAOBase<PSDEUAGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSDE = "CurSysDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEUAGroupDEModel pSDEUAGroupDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEUAGroupDAO";
    }

    public PSDEUAGroupDEModel getPSDEUAGroupDEModel() {
        if (this.pSDEUAGroupDEModel == null) {
            try {
                this.pSDEUAGroupDEModel = (PSDEUAGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEUAGroupDEModel();
    }
}

