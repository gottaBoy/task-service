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
package net.ibizsys.pscore.srv.config.dao;

import javax.annotation.PostConstruct;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pscore.srv.PSCoreSysDAOBase;
import net.ibizsys.pscore.srv.config.demodel.PSVarSampleValueDEModel;
import net.ibizsys.pscore.srv.config.entity.PSVarSampleValue;
import org.springframework.stereotype.Repository;

@Repository
public class PSVarSampleValueDAO
extends PSCoreSysDAOBase<PSVarSampleValue> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_DATAVIEWITEM = "DataViewItem";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    public static final String DATAQUERY_FONTFAMILY = "FontFamily";
    public static final String DATAQUERY_FONTSIZE = "FontSize";
    public static final String DATAQUERY_FORMITEM = "FormItem";
    public static final String DATAQUERY_FORMVAR = "FormVar";
    public static final String DATAQUERY_GRIDITEM = "GridItem";
    public static final String DATAQUERY_LAYOUTTABLE = "LayoutTable";
    public static final String DATAQUERY_SYSVAR = "SysVar";
    public static final String DATAQUERY_VIEWFIELD = "ViewField";
    private PSVarSampleValueDEModel pSVarSampleValueDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSVarSampleValueDAO";
    }

    public PSVarSampleValueDEModel getPSVarSampleValueDEModel() {
        if (this.pSVarSampleValueDEModel == null) {
            try {
                this.pSVarSampleValueDEModel = (PSVarSampleValueDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSVarSampleValueDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVarSampleValueDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSVarSampleValueDEModel();
    }
}

