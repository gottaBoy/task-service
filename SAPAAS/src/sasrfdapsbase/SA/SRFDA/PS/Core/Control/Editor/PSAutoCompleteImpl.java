/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Editor.IPSAutoComplete;
import SA.SRFDA.PS.Core.Control.Editor.IPSTextEditor;
import SA.SRFDA.PS.Core.Control.PSAjaxEditorImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"AC", "AC_FS", "AC_NOBUTTON", "AC_FS_NOBUTTON"})
public class PSAutoCompleteImpl
extends PSAjaxEditorImpl
implements IPSAutoComplete,
IPSTextEditor {
    private static final Log log = LogFactory.getLog(PSAutoCompleteImpl.class);
    private String strParamJOString = null;
    private String strContextJOString = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppCodeList iPSAppCodeList = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.isEnableAC() && this.getPSAppDEACMode() != null && this.getPSAppDEACMode().getPSDEUIActionGroup() != null) {
            this.registerPSUIActionGroup(null, this.getPSAppDEACMode().getPSDEUIActionGroup());
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u9608\u503c\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() {
        if (this.getPSEditorContainer().getPSCodeList() != null && this.getPSEditorContainer().getPSCodeList().isThresholdGroup()) {
            return this.getPSEditorContainer().getPSCodeList();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, modelreftype="IGNOREDESIGN")
    public IPSAppCodeList getPSAppCodeList() {
        try {
            if (this.iPSAppCodeList == null && this.getPSCodeList() != null) {
                this.iPSAppCodeList = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSAppCodeList(this.getPSCodeList(), !this.isEnableUIModelEx());
            }
            return this.iPSAppCodeList;
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u52a8\u586b\u5145")
    public boolean isEnableAC() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53")
    public IPSDataEntity getPSDataEntity() throws Exception {
        return this.getPSEditorContainer().getRefPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7ed3\u679c\u96c6\u5408")
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        return this.getPSEditorContainer().getRefPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u81ea\u586b\u6a21\u5f0f")
    public IPSDEACMode getPSDEACMode() throws Exception {
        return this.getPSEditorContainer().getRefPSDEACMode();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u53c2\u6570\u5bf9\u8c61")
    public JSONObject getItemParamJO() throws Exception {
        return this.getPSEditorContainer().getItemParam();
    }

    @Override
    @PSModelRTMeta(description="\u5fc5\u987b\u4e3a\u9009\u62e9\u6570\u636e[FORCESELECTION]")
    public boolean isForceSelection() {
        return this.getEditorParam("FORCESELECTION", false);
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4e0b\u62c9\u6309\u94ae[TRIGGER]")
    public boolean isShowTrigger() {
        return this.getEditorParam("TRIGGER", true);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() throws Exception {
        if (this.iPSAppDataEntity == null && this.getPSDataEntity() != null) {
            this.iPSAppDataEntity = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), !this.isEnableUIModelEx());
        }
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getPSAppDEDataSet() throws Exception {
        IPSAppDEMethod iPSAppDEMethod;
        if (this.getPSDEDataSet() == null) {
            return null;
        }
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity != null && (iPSAppDEMethod = iPSAppDataEntity.getPSAppDEMethod(this.getPSDEDataSet(), !this.isEnableUIModelEx())) instanceof IPSAppDEDataSet) {
            return (IPSAppDEDataSet)iPSAppDEMethod;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u5bf9\u8c61", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEACMode getPSAppDEACMode() throws Exception {
        if (this.getPSDEACMode() == null) {
            return null;
        }
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity != null) {
            return iPSAppDataEntity.getPSAppDEACMode(this.getPSDEACMode().getId(), !this.isEnableUIModelEx());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u53c2\u6570Json\u5b57\u7b26\u4e32")
    public String getParamJOString() {
        if (this.strParamJOString == null) {
            try {
                this.strParamJOString = PSAutoCompleteImpl.calcParamJOString(this.getItemParamJO());
            }
            catch (Exception ex) {
                log.error((Object)ex);
                this.strParamJOString = "";
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strParamJOString)) {
            return null;
        }
        return this.strParamJOString;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u4e0a\u4e0b\u6587Json\u5b57\u7b26\u4e32")
    public String getContextJOString() {
        if (this.strContextJOString == null) {
            try {
                this.strContextJOString = PSAutoCompleteImpl.calcContextJOString(this.getItemParamJO());
            }
            catch (Exception ex) {
                log.error((Object)ex);
                this.strContextJOString = "";
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strContextJOString)) {
            return null;
        }
        return this.strContextJOString;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u754c\u9762\u884c\u4e3a\u7ec4", child=true)
    public IPSUIActionGroup getPSUIActionGroup() throws Exception {
        if (this.isEnableAC() && this.getPSAppDEACMode() != null && this.getPSAppDEACMode().getPSDEUIActionGroup() != null) {
            return this.getPSAppDEACMode().getPSDEUIActionGroup();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u957f\u5ea6[MAXLENGTH]")
    public Integer getMaxLength() {
        return this.getEditorParam("MAXLENGTH", this.getDefaultMaxLength());
    }

    protected Integer getDefaultMaxLength() {
        String strValue = this.getEditorParam("DEFAULTMAXLENGTH", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Integer.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u957f\u5ea6[MINLENGTH]", ignoredumpvalues="0")
    public Integer getMinLength() {
        return this.getEditorParam("MINLENGTH", this.getDefaultMinLength());
    }

    protected Integer getDefaultMinLength() {
        String strValue = this.getEditorParam("DEFAULTMINLENGTH", "");
        if (StringHelper.isNullOrEmpty((String)strValue)) {
            return null;
        }
        try {
            return Integer.valueOf(strValue);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219", child=true)
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return this.getPSEditorContainer().getPSSysValueRule();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6700\u5927\u957f\u5ea6[SHOWMAXLENGTH]", ignoredumpvalues="false")
    public boolean isShowMaxLength() {
        return this.getEditorParam("SHOWMAXLENGTH", this.getDefaultShowMaxLength());
    }

    protected boolean getDefaultShowMaxLength() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u81ea\u586b\u6700\u5c0f\u5b57\u7b26\u6570[ACMINCHARS]", ignoredumpvalues="0")
    public int getACMinChars() {
        return this.getEditorParam("ACMINCHARS", this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSApplicationUI().getACMinChars());
    }
}

