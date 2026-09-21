/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF.UIAction;

import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroupDetail;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGroupDetailImpl
extends PSObjectImpl
implements IPSWFUIActionGroupDetail,
IPSAppWFUIActionGroupDetail {
    private static final Log log = LogFactory.getLog(PSWFUIActionGroupDetailImpl.class);
    private IPSWFUIActionGroup iPSWFUIActionGroup = null;
    private PSDEUIActionGroupDetail psDEUIActionGroupDetail = null;
    private IPSWFUIAction iPSWFUIAction = null;
    private JSONObject uiActionParamJO = null;
    private boolean bAddSeparator = false;
    private IPSUIAction iPSUIAction = null;
    private IPSAppWFUIActionGroup iPSAppWFUIActionGroup = null;
    private boolean bShowCaption = true;
    private boolean bShowIcon = true;
    private int nActionLevel = 100;
    private String strButtonStyle = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFUIActionGroup iPSWFUIActionGroup, PSDEUIActionGroupDetail psDEUIActionGroupDetail) throws Exception {
        try {
            String strShowMode;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFUIActionGroup = iPSWFUIActionGroup;
            this.psDEUIActionGroupDetail = psDEUIActionGroupDetail;
            this.setId(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILID());
            this.setName(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILNAME());
            this.setPSObjectData(this.psDEUIActionGroupDetail);
            if (iPSWFUIActionGroup instanceof IPSAppWFUIActionGroup) {
                this.iPSAppWFUIActionGroup = (IPSAppWFUIActionGroup)iPSWFUIActionGroup;
                if (this.iPSAppWFUIActionGroup.getPSAppWF() == null) {
                    this.iPSAppWFUIActionGroup = null;
                }
            }
            if (!this.psDEUIActionGroupDetail.isADDSEPARATORNull()) {
                this.bAddSeparator = this.psDEUIActionGroupDetail.getADDSEPARATOR();
            }
            if (!StringHelper.isNullOrEmpty((String)(strShowMode = this.psDEUIActionGroupDetail.getSHOWMODE()))) {
                if (StringHelper.compare((String)strShowMode, (String)"ICONANDSHORTWORD", (boolean)true) == 0) {
                    this.bShowCaption = true;
                    this.bShowIcon = true;
                } else if (StringHelper.compare((String)strShowMode, (String)"ICON", (boolean)true) == 0) {
                    this.bShowCaption = false;
                    this.bShowIcon = true;
                } else if (StringHelper.compare((String)strShowMode, (String)"SHORTWORD", (boolean)true) == 0) {
                    this.bShowCaption = true;
                    this.bShowIcon = false;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)psDEUIActionGroupDetail.getPSDEUIACTIONID())) {
                String strUIActionParam;
                if (this.iPSWFUIAction == null && this.getPSAppWFUIActionGroup() != null) {
                    if (this.getPSAppWFUIActionGroup().getPSAppWFVer() != null) {
                        this.iPSWFUIAction = this.getPSAppWFUIActionGroup().getPSAppWFVer().getPSAppWFUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                    }
                    if (this.iPSWFUIAction == null && this.getPSAppWFUIActionGroup().getPSAppWF() != null) {
                        this.iPSWFUIAction = this.getPSAppWFUIActionGroup().getPSAppWF().getPSAppWFUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                    }
                }
                if (this.iPSWFUIAction == null) {
                    this.iPSWFUIAction = iPSWFUIActionGroup.getPSWFVersion() != null ? iPSWFUIActionGroup.getPSWFVersion().getPSWFUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true) : iPSWFUIActionGroup.getPSWorkflow().getPSWFUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                }
                if (this.iPSWFUIAction == null) {
                    if (this.getPSAppWFUIActionGroup() != null && this.getPSAppWFUIActionGroup().getPSAppWF() != null && this.getPSAppWFUIActionGroup().getPSAppWF().getPSApplication() != null) {
                        this.iPSUIAction = this.getPSAppWFUIActionGroup().getPSAppWF().getPSApplication().getPSAppDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                    }
                    if (this.iPSUIAction == null) {
                        this.iPSUIAction = iPSWFUIActionGroup.getPSWorkflow().getPSSystem().getPSDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), true);
                    }
                    if (this.iPSUIAction == null) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a[%1$s]", (Object)psDEUIActionGroupDetail.getPSDEUIACTIONID()));
                    }
                } else {
                    this.iPSUIAction = this.iPSWFUIAction;
                }
                if (!StringHelper.isNullOrEmpty((String)(strUIActionParam = psDEUIActionGroupDetail.getUIACTIONPARAMS().trim()))) {
                    if (strUIActionParam.charAt(0) == '{') {
                        this.uiActionParamJO = JSONObject.fromString((String)strUIActionParam);
                    } else {
                        this.uiActionParamJO = new JSONObject();
                        Properties properties = PropertiesHelper.load((String)strUIActionParam);
                        Enumeration<Object> keys = properties.keys();
                        while (keys.hasMoreElements()) {
                            String strKey = keys.nextElement().toString();
                            String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                            this.uiActionParamJO.put(strKey, (Object)strValue);
                        }
                    }
                }
            }
            if (!this.psDEUIActionGroupDetail.isACTIONLEVELNull()) {
                this.nActionLevel = this.psDEUIActionGroupDetail.getACTIONLEVEL();
            } else if (this.getPSUIAction() != null) {
                this.nActionLevel = this.getPSUIAction().getActionLevel();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getBUTTONSTYLE())) {
                this.strButtonStyle = this.psDEUIActionGroupDetail.getBUTTONSTYLE();
            } else if (this.getPSUIAction() != null) {
                this.strButtonStyle = this.getPSUIAction().getButtonStyle();
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
        if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSAppWFUIActionGroup() != null ? this.getPSAppWFUIActionGroup().getPSAppWF().getPSApplication().getPSSysPFPlugin(this.psDEUIActionGroupDetail.getPSSYSPFPLUGINID(), "UIACTIONGROUPDETAIL", null, null) : this.getPSWFUIActionGroup().getPSWorkflow().getPSSystem().getPSSysPFPlugin(this.psDEUIActionGroupDetail.getPSSYSPFPLUGINID());
        }
        super.onInit();
    }

    @Override
    public IPSWFUIActionGroup getPSWFUIActionGroup() {
        return this.iPSWFUIActionGroup;
    }

    @Override
    public IPSWFUIAction getPSWFUIAction() {
        return this.iPSWFUIAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWFUIActionGroup().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u9644\u52a0\u53c2\u6570")
    public JSONObject getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61")
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.getPSWFUIActionGroup();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", child=true, rtobj="PSWFUIActionImpl")
    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    @Override
    public String getUIActionParam() {
        return this.psDEUIActionGroupDetail.getUIACTIONPARAMS();
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSWFUIActionGroup().getModelType(), (String)"PSAPPWFUAGROUP", (boolean)false) == 0) {
            return "PSAPPWFUAGRPDETAIL";
        }
        if (StringHelper.compare((String)this.getPSWFUIActionGroup().getModelType(), (String)"PSAPPWFVERUAGROUP", (boolean)false) == 0) {
            return "PSAPPWFVERUAGRPDETAIL";
        }
        return "PSWFUAGRPDETAIL";
    }

    @Override
    @PSModelRTMeta(description="\u6dfb\u52a0\u5206\u9694\u680f")
    public boolean isAddSeparator() {
        return this.bAddSeparator;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFUIActionGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWFUIActionGroup().getPSWorkflow().getPSSystem());
    }

    @Override
    public String getModelId() {
        if (StringHelper.compare((String)this.getPSWFUIActionGroup().getModelType(), (String)"PSAPPWFUAGROUP", (boolean)false) == 0) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFUIActionGroup().getModelId(), (Object)super.getModelId());
        }
        if (StringHelper.compare((String)this.getPSWFUIActionGroup().getModelType(), (String)"PSAPPWFVERUAGROUP", (boolean)false) == 0) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFUIActionGroup().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public IPSAppWFUIActionGroup getPSAppWFUIActionGroup() {
        return this.iPSAppWFUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u56fe\u6807")
    public boolean isShowIcon() {
        return this.bShowIcon;
    }

    @Override
    public String getPSSysCssId() {
        return this.psDEUIActionGroupDetail.getPSSYSCSSID();
    }

    @Override
    public String getPSSysImageId() {
        return this.psDEUIActionGroupDetail.getPSSYSIMAGEID();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb0")
    public String getDetailTag() {
        return this.psDEUIActionGroupDetail.getDETAILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb02")
    public String getDetailTag2() {
        return this.psDEUIActionGroupDetail.getDETAILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEUIActionGroupDetail.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ea7\u522b", codelist="UIActionLevel", ignoredumpvalues="100")
    public int getActionLevel() {
        return this.nActionLevel;
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", ignoredumpvalues="100")
    public String getButtonStyle() {
        return this.strButtonStyle;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (!this.isShowCaption()) {
            return null;
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getCaption();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getTooltip();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getCapPSLanguageRes() {
        if (!this.isShowCaption()) {
            return null;
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getCapPSLanguageRes();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getTooltipPSLanguageRes();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u811a\u672c\u4ee3\u7801", fields={"ENABLELOGIC"})
    public String getEnableScriptCode() {
        return this.psDEUIActionGroupDetail.getENABLELOGIC();
    }

    @Override
    @PSModelRTMeta(description="\u53ef\u89c1\u5224\u65ad\u811a\u672c\u4ee3\u7801", fields={"VISIBLELOGIC"})
    public String getVisibleScriptCode() {
        return this.psDEUIActionGroupDetail.getVISIBLELOGIC();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }
}

