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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFormDAO
extends PSCoreSysDAOBase<PSDEForm> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_COUNTCODENAME = "CountCodeName";
    public static final String DATAQUERY_CURAPPEDITMODE = "CurAppEditMode";
    public static final String DATAQUERY_CURAPPSEARCHMODE = "CurAppSearchMode";
    public static final String DATAQUERY_CURDEEDITMODE = "CurDEEditMode";
    public static final String DATAQUERY_CURDESEARCHMODE = "CurDESearchMode";
    public static final String DATAQUERY_CURDEWIZARDMODE = "CurDEWizardMode";
    public static final String DATAQUERY_CURMOD = "CurMod";
    public static final String DATAQUERY_CURSYSEDITMODE = "CurSysEditMode";
    public static final String DATAQUERY_CURSYSSEARCHMODE = "CurSysSearchMode";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_EDITMODE = "EditMode";
    public static final String DATAQUERY_SEARCHMODE = "SearchMode";
    private PSDEFormDEModel pSDEFormDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFormDAO";
    }

    public PSDEFormDEModel getPSDEFormDEModel() {
        if (this.pSDEFormDEModel == null) {
            try {
                this.pSDEFormDEModel = (PSDEFormDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFormDEModel();
    }
}

