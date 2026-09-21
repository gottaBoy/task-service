/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Toolbar.BaseFormTBBHandler;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FormDEBehaviorHandler
extends BaseFormTBBHandler
implements ISRFExToolbarMenuHandler {
    private static final Log log = LogFactory.getLog(FormDEBehaviorHandler.class);

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        return this.GetHandleJSCode(false, (XMLConfig)config, (ISRFDAWebContext)webContext, obj);
    }

    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        return this.GetHandleJSCode(true, (XMLConfig)config, (ISRFDAWebContext)webContext, obj);
    }

    protected String GetHandleJSCode(boolean bButton, XMLConfig config, ISRFDAWebContext daWebContext, Object obj) {
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
        if (bButton && !StringHelper.IsNullOrEmpty((String)deBehavior.getDATAACTION())) {
            FormDEBehaviorHandler.RegisterFormStateChangeEvent((ToolbarButtonConfig)config, (SRFExWebContext)daWebContext, deBehavior.getDATAACTION());
        }
        boolean bNoDataMode = false;
        String strActionTarget = config.GetExtValue("UP_ACTIONTARGET", "");
        if (StringHelper.Compare((String)strActionTarget, (String)"NONE", (boolean)true) == 0) {
            bNoDataMode = true;
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _F=$P.mainform;");
        script.Append("if(_F==null){alert('\u754c\u9762\u4e2d\u4e0d\u5b58\u5728\u4e3b\u8868\u5355\uff0c\u65e0\u6cd5\u8fdb\u884c\u3010%1$s\u3011\u64cd\u4f5c');return;}\r\n", (Object)deBehavior.getDEBEHAVIORNAME());
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getCONFIRMINFO())) {
            script.Append("if(!confirm('%1$s'))return;", (Object)deBehavior.getCONFIRMINFO());
        }
        script.Append("%1$s", (Object)deBehavior.getBEFORECODE());
        if (StringHelper.Compare((String)deBehavior.getPROCESSTYPE(), (String)"BACKEND", (boolean)true) == 0) {
            JSONObject joCall = new JSONObject();
            joCall.put("callid", (Object)"srfbehavior");
            if (deBehavior.getTIMEOUT() > 0) {
                joCall.put("timeout", deBehavior.getTIMEOUT());
            }
            if (StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"SINGLE", (boolean)true) == 0) {
                joCall.put("keyonly", false);
            } else {
                joCall.put("keyonly", true);
            }
            JSONObject joParam = new JSONObject();
            joParam.put("srfbehaviorid", (Object)deBehavior.getDEBEHAVIORID());
            script.Append("_F.customcall(%1$s,%2$s);", (Object)joCall.toString(), (Object)joParam.toString());
        } else {
            int nPageWidth = config.GetExtValue("UP_PAGEWIDTH", 0);
            int nPageHeight = config.GetExtValue("UP_PAGEHEIGHT", 0);
            boolean bShowModal = config.GetExtValue("UP_PAGESHOWMODAL", false);
            String strUrl = config.GetExtValue("UP_PAGEURL", "");
            if (bNoDataMode) {
                script.Append("if(!_F.haskeys()){alert('\u8868\u5355\u4e0d\u5b58\u5728\u6709\u6548\u6570\u636e\uff0c\u65e0\u6cd5\u64cd\u4f5c');return;}");
                script.Append("var _URL='%1$s';", (Object)strUrl);
            } else {
                script.Append("var _URL='%1$s&'+Ext.urlEncode(_F.getkeys());", (Object)strUrl);
            }
            if (bShowModal) {
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"", (int)nPageWidth, (int)nPageHeight, (String)"yes", (String)"no", (String)"no"));
            } else {
                script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"", (String)"", (boolean)false, (int)nPageWidth, (int)nPageHeight));
            }
        }
        script.Append("}");
        return script.toString();
    }
}

