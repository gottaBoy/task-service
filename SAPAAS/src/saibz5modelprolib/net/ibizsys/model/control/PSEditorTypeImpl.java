/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.IPSEditorTypeRuntime;
import net.ibizsys.model.entity.PSEditorType;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSEditorTypeImpl
extends PSObjectImpl
implements IPSEditorTypeRuntime {
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

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSEditorType psEditorType) throws Exception {
        this.psEditorType = psEditorType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psEditorType.getPSEDITORTYPEID());
        this.setName(psEditorType.getPSEDITORTYPENAME());
        this.setPSObjectData(this.psEditorType);
        this.bStandardEditor = this.psEditorType.getSTANDARDTYPE();
        if (!this.psEditorType.isEDITABLENull()) {
            this.bEditable = this.psEditorType.getEDITABLE();
        }
        this.strStandardPSEditorType = this.psEditorType.getSTANDARDEDITOR();
        if (StringHelper.isNullOrEmpty((String)this.strStandardPSEditorType)) {
            this.strStandardPSEditorType = this.getId();
        } else {
            this.standardPSEditorType = this.getPSModelStorageContext().getPSEditorType(this.strStandardPSEditorType);
        }
        this.bStandardEditor = StringHelper.compare((String)this.strStandardPSEditorType, (String)this.getId(), (boolean)false) == 0;
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
        this.onInit();
    }

    @PSModelRTMeta(description="\u662f\u5426\u57fa\u7840\u7f16\u8f91\u5668")
    public boolean isStandardEditor() {
        return this.bStandardEditor;
    }

    @PSModelRTMeta(description="\u57fa\u7840\u7f16\u8f91\u5668\u7c7b\u578b")
    public String getStandardPSEditorType() {
        return this.strStandardPSEditorType;
    }

    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91")
    public boolean isEditable() {
        return this.bEditable;
    }

    public Properties getEditorParams() {
        return this.editorParams;
    }

    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)(this.standardPSEditorType == null ? nDefault : this.standardPSEditorType.getEditorParam(strParam, nDefault)));
    }

    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)(this.standardPSEditorType == null ? strDefault : this.standardPSEditorType.getEditorParam(strParam, strDefault)));
    }

    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)(this.standardPSEditorType == null ? fDefault : this.standardPSEditorType.getEditorParam(strParam, fDefault)));
    }

    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)(this.standardPSEditorType == null ? bDefault : this.standardPSEditorType.getEditorParam(strParam, bDefault)));
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @PSModelRTMeta(description="\u8f6c\u5316\u4ee3\u7801\u503c\u5230\u6587\u672c")
    public boolean isConvertToCodeItemText() {
        return this.bConvertToCodeItemText;
    }

    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    public String getValueProcessor() {
        return this.strValueProcessor;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bbd\u5ea6")
    public int getWidth() {
        return this.nWidth;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u9ad8\u5ea6")
    public int getHeight() {
        return this.nHeight;
    }

    public int getWidth(String strPSPFId) {
        return PropertiesHelper.getProperty((Properties)this.editorParams, (String)StringHelper.format((String)"WIDTH.%1$s", (Object)strPSPFId), (int)this.getWidth());
    }

    public int getHeight(String strPSPFId) {
        return PropertiesHelper.getProperty((Properties)this.editorParams, (String)StringHelper.format((String)"HEIGHT.%1$s", (Object)strPSPFId), (int)this.getHeight());
    }

    public boolean isUserControl() {
        return this.getEditorParam("USERCONTROL", false);
    }

    @PSModelRTMeta(description="\u9700\u8981\u62fe\u53d6\u89c6\u56fe")
    public boolean hasPickupView() {
        return this.getEditorParam("PICKUPVIEW", false);
    }

    @PSModelRTMeta(description="\u9700\u8981\u94fe\u63a5\u89c6\u56fe")
    public boolean hasLinkView() {
        return this.getEditorParam("LINKVIEW", false);
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode")
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="EditorRefViewShowMode")
    public String getRefViewShowMode() {
        return this.strRefViewShowMode;
    }

    @PSModelRTMeta(description="\u94fe\u63a5\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="EditorRefViewShowMode")
    public String getLinkViewShowMode() {
        return this.strLinkViewShowMode;
    }

    @PSModelRTMeta(description="\u5f02\u6b65\u5904\u7406\u5668\u7c7b\u578b")
    public String getAjaxHandlerType() {
        return this.strAjaxHandlerType;
    }
}

