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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEViewBaseDAO
extends PSCoreSysDAOBase<PSDEViewBase> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_BYTYPE = "ByType";
    public static final String DATAQUERY_CURAPP = "CurApp";
    public static final String DATAQUERY_CURAPPADD = "CurAppAdd";
    public static final String DATAQUERY_CURAPPNOTADD = "CurAppNotAdd";
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDE2 = "CurDE2";
    public static final String DATAQUERY_CURDEMOB = "CurDEMob";
    public static final String DATAQUERY_CURDEWEB = "CurDEWeb";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURWF2 = "CurWF2";
    public static final String DATAQUERY_CURWFVER = "CurWFVer";
    public static final String DATAQUERY_DEPDT = "DEPDT";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_MOB = "Mob";
    public static final String DATAQUERY_PDTCNT = "PDTCNT";
    public static final String DATAQUERY_PDTCNT2 = "PDTCNT2";
    public static final String DATAQUERY_WF = "WF";
    public static final String DATAQUERY_WEB = "Web";
    private PSDEViewBaseDEModel pSDEViewBaseDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEViewBaseDAO";
    }

    public PSDEViewBaseDEModel getPSDEViewBaseDEModel() {
        if (this.pSDEViewBaseDEModel == null) {
            try {
                this.pSDEViewBaseDEModel = (PSDEViewBaseDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewBaseDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEViewBaseDEModel();
    }
}

