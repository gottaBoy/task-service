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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import org.springframework.stereotype.Repository;

@Repository
public class PSDERDAO
extends PSCoreSysDAOBase<PSDER> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURDEDER11 = "CurDEDER11";
    public static final String DATAQUERY_CURDEDER1N = "CurDEDER1N";
    public static final String DATAQUERY_CURDEDER1N2 = "CurDEDER1N2";
    public static final String DATAQUERY_CURDEDERCUSTOM = "CurDEDERCustom";
    public static final String DATAQUERY_CURDEMAJOR = "CurDEMajor";
    public static final String DATAQUERY_CURDEMAJOR2 = "CurDEMajor2";
    public static final String DATAQUERY_CURDEMAJORAGGDATA = "CurDEMajorAggData";
    public static final String DATAQUERY_CURDEMINOR = "CurDEMinor";
    public static final String DATAQUERY_CURDEMINOR2 = "CurDEMinor2";
    public static final String DATAQUERY_CURSYSDER = "CurSysDER";
    public static final String DATAQUERY_CURSYSDER1N = "CurSysDER1N";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_MAJORMINORDER1N = "MajorMinorDER1N";
    public static final String DATAQUERY_X1N = "X1N";
    private PSDERDEModel pSDERDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.dedesign.dao.PSDERDAO";
    }

    public PSDERDEModel getPSDERDEModel() {
        if (this.pSDERDEModel == null) {
            try {
                this.pSDERDEModel = (PSDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDERDEModel();
    }
}

