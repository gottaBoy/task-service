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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import org.springframework.stereotype.Repository;

@Repository
public class PSDELogicDAO
extends PSCoreSysDAOBase<PSDELogic> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDEDF = "CurDEDF";
    public static final String DATAQUERY_CURDEMS = "CurDEMS";
    public static final String DATAQUERY_CURDEUL = "CurDEUL";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURMODDF = "CurModDF";
    public static final String DATAQUERY_CURMODMS = "CurModMS";
    public static final String DATAQUERY_CURMODNOTDEUL = "CurModNotDEUL";
    public static final String DATAQUERY_CURMODUL = "CurModUL";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSDF = "CurSysDF";
    public static final String DATAQUERY_CURSYSMS = "CurSysMS";
    public static final String DATAQUERY_CURSYSNOTDEUL = "CurSysNotDEUL";
    public static final String DATAQUERY_CURSYSUL = "CurSysUL";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_UL = "UL";
    private PSDELogicDEModel pSDELogicDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDELogicDAO";
    }

    public PSDELogicDEModel getPSDELogicDEModel() {
        if (this.pSDELogicDEModel == null) {
            try {
                this.pSDELogicDEModel = (PSDELogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDELogicDEModel();
    }
}

