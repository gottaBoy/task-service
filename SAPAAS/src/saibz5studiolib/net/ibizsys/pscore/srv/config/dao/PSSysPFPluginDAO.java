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
import net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import org.springframework.stereotype.Repository;

@Repository
public class PSSysPFPluginDAO
extends PSCoreSysDAOBase<PSSysPFPlugin> {
    private static final long serialVersionUID = -1L;
    public static final String DATAQUERY_CURSYS = "CurSys";
    public static final String DATAQUERY_CURSYSACI = "CurSysACI";
    public static final String DATAQUERY_CURSYSAPPCOUNTER = "CurSysAppCounter";
    public static final String DATAQUERY_CURSYSAPPMENU = "CurSysAppMenu";
    public static final String DATAQUERY_CURSYSAPPMENUITEM = "CurSysAppMenuItem";
    public static final String DATAQUERY_CURSYSAPPUILOGIC = "CurSysAppUILogic";
    public static final String DATAQUERY_CURSYSAPPUTIL = "CurSysAppUtil";
    public static final String DATAQUERY_CURSYSAPPVALUERULE = "CurSysAppValueRule";
    public static final String DATAQUERY_CURSYSCDV = "CurSysCDV";
    public static final String DATAQUERY_CURSYSCALENDAR = "CurSysCalendar";
    public static final String DATAQUERY_CURSYSCALENDARITEM = "CurSysCalendarItem";
    public static final String DATAQUERY_CURSYSCHARTAXIS = "CurSysChartAxis";
    public static final String DATAQUERY_CURSYSCHARTCS = "CurSysChartCS";
    public static final String DATAQUERY_CURSYSCHARTSERIES = "CurSysChartSeries";
    public static final String DATAQUERY_CURSYSCUSTOM = "CurSysCustom";
    public static final String DATAQUERY_CURSYSDCR = "CurSysDCR";
    public static final String DATAQUERY_CURSYSDEDATAEXPORT = "CurSysDEDataExport";
    public static final String DATAQUERY_CURSYSDEDATAIMPORT = "CurSysDEDataImport";
    public static final String DATAQUERY_CURSYSDEFVALUERULE = "CurSysDEFValueRule";
    public static final String DATAQUERY_CURSYSDEMETHOD = "CurSysDEMethod";
    public static final String DATAQUERY_CURSYSDEUIACTION = "CurSysDEUIAction";
    public static final String DATAQUERY_CURSYSDLR = "CurSysDLR";
    public static final String DATAQUERY_CURSYSDVI = "CurSysDVI";
    public static final String DATAQUERY_CURSYSDASHBOARD = "CurSysDashboard";
    public static final String DATAQUERY_CURSYSDASHBOARDPART = "CurSysDashboardPart";
    public static final String DATAQUERY_CURSYSDATAVIEW = "CurSysDataView";
    public static final String DATAQUERY_CURSYSECS = "CurSysECS";
    public static final String DATAQUERY_CURSYSEF = "CurSysEF";
    public static final String DATAQUERY_CURSYSFUC = "CurSysFUC";
    public static final String DATAQUERY_CURSYSGCR = "CurSysGCR";
    public static final String DATAQUERY_CURSYSGRID = "CurSysGrid";
    public static final String DATAQUERY_CURSYSLIR = "CurSysLIR";
    public static final String DATAQUERY_CURSYSMAPVIEW = "CurSysMapView";
    public static final String DATAQUERY_CURSYSMAPVIEWITEM = "CurSysMapViewItem";
    public static final String DATAQUERY_CURSYSPC = "CurSysPC";
    public static final String DATAQUERY_CURSYSPTB = "CurSysPTB";
    public static final String DATAQUERY_CURSYSPANEL = "CurSysPanel";
    public static final String DATAQUERY_CURSYSPANELITEM = "CurSysPanelItem";
    public static final String DATAQUERY_CURSYSSB = "CurSysSB";
    public static final String DATAQUERY_CURSYSSBI = "CurSysSBI";
    public static final String DATAQUERY_CURSYSSF = "CurSysSF";
    public static final String DATAQUERY_CURSYSTB = "CurSysTB";
    public static final String DATAQUERY_CURSYSTBI = "CurSysTBI";
    public static final String DATAQUERY_CURSYSTITLEBAR = "CurSysTitleBar";
    public static final String DATAQUERY_CURSYSTREE = "CurSysTree";
    public static final String DATAQUERY_CURSYSTREEEXPBAR = "CurSysTreeExpBar";
    public static final String DATAQUERY_CURSYSUE = "CurSysUE";
    public static final String DATAQUERY_CURSYSULN = "CurSysULN";
    public static final String DATAQUERY_CURSYSWITHICON = "CurSysWithIcon";
    public static final String DATAQUERY_CURSYSWIZARDPANEL = "CurSysWizardPanel";
    public static final String DATAQUERY_DEFAULT = "DEFAULT";
    private PSSysPFPluginDEModel pSSysPFPluginDEModel;

    @PostConstruct
    public void postConstruct() throws Exception {
        DAOGlobal.registerDAO((String)this.getDAOId(), (IDAO)this);
    }

    protected String getDAOId() {
        return "net.ibizsys.pscore.srv.config.dao.PSSysPFPluginDAO";
    }

    public PSSysPFPluginDEModel getPSSysPFPluginDEModel() {
        if (this.pSSysPFPluginDEModel == null) {
            try {
                this.pSSysPFPluginDEModel = (PSSysPFPluginDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSysPFPluginDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysPFPluginDEModel;
    }

    public IDataEntityModel getDEModel() {
        return this.getPSSysPFPluginDEModel();
    }
}

