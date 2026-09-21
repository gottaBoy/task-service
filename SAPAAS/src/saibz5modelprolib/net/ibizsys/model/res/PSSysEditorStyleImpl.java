/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.entity.PSSysEditorStyle;
import net.ibizsys.model.res.IPSSysEditorStyleRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEditorStyleImpl
extends PSSystemObjectImpl
implements IPSSysEditorStyleRuntime {
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

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysEditorStyle psSysEditorStyle) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysEditorStyle = psSysEditorStyle;
            this.setId(this.psSysEditorStyle.getPSSYSEDITORSTYLEID());
            this.setName(this.psSysEditorStyle.getPSSYSEDITORSTYLENAME());
            this.setPSObjectData(this.psSysEditorStyle);
            if (!StringHelper.isNullOrEmpty((String)psSysEditorStyle.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSSystemRuntime().getPSSysPFPlugin(psSysEditorStyle.getPSSYSPFPLUGINID());
            }
            if (!this.psSysEditorStyle.isREPDEFAULTNull()) {
                this.bReplaceDefault = this.psSysEditorStyle.getREPDEFAULT();
            }
            this.strPSEditorTypeId = this.psSysEditorStyle.getPSEDITORTYPEID();
            this.editorParams = PropertiesHelper.load((String)this.psSysEditorStyle.getCTRLPARAMS());
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
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
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

    @PSModelRTMeta(description="\u66ff\u6362\u9ed8\u8ba4\u6837\u5f0f")
    public boolean isReplaceDefault() {
        return this.bReplaceDefault;
    }

    public String getPSEditorTypeId() {
        return this.strPSEditorTypeId;
    }

    @PSModelRTMeta(description="\u5e73\u53f0\u7f16\u8f91\u5668\u5bf9\u8c61")
    public IPSEditorType getPSEditorType() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSEditorTypeId())) {
            return null;
        }
        return this.getPSModelStorageContext().getPSEditorType(this.getPSEditorTypeId());
    }

    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
    }

    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    public boolean getEditorParam(String strParam, boolean bDefault) {
        return this.psSysEditorStyle.getParamBoolValue("CTRL" + strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault));
    }

    public Properties getEditorParams() {
        return this.editorParams;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6")
    public double getEditorWidth() {
        return this.fEditorWidth;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6")
    public double getEditorHeight() {
        return this.fEditorHeight;
    }

    @PSModelRTMeta(description="\u5f02\u6b65\u5904\u7406\u5668\u7c7b\u578b")
    public String getAjaxHandlerType() {
        return this.strAjaxHandler;
    }

    public String getPSAjaxHandlerId() {
        return this.strPSACHandlerId;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="EditorRefViewShowMode")
    public String getRefViewShowMode() {
        return this.strRefViewShowMode;
    }

    @PSModelRTMeta(description="\u94fe\u63a5\u89c6\u56fe\u663e\u793a\u6a21\u5f0f", codelist="EditorRefViewShowMode")
    public String getLinkViewShowMode() {
        return this.strLinkViewShowMode;
    }
}

