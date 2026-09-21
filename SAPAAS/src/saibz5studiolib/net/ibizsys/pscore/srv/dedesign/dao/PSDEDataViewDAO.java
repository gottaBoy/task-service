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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataViewDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEDataViewDAO
extends PSCoreSysDAOBase<PSDEDataView> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURAPPKANBAN = "CurAppKanban";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDEKANBAN = "CurDEKanban";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSKANBAN = "CurSysKanban";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEDataViewDEModel pSDEDataViewDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEDataViewDAO";
    }

    public PSDEDataViewDEModel getPSDEDataViewDEModel() {
        if (this.pSDEDataViewDEModel == null) {
            try {
                this.pSDEDataViewDEModel = (PSDEDataViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataViewDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEDataViewDEModel();
    }
}

