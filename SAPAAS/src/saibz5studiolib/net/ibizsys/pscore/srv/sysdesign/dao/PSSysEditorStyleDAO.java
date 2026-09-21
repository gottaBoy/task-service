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
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysEditorStyleDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysEditorStyleDAO
extends PSCoreSysDAOBase<PSSysEditorStyle> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSWITHICON = "CurSysWithIcon";
    public static final String DATAQUERY_DESCOPE = "DEScope";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysEditorStyleDEModel pSSysEditorStyleDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.sysdesign.dao.PSSysEditorStyleDAO";
    }

    public PSSysEditorStyleDEModel getPSSysEditorStyleDEModel() {
        if (this.pSSysEditorStyleDEModel == null) {
            try {
                this.pSSysEditorStyleDEModel = (PSSysEditorStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysEditorStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEditorStyleDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysEditorStyleDEModel();
    }
}

