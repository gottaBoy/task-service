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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import org.springframework.stereotype.Repository;

@Repository
public class PSDEFieldDAO
extends PSCoreSysDAOBase<PSDEField> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDE = "CurDE";
    public static final String DATAQUERY_CURDERMAJORDE = "CurDERMajorDE";
    public static final String DATAQUERY_CURDERMINORDE = "CurDERMinorDE";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_KEY = "Key";
    public static final String DATAQUERY_KEYEX = "KeyEx";
    private PSDEFieldDEModel pSDEFieldDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDEFieldDAO";
    }

    public PSDEFieldDEModel getPSDEFieldDEModel() {
        if (this.pSDEFieldDEModel == null) {
            try {
                this.pSDEFieldDEModel = (PSDEFieldDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFieldDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFieldDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDEFieldDEModel();
    }
}

