/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyleRuntime;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysEditorStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEditorStyleImpl
extends PSSystemObjectImpl
implements IPSSysEditorStyle,
IPSSysEditorStyleRuntime {
    private static final Log log = LogFactory.getLog(PSSysEditorStyleImpl.class);
    protected PSSysEditorStyle psSysEditorStyle = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private boolean bReplaceDefault = false;
    private String strPSEditorTypeId = null;
    protected double fEditorWidth = -1.0;
    protected double fEditorHeight = -1.0;
    protected Properties editorParams = null;
    protected String strAjaxHandler = null;
    protected String strPSACHandlerId = null;
    private String strRefViewShowMode = "";
    private String strLinkViewShowMode = "";
    private String strStyleCode = "";
    private String strContainerType = "";
    private IPSSystemModule iPSSystemModule = null;
    private String strCodeName = "";
    private IPSPFEditorTempl iPSPFEditorTempl = null;
    private IPSSysCss iPSSysCss = null;
    private boolean bExtendStyleOnly = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysEditorStyle psSysEditorStyle) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysEditorStyle = psSysEditorStyle;
            this.setId(this.psSysEditorStyle.getPSSYSEDITORSTYLEID());
            this.setName(this.psSysEditorStyle.getPSSYSEDITORSTYLENAME());
            this.setPSObjectData(this.psSysEditorStyle);
            if (!StringHelper.isNullOrEmpty((String)psSysEditorStyle.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = iPSSystem.getPSSysPFPlugin(psSysEditorStyle.getPSSYSPFPLUGINID());
            }
            if (!this.psSysEditorStyle.isREPDEFAULTNull()) {
                this.bReplaceDefault = this.psSysEditorStyle.getREPDEFAULT();
            }
            if (this.isReplaceDefault()) {
                this.strContainerType = this.psSysEditorStyle.getCONTAINERTYPE();
            }
            this.strStyleCode = this.strCodeName = this.psSysEditorStyle.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysEditorStyle.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysEditorStyle.getPSMODULEID());
            }
            this.strPSEditorTypeId = this.psSysEditorStyle.getPSEDITORTYPEID();
            this.editorParams = PropertiesHelper.load((String)this.psSysEditorStyle.getCTRLPARAMS());
            String strRealStyleCode = PropertiesHelper.getProperty((Properties)this.editorParams, (String)"REALSTYLECODE", null);
            if (!StringHelper.isNullOrEmpty((String)strRealStyleCode) && !StringHelper.isNullOrEmpty((String)(strRealStyleCode = strRealStyleCode.trim()))) {
                this.strStyleCode = strRealStyleCode;
            }
            if (!psSysEditorStyle.isWIDTHNull()) {
                this.fEditorWidth = psSysEditorStyle.getWIDTH();
            }
            if (!psSysEditorStyle.isHEIGHTNull()) {
                this.fEditorHeight = psSysEditorStyle.getHEIGHT();
            }
            if (!this.psSysEditorStyle.isAJAXHANDLERNull()) {
                this.strAjaxHandler = this.psSysEditorStyle.getAJAXHANDLER();
            }
            if (!this.psSysEditorStyle.isPSACHANDLERIDNull()) {
                this.strPSACHandlerId = this.psSysEditorStyle.getPSACHANDLERID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEditorStyle.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSSystem().getPSSysCss(this.psSysEditorStyle.getPSSYSCSSID());
            }
            if (!this.psSysEditorStyle.isEXTENDSTYLEONLYNull()) {
                this.bExtendStyleOnly = this.psSysEditorStyle.getEXTENDSTYLEONLY();
            }
            this.strRefViewShowMode = this.psSysEditorStyle.getREFVIEWSHOWMODE();
            this.strLinkViewShowMode = this.psSysEditorStyle.getLINKVIEWSHOWMODE();
            IPSEditorType iPSEditorType = this.getPSEditorType();
            if (iPSEditorType != null) {
                if (StringHelper.isNullOrEmpty((String)this.strRefViewShowMode)) {
                    this.strRefViewShowMode = iPSEditorType.getRefViewShowMode();
                }
                if (StringHelper.isNullOrEmpty((String)this.strLinkViewShowMode)) {
                    this.strLinkViewShowMode = iPSEditorType.getLinkViewShowMode();
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u66ff\u6362\u9ed8\u8ba4\u6837\u5f0f")
    public boolean isReplaceDefault() {
        return this.bReplaceDefault;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", group="\u57fa\u672c", order=125)
    public String getEditorType() {
        return this.getPSEditorTypeId();
    }

    @Override
    public String getPSEditorTypeId() {
        return this.strPSEditorTypeId;
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u53f0\u7f16\u8f91\u5668\u5bf9\u8c61", outputdoc="false")
    public IPSEditorType getPSEditorType() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSEditorTypeId())) {
            return null;
        }
        return this.getPSModelStorage().getPSEditorType(this.getPSEditorTypeId());
    }

    @Override
    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
    }

    @Override
    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    @Override
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6")
    public double getEditorWidth() {
        return this.fEditorWidth;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6")
    public double getEditorHeight() {
        return this.fEditorHeight;
    }

    @Override
    public String getModelType() {
        return "PSSYSEDITORSTYLE";
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u5904\u7406\u6a21\u5f0f", codelist="EditorAjaxHandlerType")
    public String getAjaxHandlerType() {
        return this.strAjaxHandler;
    }

    @Override
    public String getPSAjaxHandlerId() {
        return this.strPSACHandlerId;
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
    @PSModelRTMeta(description="\u6837\u5f0f\u4ee3\u7801")
    public String getStyleCode() {
        return this.strStyleCode;
    }

    @Override
    @PSModelRTMeta(description="\u5bb9\u5668\u7c7b\u578b", codelist="EditorContainers")
    public String getContainerType() {
        return this.strContainerType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    public IPSPFEditorTempl getPSPFEditorTempl() {
        return this.iPSPFEditorTempl;
    }

    @Override
    public void setPSPFEditorTempl(IPSPFEditorTempl iPSPFEditorTempl) {
        this.iPSPFEditorTempl = iPSPFEditorTempl;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u6837\u5f0f\u8868")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6269\u5c55\u754c\u9762\u6837\u5f0f", ignoredumpvalues="false")
    public boolean isExtendStyleOnly() {
        return this.bExtendStyleOnly;
    }
}

