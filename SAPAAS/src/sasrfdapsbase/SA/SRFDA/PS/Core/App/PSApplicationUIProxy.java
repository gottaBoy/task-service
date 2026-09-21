/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationUI;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;

@PSModelIgnoreMeta
public class PSApplicationUIProxy
extends PSObjectImpl
implements IPSApplicationUI {
    private IPSApplication iPSApplication = null;
    private IPSApplicationUI iPSApplicationUI = null;

    public PSApplicationUIProxy(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
        this.iPSApplicationUI = (IPSApplicationUI)((Object)iPSApplication);
    }

    @Override
    public String getId() {
        return this.iPSApplication.getId();
    }

    @Override
    public String getName() {
        return this.iPSApplication.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u67b6\u6784")
    public String getPFType() {
        return this.iPSApplicationUI.getPFType();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6837\u5f0f")
    public String getPFStyle() {
        return this.iPSApplicationUI.getPFStyle();
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSApplicationUI.getPSPF();
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSApplicationUI.getPSPFStyle();
    }

    @Override
    public Object getPFStyleParam(String strKey) throws Exception {
        return this.iPSApplicationUI.getPFStyleParam(strKey);
    }

    @Override
    public boolean getPFStyleParam(String strKey, boolean bDefault) throws Exception {
        return this.iPSApplicationUI.getPFStyleParam(strKey, bDefault);
    }

    @Override
    public String getPFStyleParam(String strKey, String strDefault) throws Exception {
        return this.iPSApplicationUI.getPFStyleParam(strKey, strDefault);
    }

    @Override
    public int getPFStyleParam(String strKey, int nDefault) throws Exception {
        return this.iPSApplicationUI.getPFStyleParam(strKey, nDefault);
    }

    @Override
    public double getPFStyleParam(String strKey, double fDefault) throws Exception {
        return this.iPSApplicationUI.getPFStyleParam(strKey, fDefault);
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u83dc\u5355\u5bf9\u9f50", codelist="AppIndexViewMenuAlign")
    public String getMainMenuAlign() {
        return this.iPSApplicationUI.getMainMenuAlign();
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u6309\u94ae\u663e\u793a\u6a21\u5f0f", codelist="BtnNoPrivDisplayMode")
    public int getButtonNoPrivDisplayMode() {
        return this.iPSApplicationUI.getButtonNoPrivDisplayMode();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u8f6c\u636212\u5217\u81f324\u5217\u5e03\u5c40")
    public boolean isEnableCol12ToCol24() {
        return this.iPSApplicationUI.isEnableCol12ToCol24();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u9ed8\u8ba4\u542f\u7528\u5168\u5c4f")
    public boolean isGridForceFit() {
        return this.iPSApplicationUI.isGridForceFit();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u9ed8\u8ba4\u652f\u6301\u5b9a\u5236")
    public boolean isGridEnableCustomized() {
        return this.iPSApplicationUI.isGridEnableCustomized();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u884c\u9ed8\u8ba4\u6fc0\u6d3b\u6a21\u5f0f", codelist="GridRowActiveMode")
    public int getGridRowActiveMode() {
        return this.iPSApplicationUI.getGridRowActiveMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSApplication.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSAPP_UI";
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes")
    public int getFormItemNoPrivDisplayMode() {
        return this.iPSApplicationUI.getFormItemNoPrivDisplayMode();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes")
    public int getGridColumnNoPrivDisplayMode() {
        return this.iPSApplicationUI.getGridColumnNoPrivDisplayMode();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u8868\u5355\u9879\u66f4\u65b0\u6743\u9650\u6807\u8bb0")
    public boolean isOutputFormItemUpdatePrivTag() {
        return this.iPSApplicationUI.isOutputFormItemUpdatePrivTag();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u754c\u9762\u6837\u5f0f", codelist="AppUIStyle2")
    public String getUIStyle() {
        return this.iPSApplicationUI.getUIStyle();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u63a7\u4ef6\u6837\u5f0f")
    public String getDefaultControlStyle() {
        return this.iPSApplicationUI.getDefaultControlStyle();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u89c6\u56fe\u4f18\u5148\u7ea7", dump=false)
    public Integer getDefaultAppViewPriority() {
        return this.iPSApplicationUI.getDefaultAppViewPriority();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5e94\u7528\u89c6\u56fe\u754c\u9762\u6837\u5f0f")
    public IPSSysCss getDefaultAppViewPSSysCss() {
        return this.iPSApplicationUI.getDefaultAppViewPSSysCss();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22\u6761\u4ef6\u5b58\u50a8")
    public boolean isEnableFilterStorage() {
        return this.iPSApplicationUI.isEnableFilterStorage();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6570\u636e\u770b\u677f")
    public boolean isEnableDynaDashboard() {
        return this.iPSApplicationUI.isEnableDynaDashboard();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u542f\u7528\u94fe\u63a5\u6a21\u5f0f", codelist="DEGridColLinkMode")
    public int getGridColumnEnableLink() {
        return this.iPSApplicationUI.getGridColumnEnableLink();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u542f\u7528\u8fc7\u6ee4\u5668\u6a21\u5f0f", codelist="DEGridColLinkMode")
    public int getGridColumnEnableFilter() {
        return this.iPSApplicationUI.getGridColumnEnableFilter();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6570\u636e\u90e8\u4ef6\u9ed8\u8ba4\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getMDCtrlEmptyTextPSLanguageRes() {
        return this.iPSApplicationUI.getMDCtrlEmptyTextPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u6570\u636e\u90e8\u4ef6\u9ed8\u8ba4\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getMDCtrlEmptyText() {
        return this.iPSApplicationUI.getMDCtrlEmptyText();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getFormItemEmptyText() {
        return this.iPSApplicationUI.getFormItemEmptyText();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u586b\u5145\u6700\u5c0f\u89e6\u53d1\u5b57\u7b26\u6570")
    public int getACMinChars() {
        return this.iPSApplicationUI.getACMinChars();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u586b\u5145\u6700\u5c0f\u89e6\u53d1\u5b57\u7b26\u6570", ignoredumpvalues="false")
    public boolean isEnableUIModelEx() {
        return this.iPSApplicationUI.isEnableUIModelEx();
    }
}

