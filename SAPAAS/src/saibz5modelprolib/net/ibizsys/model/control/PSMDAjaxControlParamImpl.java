/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.IPSMDAjaxControlParam
 *  net.ibizsys.model.dataentity.dataexport.IPSDEDataExport
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSMDAjaxControlParam;
import net.ibizsys.model.control.PSAjaxControlParamImpl;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMDAjaxControlParamImpl
extends PSAjaxControlParamImpl
implements IPSMDAjaxControlParam {
    private static final Log log = LogFactory.getLog(PSMDAjaxControlParamImpl.class);
    protected String strPSDEDataSetId = "";
    protected String strPSDEDataExportId = "";
    protected String strActiveDataPSDELogicId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEDataSetId(this.getPSDEViewCtrlData().getPSDEDATASETID());
        this.setPSDEDataExportId(this.getPSDEViewCtrlData().getPSDEDATAEXPID());
        this.setActiveDataPSDELogicId(this.getPSDEViewCtrlData().getADPSDELOGICID());
    }

    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    public void setPSDEDataSetId(String strPSDEDataSetId) {
        this.strPSDEDataSetId = strPSDEDataSetId;
    }

    public String getDEDataSetId() {
        return this.getPSDEDataSetId();
    }

    public String getPSDEDataExportId() {
        return this.strPSDEDataExportId;
    }

    public void setPSDEDataExportId(String strPSDEDataExportId) {
        this.strPSDEDataExportId = strPSDEDataExportId;
    }

    public String getDEDataExportId() {
        return this.getPSDEDataExportId();
    }

    public void setActiveDataPSDELogicId(String strActiveDataPSDELogicId) {
        this.strActiveDataPSDELogicId = strActiveDataPSDELogicId;
    }

    public String getActiveDataPSDELogicId() {
        return this.strActiveDataPSDELogicId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSMDAjaxControlParam) {
            IPSMDAjaxControlParam iPSMDAjaxControlParam = (IPSMDAjaxControlParam)iPSControlParam;
            if (!StringHelper.isNullOrEmpty((String)iPSMDAjaxControlParam.getPSDEDataSetId())) {
                this.setPSDEDataSetId(iPSMDAjaxControlParam.getPSDEDataSetId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSMDAjaxControlParam.getPSDEDataExportId())) {
                this.setPSDEDataExportId(iPSMDAjaxControlParam.getPSDEDataExportId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSMDAjaxControlParam.getActiveDataPSDELogicId())) {
                this.setActiveDataPSDELogicId(iPSMDAjaxControlParam.getActiveDataPSDELogicId());
            }
        }
    }

    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getDEDataSetId())) {
            return null;
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity().getPSDEDataSet(this.getDEDataSetId());
    }

    public IPSDEDataExport getPSDEDataExport() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getDEDataExportId())) {
            return null;
        }
        IPSAppDEView iPSAppDEView = (IPSAppDEView)this.getPSAppView();
        return iPSAppDEView.getPSDataEntity().getPSDEDataExport(this.getDEDataExportId());
    }

    public IPSDELogic getActiveDataPSDELogic() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getActiveDataPSDELogicId())) {
            return null;
        }
        return this.getPSDataEntity().getPSDELogic(this.getActiveDataPSDELogicId());
    }
}

