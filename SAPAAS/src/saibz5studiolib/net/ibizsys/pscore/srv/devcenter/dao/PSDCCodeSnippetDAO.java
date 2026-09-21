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
package net.ibizsys.pscore.srv.devcenter.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCCodeSnippetDAO
extends PSCoreSysDAOBase<PSDCCodeSnippet> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_ALLDC = "AllDC";
    public static final String DATAQUERY_ALLDCAPP = "AllDCApp";
    public static final String DATAQUERY_ALLDCCL = "AllDCCL";
    public static final String DATAQUERY_ALLDCDB = "AllDCDB";
    public static final String DATAQUERY_ALLDCDE = "AllDCDE";
    public static final String DATAQUERY_ALLDCDEACTION = "AllDCDEAction";
    public static final String DATAQUERY_ALLDCNONE = "AllDCNone";
    public static final String DATAQUERY_ALLDCSYS = "AllDCSys";
    public static final String DATAQUERY_ALLDCVIEW = "AllDCView";
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURDCAPP = "CurDCApp";
    public static final String DATAQUERY_CURDCCL = "CurDCCL";
    public static final String DATAQUERY_CURDCDB = "CurDCDB";
    public static final String DATAQUERY_CURDCDE = "CurDCDE";
    public static final String DATAQUERY_CURDCDEACTION = "CurDCDEAction";
    public static final String DATAQUERY_CURDCNONE = "CurDCNone";
    public static final String DATAQUERY_CURDCSYS = "CurDCSys";
    public static final String DATAQUERY_CURDCVIEW = "CurDCView";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSDCCodeSnippetDEModel pSDCCodeSnippetDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCCodeSnippetDAO";
    }

    public PSDCCodeSnippetDEModel getPSDCCodeSnippetDEModel() {
        if (this.pSDCCodeSnippetDEModel == null) {
            try {
                this.pSDCCodeSnippetDEModel = (PSDCCodeSnippetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCodeSnippetDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCCodeSnippetDEModel();
    }
}

