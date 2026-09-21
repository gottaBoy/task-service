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
package net.ibizsys.pscore.srv.sysdesign.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDERGroupDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import org.springframework.stereotype.Repository;

@Repository
public class PSDERGroupDAO
extends PSCoreSysDAOBase<PSDERGroup> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYS2 = "CurSys2";
    public static final String DATAQUERY_CURSYSALL = "CurSysAll";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDERGroupDEModel pSDERGroupDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSDERGroupDAO";
    }

    public PSDERGroupDEModel getPSDERGroupDEModel() {
        if (this.pSDERGroupDEModel == null) {
            try {
                this.pSDERGroupDEModel = (PSDERGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDERGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERGroupDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDERGroupDEModel();
    }
}

