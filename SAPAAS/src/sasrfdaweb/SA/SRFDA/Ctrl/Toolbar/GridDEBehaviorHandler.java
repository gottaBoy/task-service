/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GridDEBehaviorHandler
extends SRFExBaseDataGridTBBHandler
implements ISRFExToolbarMenuHandler {
    private static final Log log = LogFactory.getLog(GridDEBehaviorHandler.class);

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        return this.GetHandleJSCode(false, (XMLConfig)config, (ISRFDAWebContext)webContext, (SRFExDataGrid)obj);
    }

    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        return this.GetHandleJSCode(true, (XMLConfig)config, (ISRFDAWebContext)webContext, (SRFExDataGrid)obj);
    }

    protected String GetHandleJSCode(boolean bButton, XMLConfig config, ISRFDAWebContext daWebContext, SRFExDataGrid dataGrid) {
        String strPageId;
        String strDEBehaviorId = config.GetExtValue("DEBEHAVIORID", "");
        if (StringHelper.IsNullOrEmpty((String)strDEBehaviorId)) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a"));
            return "";
        }
        DEBehavior deBehavior = daWebContext.getGlobalHelper().getDAModelStorage().FindDEBehavior(strDEBehaviorId);
        if (deBehavior == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)strDEBehaviorId));
            return "";
        }
        if (bButton) {
            if (StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"MULTI", (boolean)true) == 0 || StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"ALL", (boolean)true) == 0) {
                GridDEBehaviorHandler.RegisterDataGridSelecteEvent2((ToolbarButtonConfig)((ToolbarButtonConfig)config), (SRFExWebContext)((SRFExWebContext)daWebContext), (SRFExDataGrid)dataGrid);
            }
            if (StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"SINGLE", (boolean)true) == 0 || StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"SINGLEKEY", (boolean)true) == 0) {
                GridDEBehaviorHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)((ToolbarButtonConfig)config), (SRFExWebContext)((SRFExWebContext)daWebContext), (SRFExDataGrid)dataGrid);
            }
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _G=$P.grid['%1$s'];", (Object)dataGrid.getUniqueID());
        script.Append("if(_G==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u8868\u683c\u5bf9\u8c61\uff0c\u65e0\u6cd5\u8fdb\u884c\u3010%1$s\u3011\u64cd\u4f5c');return;}\r\n", (Object)deBehavior.getDEBEHAVIORNAME());
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getCONFIRMINFO())) {
            script.Append("if(!confirm('%1$s'))return;", (Object)deBehavior.getCONFIRMINFO());
        }
        script.Append("%1$s", (Object)deBehavior.getBEFORECODE());
        if (StringHelper.Compare((String)deBehavior.getPROCESSTYPE(), (String)"FRONT", (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)(strPageId = deBehavior.getPAGEID()))) {
            Page page = daWebContext.getGlobalHelper().getDAModelStorage().FindPage(strPageId);
            String strDEID = page.getDEID();
            if (StringHelper.IsNullOrEmpty((String)strDEID)) {
                strDEID = deBehavior.getDEID();
            }
            IDEHelper srcDEHelper = daWebContext.getGlobalHelper().getDAModelStorage().FindDEHelper(deBehavior.getDEID());
            IDEHelper targetDEHelper = daWebContext.getGlobalHelper().getDAModelStorage().FindDEHelper(strDEID);
            if (targetDEHelper != null) {
                int nWidth = page.getWIDTH();
                int nHeight = page.getHEIGHT();
                String strKeyDEFName = srcDEHelper.GetKeyDEFHelper().getName();
                String strWindowStyle = page.getWINDOWSTYLE();
                script.Append("var _URL = '%1$s?SRFDEID=%2$s&SRFPAGEID=%3$s&';\r\n", (Object)page.getPAGEPATH(), (Object)strDEID, (Object)strPageId);
                script.Append("if(%1$s){_URL+= '%2$s='+%1$s.get('%3$s');}else{return;}\r\n", (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()), (Object)strKeyDEFName, (Object)strKeyDEFName.toLowerCase());
                script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
            }
        }
        if (StringHelper.Compare((String)deBehavior.getPROCESSTYPE(), (String)"BACKEND", (boolean)true) == 0) {
            JSONObject joParam = new JSONObject();
            joParam.put("srfbehaviorid", (Object)deBehavior.getDEBEHAVIORID());
            if (deBehavior.getTIMEOUT() > 0) {
                joParam.put("timeout", deBehavior.getTIMEOUT());
            }
            if (StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"SINGLE", (boolean)true) == 0 || StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"SINGLEKEY", (boolean)true) == 0) {
                script.Append("_G.gridmgr.scustomcall(%1$s,'%2$s','%3$s',false);\r\n", (Object)joParam.toString(), (Object)"srfbehavior", (Object)deBehavior.getDEBEHAVIORNAME());
            } else {
                script.Append("_G.gridmgr.customcall(%1$s,'%2$s','%3$s',false);\r\n", (Object)joParam.toString(), (Object)"srfbehavior", (Object)deBehavior.getDEBEHAVIORNAME());
            }
        }
        script.Append("}");
        return script.toString();
    }
}

