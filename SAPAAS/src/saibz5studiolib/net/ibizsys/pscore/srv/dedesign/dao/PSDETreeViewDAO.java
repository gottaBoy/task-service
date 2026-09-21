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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeViewDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import org.springframework.stereotype.Repository;

@Repository
public class PSDETreeViewDAO
extends PSCoreSysDAOBase<PSDETreeView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURAPPGANTT = "CurAppGantt";
    public static final String DATAQUERY_CURAPPGRID = "CurAppGrid";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDEGANTT = "CurDEGantt";
    public static final String DATAQUERY_CURDEGRID = "CurDEGrid";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSGANTT = "CurSysGantt";
    public static final String DATAQUERY_CURSYSGRID = "CurSysGrid";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDETreeViewDEModel pSDETreeViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDETreeViewDAO";
    }

    public PSDETreeViewDEModel getPSDETreeViewDEModel() {
        if (this.pSDETreeViewDEModel == null) {
            try {
                this.pSDETreeViewDEModel = (PSDETreeViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDETreeViewDEModel();
    }
}

