/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEForm
 *  SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn
 *  SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem
 *  SA.SRFDA.PS.Core.Control.IPSAjaxControl
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam
 *  SA.SRFDA.PS.Core.Control.IPSSDAjaxControlParam
 *  SA.SRFDA.PS.Core.Data.IPSDataItem
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSMDAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSSDAjaxControlParam;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppViewCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysAppViewModelPublisherImpl
extends PSIBiz5SysAppViewCodePublisherImpl {
    public static final String CODETEMPL_APPVIEW = "APPVIEW";

    @Override
    protected void onGenerateAppViewCode(IPSAppView iPSAppView, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> ctrls = new ArrayList<IPSGenerateCodeResult>();
        Iterator psControls = iPSAppView.getPSControls();
        while (psControls.hasNext()) {
            IPSControl iPSControl = (IPSControl)psControls.next();
            IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(iPSControl.getControlType(), iPSControl, null);
            ctrls.add(iPSGenerateCodeResult);
        }
        params.put("ctrls", ctrls);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSAppView, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        IDataItemParam iDataItemParam;
        int n;
        IDataItemParam[] iDataItemParamArray;
        IDataItemParam[] dataItemParams;
        ArrayList<IPSGenerateCodeResult> dataitemparams;
        ArrayList<IPSGenerateCodeResult> dataitems;
        IPSGenerateCodeResult iPSGenerateCodeResult2;
        super.onFillGenerateCodeParams(strType, obj, params);
        if (obj != null && obj instanceof IPSAjaxControl) {
            IPSGenerateCodeResult iPSGenerateCodeResult3;
            IPSAjaxControl iPSAjaxControl = (IPSAjaxControl)obj;
            if (iPSAjaxControl.getPSAjaxControlParam() instanceof IPSMDAjaxControlParam) {
                iPSGenerateCodeResult3 = this.generateCode("MDACHANDLER", iPSAjaxControl.getPSAjaxControlParam(), null);
                params.put("mdacparam", iPSGenerateCodeResult3.getCode());
            }
            if (iPSAjaxControl.getPSAjaxControlParam() instanceof IPSSDAjaxControlParam) {
                iPSGenerateCodeResult3 = this.generateCode("SDACHANDLER", iPSAjaxControl.getPSAjaxControlParam(), null);
                params.put("sdacparam", iPSGenerateCodeResult3.getCode());
            }
        }
        if (StringHelper.compare((String)strType, (String)"GRID", (boolean)true) == 0) {
            IPSDEGrid iPSDEGrid = (IPSDEGrid)obj;
            ArrayList<IPSGenerateCodeResult> columns = new ArrayList<IPSGenerateCodeResult>();
            Iterator psDEGridColumns = iPSDEGrid.getPSDEGridColumns();
            while (psDEGridColumns.hasNext()) {
                IPSDEGridColumn iPSDEGridColumn = (IPSDEGridColumn)psDEGridColumns.next();
                iPSGenerateCodeResult2 = this.generateCode("GRIDCOLUMN", iPSDEGridColumn, null);
                columns.add(iPSGenerateCodeResult2);
            }
            params.put("columns", columns);
            dataitems = new ArrayList();
            Iterator psDEGridDataItems = iPSDEGrid.getPSDEGridDataItems();
            while (psDEGridDataItems.hasNext()) {
                IPSDEGridDataItem iPSDEGridDataItem = (IPSDEGridDataItem)psDEGridDataItems.next();
                iPSGenerateCodeResult2 = this.generateCode("DATAITEM", iPSDEGridDataItem, null);
                dataitems.add(iPSGenerateCodeResult2);
            }
            params.put("dataitems", dataitems);
        }
        if (StringHelper.compare((String)strType, (String)"FORM", (boolean)true) == 0 || StringHelper.compare((String)strType, (String)"SEARCHFORM", (boolean)true) == 0) {
            IPSDEForm iPSDEForm = (IPSDEForm)obj;
            dataitems = new ArrayList<IPSGenerateCodeResult>();
            Iterator psDEFormItems = iPSDEForm.getPSDEFormItems();
            while (psDEFormItems.hasNext()) {
                IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)psDEFormItems.next();
                iPSGenerateCodeResult2 = this.generateCode("FORMITEM", iPSDEFormItem, null);
                dataitems.add(iPSGenerateCodeResult2);
            }
            params.put("formitems", dataitems);
        }
        if (StringHelper.compare((String)strType, (String)"DATAITEM", (boolean)true) == 0) {
            IPSDataItem iPSDataItem = (IPSDataItem)obj;
            dataitemparams = new ArrayList<IPSGenerateCodeResult>();
            dataItemParams = iPSDataItem.getDataItemParams();
            if (dataItemParams != null) {
                iDataItemParamArray = dataItemParams;
                n = dataItemParams.length;
                int n2 = 0;
                while (n2 < n) {
                    iDataItemParam = iDataItemParamArray[n2];
                    iPSGenerateCodeResult = this.generateCode("DATAITEMPARAM", iDataItemParam, null);
                    dataitemparams.add(iPSGenerateCodeResult);
                    ++n2;
                }
            }
            params.put("dataitemparams", dataitemparams);
        }
        if (StringHelper.compare((String)strType, (String)"FORMITEM", (boolean)true) == 0) {
            IPSDEFormItem iPSDEFormItem = (IPSDEFormItem)obj;
            dataitemparams = new ArrayList();
            dataItemParams = iPSDEFormItem.getDataItem().getDataItemParams();
            if (dataItemParams != null) {
                iDataItemParamArray = dataItemParams;
                n = dataItemParams.length;
                int n3 = 0;
                while (n3 < n) {
                    iDataItemParam = iDataItemParamArray[n3];
                    iPSGenerateCodeResult = this.generateCode("DATAITEMPARAM", iDataItemParam, null);
                    dataitemparams.add(iPSGenerateCodeResult);
                    ++n3;
                }
            }
            params.put("dataitemparams", dataitemparams);
        }
    }
}

