/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.PSEditorImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSEditorType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Properties;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSEditorTypeImpl
extends PSObjectImpl
implements IPSEditorType {
    private static final Log log = LogFactory.getLog(PSEditorTypeImpl.class);
    protected PSEditorType psEditorType = null;
    private boolean bStandardEditor = false;
    private boolean bEditable = true;
    private String strStandardPSEditorType = "";
    private Properties editorParams = null;
    private IPSEditorType standardPSEditorType = null;
    private boolean bConvertToCodeItemText = false;
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfigMode = 0;
    private String strValueProcessor = "";
    private int nWidth = -1;
    private int nHeight = -1;
    private String strAjaxHandlerType = "";
    private String strRefViewShowMode = "";
    private String strLinkViewShowMode = "";
    private String strEditorObj = null;
    private boolean bEnableMobileApp = false;
    private boolean bEnableWebApp = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSEditorType psEditorType) throws Exception {
        this.psEditorType = psEditorType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psEditorType.getPSEDITORTYPEID());
        this.setName(psEditorType.getPSEDITORTYPENAME());
        this.setPSObjectData(this.psEditorType);
        this.bStandardEditor = this.psEditorType.getSTANDARDTYPE();
        if (!this.psEditorType.isEDITABLENull()) {
            this.bEditable = this.psEditorType.getEDITABLE();
        }
        this.strStandardPSEditorType = this.psEditorType.getSTANDARDEDITOR();
        if (StringHelper.IsNullOrEmpty((String)this.strStandardPSEditorType)) {
            this.strStandardPSEditorType = this.getId();
        } else {
            this.standardPSEditorType = this.getPSModelStorage().getPSEditorType(this.strStandardPSEditorType);
        }
        this.bStandardEditor = StringHelper.Compare((String)this.strStandardPSEditorType, (String)this.getId(), (boolean)false) == 0;
        if (!psEditorType.isCONVERTCITEXTNull()) {
            this.bConvertToCodeItemText = this.psEditorType.getCONVERTCITEXT();
        } else if (this.standardPSEditorType != null) {
            this.bConvertToCodeItemText = this.standardPSEditorType.isConvertToCodeItemText();
        }
        if (!this.psEditorType.isNEEDCODELISTCONFIGNull()) {
            this.bNeedCodeListConfig = this.psEditorType.getNEEDCODELISTCONFIG();
        } else if (this.standardPSEditorType != null) {
            this.bNeedCodeListConfig = this.standardPSEditorType.isNeedCodeListConfig();
        }
        if (!this.psEditorType.isAJAXHANDLERNull()) {
            this.strAjaxHandlerType = this.psEditorType.getAJAXHANDLER();
        } else if (this.standardPSEditorType != null) {
            this.strAjaxHandlerType = this.standardPSEditorType.getAjaxHandlerType();
        }
        this.strValueProcessor = this.psEditorType.getVALUEPROCESSOR();
        if (!this.psEditorType.isWIDTHNull()) {
            this.nWidth = this.psEditorType.getWIDTH();
        }
        if (!this.psEditorType.isHEIGHTNull()) {
            this.nHeight = this.psEditorType.getHEIGHT();
        }
        this.strRefViewShowMode = this.psEditorType.getREFVIEWSHOWMODE();
        this.strLinkViewShowMode = this.psEditorType.getLINKVIEWSHOWMODE();
        this.editorParams = PropertiesHelper.load(null, (String)this.psEditorType.getEDITORPARAM());
        this.strEditorObj = this.psEditorType.getCTRLOBJ();
        if (this.psEditorType.isMOBFIEDITORNull() || !this.psEditorType.getMOBFIEDITOR()) {
            this.bEnableWebApp = true;
            if (StringHelper.Compare((String)this.strStandardPSEditorType, (String)"SPAN", (boolean)true) == 0 || StringHelper.Compare((String)this.strStandardPSEditorType, (String)"HIDDEN", (boolean)true) == 0 || StringHelper.Compare((String)this.strStandardPSEditorType, (String)"USERCONTROL", (boolean)true) == 0) {
                this.bEnableMobileApp = true;
            }
        } else {
            this.bEnableMobileApp = true;
        }
        this.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u57fa\u7840\u7f16\u8f91\u5668")
    public boolean isStandardEditor() {
        return this.bStandardEditor;
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7840\u7f16\u8f91\u5668\u7c7b\u578b")
    public String getStandardPSEditorType() {
        return this.strStandardPSEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91")
    public boolean isEditable() {
        return this.bEditable;
    }

    @Override
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)(this.standardPSEditorType == null ? nDefault : this.standardPSEditorType.getEditorParam(strParam, nDefault)));
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)(this.standardPSEditorType == null ? strDefault : this.standardPSEditorType.getEditorParam(strParam, strDefault)));
    }

    @Override
    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)(this.standardPSEditorType == null ? fDefault : this.standardPSEditorType.getEditorParam(strParam, fDefault)));
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)(this.standardPSEditorType == null ? bDefault : this.standardPSEditorType.getEditorParam(strParam, bDefault)));
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u5316\u4ee3\u7801\u503c\u5230\u6587\u672c")
    public boolean isConvertToCodeItemText() {
        return this.bConvertToCodeItemText;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @Override
    public String getValueProcessor() {
        return this.strValueProcessor;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bbd\u5ea6")
    public int getWidth() {
        return this.nWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u9ad8\u5ea6")
    public int getHeight() {
        return this.nHeight;
    }

    @Override
    public int getWidth(String strPSPFId) {
        return PropertiesHelper.getProperty((Properties)this.editorParams, (String)StringHelper.Format((String)"WIDTH.%1$s", (Object)strPSPFId), (int)this.getWidth());
    }

    @Override
    public int getHeight(String strPSPFId) {
        return PropertiesHelper.getProperty((Properties)this.editorParams, (String)StringHelper.Format((String)"HEIGHT.%1$s", (Object)strPSPFId), (int)this.getHeight());
    }

    @Override
    public boolean isUserControl() {
        return this.getEditorParam("USERCONTROL", false);
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u62fe\u53d6\u89c6\u56fe")
    public boolean hasPickupView() {
        return this.getEditorParam("PICKUPVIEW", false);
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u94fe\u63a5\u89c6\u56fe")
    public boolean hasLinkView() {
        return this.getEditorParam("LINKVIEW", false);
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode")
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="EditorRefViewShowMode")
    public String getRefViewShowMode() {
        return this.strRefViewShowMode;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="EditorRefViewShowMode")
    public String getLinkViewShowMode() {
        return this.strLinkViewShowMode;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u5904\u7406\u5668\u7c7b\u578b")
    public String getAjaxHandlerType() {
        return this.strAjaxHandlerType;
    }

    @Override
    public String getModelType() {
        return "PSEDITORTYPE";
    }

    @Override
    public IPSEditor createPSEditor(IPSEditorContainer iPSEditorContainer) throws Exception {
        IPSEditor iPSEditor = this.createPSEditor();
        if (iPSEditorContainer != null) {
            iPSEditor.init(this.getDAGlobalHelper(), iPSEditorContainer, null, null);
        }
        return iPSEditor;
    }

    public IPSEditor createPSEditor() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.strEditorObj)) {
            return new PSEditorImpl();
        }
        return (IPSEditor)ObjectHelper.create((String)this.strEditorObj);
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u79fb\u52a8\u7aef\u5e94\u7528")
    public boolean isEnableMobileApp() {
        return this.bEnableMobileApp;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u684c\u9762\u5e94\u7528")
    public boolean isEnableWebApp() {
        return this.bEnableWebApp;
    }
}

