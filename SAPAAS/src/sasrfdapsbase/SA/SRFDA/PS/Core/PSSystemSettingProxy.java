/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;

public class PSSystemSettingProxy
extends PSObjectImpl
implements IPSSystemSetting {
    private IPSSystemSetting iPSSystemSetting = null;
    private IPSSystem iPSSystem = null;

    public PSSystemSettingProxy(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
        this.iPSSystemSetting = (IPSSystemSetting)((Object)iPSSystem);
    }

    @Override
    public String getName() {
        return this.iPSSystem.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6392\u5e8f\u6a21\u5f0f", codelist="SysDEFSortMode")
    public String getDEFieldSortMode() {
        return this.iPSSystemSetting.getDEFieldSortMode();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u65e0\u503c\u663e\u793a\u6587\u672c")
    public String getCLEmptyText() {
        return this.iPSSystemSetting.getCLEmptyText();
    }

    @Override
    public String getCLEmptyTextPSLanguageResId() {
        return this.iPSSystemSetting.getCLEmptyTextPSLanguageResId();
    }

    @Override
    public IPSSysEngineConfig getPSSysEngineConfig() {
        return this.iPSSystemSetting.getPSSysEngineConfig();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u8bb0\u5f55\u6570")
    public int getDEDataExportMaxRowCount() {
        return this.iPSSystemSetting.getDEDataExportMaxRowCount();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53\u6570\u636e\u96c6\u6700\u5927\u8bb0\u5f55\u6570", ignoredumpvalues="-1")
    public int getDEDataSetMaxRowCount() {
        return this.iPSSystemSetting.getDEDataSetMaxRowCount();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u6a21\u5f0f", codelist="SysServiceApiMode")
    public int getServiceAPIMode() {
        return this.iPSSystemSetting.getServiceAPIMode();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb", codelist="AccCtrlArch")
    public int getDataAccCtrlArch() {
        return this.iPSSystemSetting.getDataAccCtrlArch();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u4fee\u590d\u9879", codelist="EngineBugFix")
    public int getEngineBugFixs() {
        return this.iPSSystemSetting.getEngineBugFixs();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u641c\u7d22\u9879\u5bbd\u5ea6")
    public int getDEFSFItemWidth() {
        return this.iPSSystemSetting.getDEFSFItemWidth();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.iPSSystemSetting.getValueFormat();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSystem.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSTEM_SETTING";
    }

    @Override
    public String getId() {
        return this.iPSSystem.getId();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53d1\u5e03\u6570\u636e\u5e93\u7ed3\u6784")
    public boolean isPubDBModel() {
        return this.iPSSystemSetting.isPubDBModel();
    }

    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528\u6570\u636e\u5e93\u503c\u63d2\u5165\u66f4\u65b0\u6a21\u5f0f")
    public boolean isEnableDBValueInsertUpdateMode() {
        return this.iPSSystemSetting.isEnableDBValueInsertUpdateMode();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u8bed\u8a00\u8d44\u6e90\u9ed8\u8ba4\u5185\u5bb9")
    public boolean isEnableLanResDefaultContent() {
        return this.iPSSystemSetting.isEnableLanResDefaultContent();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u542f\u7528\u5b9e\u4f53\u6570\u636e\u7248\u672c\u80fd\u529b")
    public boolean isEnableDEDataVer() {
        return this.iPSSystemSetting.isEnableDEDataVer();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u903b\u8f91\u6a21\u5f0f", codelist="DEMSActionLogicMode")
    public int getDEMSActionLogicMode() {
        return this.iPSSystemSetting.getDEMSActionLogicMode();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5b9e\u4f53\u4e3b\u72b6\u6001\u884c\u4e3a\u63a7\u5236\u903b\u8f91\u6a21\u5f0f", codelist="DEMSActionLogicMode")
    public int getSubSysDEMSActionLogicMode() {
        return this.iPSSystemSetting.getSubSysDEMSActionLogicMode();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u542f\u7528\u5b9e\u4f53\u5173\u7cfb\u5916\u952e")
    public boolean isEnableDERFKey() {
        return this.iPSSystemSetting.isEnableDERFKey();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3a\u90e8\u4ef6\u9644\u52a0\u5b9e\u4f53\u5c5e\u6027\u9879")
    public boolean isAppendCtrlDEItems() {
        return this.iPSSystemSetting.isAppendCtrlDEItems();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u8ba1\u7b971\uff1aN\u5173\u7cfb\u7684\u6269\u5c55\u7ea6\u675f")
    public boolean isAutoCalcDER1NExtRestrict() {
        return this.iPSSystemSetting.isAutoCalcDER1NExtRestrict();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5b9e\u4f53\u5c5e\u6027\u7684\u9650\u5b9a\u754c\u9762\u903b\u8f91")
    public boolean isEnableDEFieldRestrictedUI() {
        return this.iPSSystemSetting.isAutoCalcDER1NExtRestrict();
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u9879\u81ea\u52a8\u663e\u793a\u6807\u9898")
    public boolean isPanelItemAutoShowCaption() {
        return this.iPSSystemSetting.isPanelItemAutoShowCaption();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u9ed8\u8ba4\u542f\u7528\u5ba1\u8ba1")
    public boolean isEnableDEFieldAudit() {
        return this.iPSSystemSetting.isEnableDEFieldAudit();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u670d\u52a1\u63a5\u53e3\u6a21\u578b\u589e\u5f3a")
    public boolean isEnableServiceAPIModelEx() {
        return this.iPSSystemSetting.isEnableServiceAPIModelEx();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u6a21\u578b\u589e\u5f3a")
    public boolean isEnableDEFSearchModeModelEx() {
        return this.iPSSystemSetting.isEnableDEFSearchModeModelEx();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u754c\u9762\u6a21\u578b\u589e\u5f3a")
    public boolean isEnableUIModelEx() {
        return this.iPSSystemSetting.isEnableUIModelEx();
    }

    @Override
    public boolean isFixCodeNameAutoCapitalize() {
        return this.iPSSystemSetting.isFixCodeNameAutoCapitalize();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5b9e\u4f53\u4fdd\u5b58\u884c\u4e3a\u6a21\u578b\u589e\u5f3a")
    public boolean isEnableDESaveActionModelEx() {
        return this.iPSSystemSetting.isEnableDESaveActionModelEx();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5b9e\u4f53\u7ee7\u627f\u6a21\u578b\u589e\u5f3a")
    public boolean isEnableDEInheritModelEx() {
        return this.iPSSystemSetting.isEnableDEInheritModelEx();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5b9e\u4f53\u83b7\u53d6\u8349\u7a3f\u884c\u4e3a\u6a21\u578b\u589e\u5f3a")
    public boolean isEnableDEGetDraftActionModelEx() {
        return this.iPSSystemSetting.isEnableDEGetDraftActionModelEx();
    }
}

