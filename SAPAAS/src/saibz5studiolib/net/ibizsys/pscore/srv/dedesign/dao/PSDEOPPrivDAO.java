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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEOPPrivDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEOPPrivDAO
extends PSCoreSysDAOBase<PSDEOPPriv> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYSANDDE = "CurSysAndDE";
    public static final String DATAQUERY_CURSYSDE = "CurSysDE";
    public static final String DATAQUERY_CURSYSNOTDE = "CurSysNotDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEOPPrivDEModel pSDEOPPrivDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEOPPrivDAO";
    }

    public PSDEOPPrivDEModel getPSDEOPPrivDEModel() {
        if (this.pSDEOPPrivDEModel == null) {
            try {
                this.pSDEOPPrivDEModel = (PSDEOPPrivDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEOPPrivDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEOPPrivDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEOPPrivDEModel();
    }
}

