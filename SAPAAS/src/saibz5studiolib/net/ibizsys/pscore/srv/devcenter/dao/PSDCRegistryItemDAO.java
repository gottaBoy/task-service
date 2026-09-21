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
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryItemDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import org.springframework.stereotype.Repository;

@Repository
public class PSDCRegistryItemDAO
extends PSCoreSysDAOBase<PSDCRegistryItem> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CODESERVER = "CodeServer";
    public static final String DATAQUERY_CURDC = "CurDC";
    public static final String DATAQUERY_CURDC2 = "CurDC2";
    public static final String DATAQUERY_CURDCAPI = "CurDCAPI";
    public static final String DATAQUERY_CURDCAPI2 = "CurDCAPI2";
    public static final String DATAQUERY_CURDCAPP = "CurDCApp";
    public static final String DATAQUERY_CURDCAPP2 = "CurDCApp2";
    public static final String DATAQUERY_CURDCCODESERVER = "CurDCCodeServer";
    public static final String DATAQUERY_CURDCCODESERVER2 = "CurDCCodeServer2";
    public static final String DATAQUERY_CURDCGENERATOR = "CurDCGenerator";
    public static final String DATAQUERY_CURDCGENERATOR2 = "CurDCGenerator2";
    public static final String DATAQUERY_CURDCRUNNER = "CurDCRunner";
    public static final String DATAQUERY_CURDCRUNNER2 = "CurDCRunner2";
    public static final String DATAQUERY_CURREPO = "CurRepo";
    public static final String DATAQUERY_CURSLN = "CurSln";
    public static final String DATAQUERY_CURSLNGENERATOR = "CurSlnGenerator";
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSAPI = "CurSysAPI";
    public static final String DATAQUERY_CURSYSAPP = "CurSysApp";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_GENERATOR = "Generator";
    public static final String DATAQUERY_RUNNER = "Runner";
    public static final String DATAQUERY_TOOL = "Tool";
    private PSDCRegistryItemDEModel pSDCRegistryItemDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.devcenter.dao.PSDCRegistryItemDAO";
    }

    public PSDCRegistryItemDEModel getPSDCRegistryItemDEModel() {
        if (this.pSDCRegistryItemDEModel == null) {
            try {
                this.pSDCRegistryItemDEModel = (PSDCRegistryItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryItemDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSDCRegistryItemDEModel();
    }
}

