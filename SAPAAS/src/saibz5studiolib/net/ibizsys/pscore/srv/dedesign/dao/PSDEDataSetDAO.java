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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSetDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEDataSetDAO
extends PSCoreSysDAOBase<PSDEDataSet> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSNOTSUB = "CurSysNotSub";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDEDataSetDEModel pSDEDataSetDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEDataSetDAO";
    }

    public PSDEDataSetDEModel getPSDEDataSetDEModel() {
        if (this.pSDEDataSetDEModel == null) {
            try {
                this.pSDEDataSetDEModel = (PSDEDataSetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSetDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEDataSetDEModel();
    }
}

