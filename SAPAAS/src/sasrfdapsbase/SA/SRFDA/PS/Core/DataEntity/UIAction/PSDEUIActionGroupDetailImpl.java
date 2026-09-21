/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroupDetail;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionGroupDetailImpl
extends PSObjectImpl
implements IPSDEUIActionGroupDetail,
IPSAppDEUIActionGroupDetail {
    private static final Log log = LogFactory.getLog(PSDEUIActionGroupDetailImpl.class);
    private IPSDEUIActionGroup iPSDEUIActionGroup = null;
    private PSDEUIActionGroupDetail psDEUIActionGroupDetail = null;
    private IPSDEUIAction iPSDEUIAction = null;
    private JSONObject uiActionParamJO = null;
    private String strDetailType = "DEUIACTION";
    private boolean bAddSeparator = false;
    private IPSAppDEUIActionGroup iPSAppDEUIActionGroup = null;
    private boolean bShowCaption = true;
    private boolean bShowIcon = true;
    private int nActionLevel = 100;
    private String strButtonStyle = null;
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private String strBeforeItemType = "NONE";
    private String strBeforeContent = null;
    private String strBeforePSSysCssId = null;
    private IPSSysResource beforePSSysResource = null;
    private IPSLanguageRes beforePSLanguageRes = null;
    private IPSSysCss beforePSSysCss = null;
    private String strAfterItemType = "NONE";
    private String strAfterContent = null;
    private String strAfterPSSysCssId = null;
    private IPSSysResource afterPSSysResource = null;
    private IPSLanguageRes afterPSLanguageRes = null;
    private IPSSysCss afterPSSysCss = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSDEUIActionGroup refPSDEUIActionGroup = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUIActionGroup iPSDEUIActionGroup, PSDEUIActionGroupDetail psDEUIActionGroupDetail) throws Exception {
        try {
            String strShowMode;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEUIActionGroup = iPSDEUIActionGroup;
            this.psDEUIActionGroupDetail = psDEUIActionGroupDetail;
            this.setId(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILID());
            this.setName(this.psDEUIActionGroupDetail.getPSDEUAGRPDETAILNAME());
            this.setPSObjectData(psDEUIActionGroupDetail);
            if (this.iPSDEUIActionGroup instanceof IPSAppDEUIActionGroup) {
                this.iPSAppDEUIActionGroup = (IPSAppDEUIActionGroup)this.iPSDEUIActionGroup;
                if (this.iPSAppDEUIActionGroup.getPSApplication() == null) {
                    this.iPSAppDEUIActionGroup = null;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getDETAILTYPE())) {
                this.strDetailType = this.psDEUIActionGroupDetail.getDETAILTYPE();
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
            if (StringHelper.compare((String)this.getDetailType(), (String)"DEUIACTIONGROUP", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getREFPSDEUAGROUPID())) {
                    throw new Exception("\u672a\u5b9a\u4e49\u5f15\u7528\u7684\u754c\u9762\u884c\u4e3a\u7ec4");
                }
                if (this.getPSAppDEUIActionGroup() != null) {
                    this.refPSDEUIActionGroup = this.getPSAppDEUIActionGroup().getPSAppDataEntity() != null ? this.getPSAppDEUIActionGroup().getPSAppDataEntity().getPSAppDEUIActionGroup(psDEUIActionGroupDetail.getREFPSDEUAGROUPID(), false, this.getPSAppDEUIActionGroup()) : this.getPSAppDEUIActionGroup().getPSApplication().getPSAppDEUIActionGroup(psDEUIActionGroupDetail.getREFPSDEUAGROUPID(), false);
                }
                if (this.getRefPSUIActionGroup() == null) {
                    this.refPSDEUIActionGroup = iPSDEUIActionGroup.getPSDataEntity() != null ? iPSDEUIActionGroup.getPSDataEntity().getPSDEUIActionGroup(psDEUIActionGroupDetail.getREFPSDEUAGROUPID()) : iPSDEUIActionGroup.getPSSystem().getPSDEUIActionGroup(psDEUIActionGroupDetail.getREFPSDEUAGROUPID(), false);
                }
            } else if (!StringHelper.isNullOrEmpty((String)psDEUIActionGroupDetail.getPSDEUIACTIONID())) {
                String strUIActionParam;
                if (this.getPSAppDEUIActionGroup() != null) {
                    this.iPSDEUIAction = this.getPSAppDEUIActionGroup().getPSAppDataEntity() != null ? this.getPSAppDEUIActionGroup().getPSAppDataEntity().getPSAppDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), false, this.getPSAppDEUIActionGroup()) : this.getPSAppDEUIActionGroup().getPSApplication().getPSAppDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), false);
                }
                if (this.getPSDEUIAction() == null) {
                    this.iPSDEUIAction = iPSDEUIActionGroup.getPSDataEntity() != null ? iPSDEUIActionGroup.getPSDataEntity().getPSDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID()) : iPSDEUIActionGroup.getPSSystem().getPSDEUIAction(psDEUIActionGroupDetail.getPSDEUIACTIONID(), false);
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
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getBEFOREITEMTYPE())) {
                this.strBeforeItemType = this.psDEUIActionGroupDetail.getBEFOREITEMTYPE();
            }
            if (StringHelper.compare((String)this.getBeforeItemType(), (String)"NONE", (boolean)true) != 0) {
                this.strBeforeContent = this.psDEUIActionGroupDetail.getBEFORECONTENT();
                this.strBeforePSSysCssId = this.psDEUIActionGroupDetail.getBEFOREPSSYSCSSID();
                if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getBEFOREPSSYSRESOURCEID())) {
                    this.beforePSSysResource = this.getPSDEUIActionGroup().getPSSystem().getPSSysResource(this.psDEUIActionGroupDetail.getBEFOREPSSYSRESOURCEID());
                }
                if (this.getBeforePSSysResource() != null) {
                    this.beforePSLanguageRes = this.getBeforePSLanguageRes();
                    if (this.beforePSLanguageRes != null && this.getPSAppDEUIActionGroup() != null) {
                        this.beforePSLanguageRes = this.getPSAppDEUIActionGroup().getPSApplication().getPSLanguageRes(this.beforePSLanguageRes.getId());
                    }
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getAFTERITEMTYPE())) {
                this.strAfterItemType = this.psDEUIActionGroupDetail.getAFTERITEMTYPE();
            }
            if (StringHelper.compare((String)this.getAfterItemType(), (String)"NONE", (boolean)true) != 0) {
                this.strAfterContent = this.psDEUIActionGroupDetail.getAFTERCONTENT();
                this.strAfterPSSysCssId = this.psDEUIActionGroupDetail.getAFTERPSSYSCSSID();
                if (!StringHelper.isNullOrEmpty((String)this.psDEUIActionGroupDetail.getAFTERPSSYSRESOURCEID())) {
                    this.afterPSSysResource = this.getPSDEUIActionGroup().getPSSystem().getPSSysResource(this.psDEUIActionGroupDetail.getAFTERPSSYSRESOURCEID());
                }
                if (this.getAfterPSSysResource() != null) {
                    this.afterPSLanguageRes = this.getAfterPSLanguageRes();
                    if (this.afterPSLanguageRes != null && this.getPSAppDEUIActionGroup() != null) {
                        this.afterPSLanguageRes = this.getPSAppDEUIActionGroup().getPSApplication().getPSLanguageRes(this.afterPSLanguageRes.getId());
                    }
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSSysCssId())) {
                this.iPSSysCss = this.getPSDEUIActionGroup().getPSSystem().getPSSysCss(this.getPSSysCssId());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSSysImageId())) {
                this.iPSSysImage = this.getPSDEUIActionGroup().getPSSystem().getPSSysImage(this.getPSSysImageId());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getBeforePSSysCssId())) {
                this.beforePSSysCss = this.getPSDEUIActionGroup().getPSSystem().getPSSysCss(this.getBeforePSSysCssId());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getAfterPSSysCssId())) {
                this.afterPSSysCss = this.getPSDEUIActionGroup().getPSSystem().getPSSysCss(this.getAfterPSSysCssId());
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
            this.iPSSysPFPlugin = this.getPSAppDEUIActionGroup() != null ? this.getPSAppDEUIActionGroup().getPSApplication().getPSSysPFPlugin(this.psDEUIActionGroupDetail.getPSSYSPFPLUGINID(), "UIACTIONGROUPDETAIL", null, null) : this.getPSDEUIActionGroup().getPSSystem().getPSSysPFPlugin(this.psDEUIActionGroupDetail.getPSSYSPFPLUGINID());
        }
        super.onInit();
    }

    @Override
    public IPSDEUIActionGroup getPSDEUIActionGroup() {
        return this.iPSDEUIActionGroup;
    }

    @Override
    public IPSAppDEUIActionGroup getPSAppDEUIActionGroup() {
        return this.iPSAppDEUIActionGroup;
    }

    @Override
    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEUIActionGroup().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u9644\u52a0\u53c2\u6570", fields={"UIACTIONPARAMS"})
    public JSONObject getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61")
    public IPSUIActionGroup getPSUIActionGroup() {
        return this.getPSDEUIActionGroup();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", child=true, rtobj="PSDEUIActionImpl", fields={"PSDEUIACTIONID"})
    public IPSUIAction getPSUIAction() {
        return this.getPSDEUIAction();
    }

    @Override
    public String getUIActionParam() {
        return this.psDEUIActionGroupDetail.getUIACTIONPARAMS();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="TBItemType2", fields={"DETAILTYPE"})
    public String getDetailType() {
        return this.strDetailType;
    }

    @Override
    @PSModelRTMeta(description="\u6dfb\u52a0\u5206\u9694\u680f", fields={"ADDSEPARATOR"})
    public boolean isAddSeparator() {
        return this.bAddSeparator;
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSDEUIActionGroup().getModelType(), (String)"PSAPPDEUAGROUP", (boolean)false) == 0) {
            return "PSAPPDEUAGRPDETAIL";
        }
        if (StringHelper.compare((String)this.getPSDEUIActionGroup().getModelType(), (String)"PSSYSAPPDEUAGROUP", (boolean)false) == 0) {
            return "PSSYSAPPDEUAGRPDETAIL";
        }
        return "PSDEUAGRPDETAIL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEUIActionGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEUIActionGroup().getPSSystem());
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSDEUIActionGroup().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEUIActionGroup().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", fields={"SHOWMODE"})
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u56fe\u6807", fields={"SHOWMODE"})
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
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb0", fields={"DETAILTAG"})
    public String getDetailTag() {
        return this.psDEUIActionGroupDetail.getDETAILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb02", fields={"DETAILTAG2"})
    public String getDetailTag2() {
        return this.psDEUIActionGroupDetail.getDETAILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psDEUIActionGroupDetail.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ea7\u522b", codelist="UIActionLevel", ignoredumpvalues="100", fields={"ACTIONLEVEL"})
    public int getActionLevel() {
        return this.nActionLevel;
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", ignoredumpvalues="DEFAULT", fields={"BUTTONSTYLE"})
    public String getButtonStyle() {
        return this.strButtonStyle;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u754c\u9762\u6837\u5f0f\u8868", fields={"PSSYSCSSID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u5185\u5bb9\u754c\u9762\u6837\u5f0f\u8868", fields={"BEFOREPSSYSCSSID"})
    public IPSSysCss getBeforePSSysCss() {
        return this.beforePSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7f6e\u5185\u5bb9\u754c\u9762\u6837\u5f0f\u8868", fields={"AFTERPSSYSCSSID"})
    public IPSSysCss getAfterPSSysCss() {
        return this.afterPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u56fe\u6807\u8d44\u6e90", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        if (this.iPSSysImage == null && this.isShowIcon() && this.getPSDEUIAction() != null && (this.getPSAppDEUIActionGroup() != null && this.getPSAppDEUIActionGroup().getPSApplication() != null ? this.getPSAppDEUIActionGroup().getPSApplication().getPSApplicationUI().isEnableUIModelEx() : this.getPSSystemSetting().isEnableUIModelEx())) {
            return this.getPSDEUIAction().getPSSysImage();
        }
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u5185\u5bb9\u7c7b\u578b", codelist="UAGroupDetailAppendItemType", fields={"BEFOREITEMTYPE"}, ignoredumpvalues="NONE")
    public String getBeforeItemType() {
        return this.strBeforeItemType;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u5185\u5bb9", fields={"BEFORECONTENT"})
    public String getBeforeContent() {
        if (StringHelper.isNullOrEmpty((String)this.getBeforeOriContent()) && this.getBeforePSSysResource() != null) {
            return this.getBeforePSSysResource().getContent();
        }
        return this.getBeforeOriContent();
    }

    @Override
    @PSModelRTMeta(description="\u539f\u59cb\u524d\u7f6e\u5185\u5bb9", dump=false)
    public String getBeforeOriContent() {
        return this.strBeforeContent;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u9884\u7f6e\u8d44\u6e90\u5bf9\u8c61", fields={"BEFOREPSSYSRESOURCEID"})
    public IPSSysResource getBeforePSSysResource() {
        return this.beforePSSysResource;
    }

    @Override
    public String getBeforePSSysCssId() {
        return this.strBeforePSSysCssId;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getBeforePSLanguageRes() {
        return this.beforePSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7f6e\u5185\u5bb9\u7c7b\u578b", codelist="UAGroupDetailAppendItemType", fields={"AFTERITEMTYPE"}, ignoredumpvalues="NONE")
    public String getAfterItemType() {
        return this.strAfterItemType;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7f6e\u5185\u5bb9", fields={"AFTERCONTENT"})
    public String getAfterContent() {
        if (StringHelper.isNullOrEmpty((String)this.getAfterOriContent()) && this.getAfterPSSysResource() != null) {
            return this.getAfterPSSysResource().getContent();
        }
        return this.getAfterOriContent();
    }

    @Override
    @PSModelRTMeta(description="\u539f\u59cb\u540e\u7f6e\u5185\u5bb9", dump=false)
    public String getAfterOriContent() {
        return this.strAfterContent;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7f6e\u9884\u7f6e\u8d44\u6e90\u5bf9\u8c61", fields={"AFTERPSSYSRESOURCEID"})
    public IPSSysResource getAfterPSSysResource() {
        return this.afterPSSysResource;
    }

    @Override
    public String getAfterPSSysCssId() {
        return this.strAfterPSSysCssId;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7f6e\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getAfterPSLanguageRes() {
        return this.afterPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        if (!this.isShowCaption()) {
            return null;
        }
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getCaption();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getTooltip();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getCapPSLanguageRes() {
        if (!this.isShowCaption()) {
            return null;
        }
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getCapPSLanguageRes();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getTooltipPSLanguageRes();
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

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, fields={"REFPSDEUAGROUPID"})
    public IPSUIActionGroup getRefPSUIActionGroup() {
        return this.refPSDEUIActionGroup;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if ("APPLICATION".equals(strModelType) || "APPDATAENTITY".equals(strModelType)) {
            if (this.getPSUIAction() != null) {
                objectNode.remove("getPSUIAction");
                objectNode.put("getPSUIAction", (JsonNode)this.getPSUIAction().toModelRef(strModelType));
            }
            if (this.getRefPSUIActionGroup() != null) {
                objectNode.remove("getRefPSUIActionGroup");
                objectNode.put("getRefPSUIActionGroup", (JsonNode)this.getRefPSUIActionGroup().toModelRef(strModelType));
            }
        }
    }
}

