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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCounterDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysCounterDAO
extends PSCoreSysDAOBase<PSSysCounter> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSNOTDE = "CurSysNotDE";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysCounterDEModel pSSysCounterDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysCounterDAO";
    }

    public PSSysCounterDEModel getPSSysCounterDEModel() {
        if (this.pSSysCounterDEModel == null) {
            try {
                this.pSSysCounterDEModel = (PSSysCounterDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCounterDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCounterDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysCounterDEModel();
    }
}

