/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e\u9879\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEFUIMode")
public interface IPSDEFUIItem
extends IPSDEFieldObject,
IPSModelObject,
IPSDEFieldBase {
    public static final int OUTPUTCODELISTCONFIGMODE_NONE = 0;
    public static final int OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final int OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;

    public void init(ISRFDAGlobalHelper var1, IPSDEField var2, PSDEFUIMode var3) throws Exception;

    public String getDataItemName();

    public String getCaption(String var1);

    public String getOriginCaption();

    public String getCapLanResTag();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getEditorType();

    public String getEditorStyle();

    public boolean isAllowEmpty();

    public String getPSCodeListId();

    public String getRefPSDEId();

    public String getRefPSDEName() throws Exception;

    public IPSDataEntity getRefPSDE() throws Exception;

    public String getRefPSDEACModeId();

    public String getRefPSDEACModeName() throws Exception;

    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public String getRefPickupPSDEViewId();

    public String getRefPickupPSDEViewName();

    public String getRefPickupPSDEViewCodeName();

    public String getRefMPickupPSDEViewId();

    public String getRefMPickupPSDEViewName();

    public String getRefMPickupPSDEViewCodeName();

    public String getRefLinkPSDEViewId();

    public String getRefLinkPSDEViewName();

    public String getRefLinkPSDEViewCodeName();

    public String getValueFormat();

    public String getOriginValueFormat();

    public IPSDataEntity getRefPSDataEntity();

    public String getRefPSDEDataSetId();

    public String getRefPSDEDataSetName() throws Exception;

    public String getRefActiveDataPSDELogicId();

    public String getRefActiveDataPSDELogicName() throws Exception;

    public IPSDELogic getRefActiveDataPSDELogic() throws Exception;

    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public boolean isRefTempData();

    public String getCreateDVT();

    public String getCreateDV();

    public String getUpdateDVT();

    public String getUpdateDV();

    public Properties getEditorParams();

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public String getPSSysValueRuleId();

    public int getIgnoreInput();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    public String getPlaceHolder();

    public IPSSysImage getPSSysImage();

    public boolean isEnableResetItemName();

    public String getResetItemName();

    public String getUnitName();

    public int getUnitNameWidth();

    public IPSDEFInputTip getPSDEFInputTip();

    public boolean isEnableUnitName();

    public IPSSysUnit getPSSysUnit();

    public String getUnitLanResTag();

    public IPSLanguageRes getUnitPSLanguageRes();

    public IPSLanguageRes getPHPSLanguageRes();

    public String getPHLanResTag();

    public String getPSAjaxHandlerId();

    public boolean isIgnoreInputDefined();

    public IPSDERBase getRefPSDER() throws Exception;

    public String getRefPSDERId();

    public String getRefPSDERName() throws Exception;

    public String getRefLinkPSDEViewId(IPSApplication var1) throws Exception;

    public String getRefMPickupPSDEViewId(IPSApplication var1) throws Exception;

    public String getRefPickupPSDEViewId(IPSApplication var1) throws Exception;

    public boolean isMobileMode();

    public String getPSSysDictCatId();

    @Override
    public String getCodeName();

    public String getUIMode();

    public int getPrecision(IPSDEFieldBase var1);

    public int getStringLength(IPSDEFieldBase var1);

    public int getMinStringLength(IPSDEFieldBase var1);

    public String getMaxValueString(IPSDEFieldBase var1);

    public String getMinValueString(IPSDEFieldBase var1);

    public IPSSysValueRule getPSSysValueRule(IPSDEFieldBase var1) throws Exception;
}

