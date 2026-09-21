/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field;

import java.util.Properties;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFieldObject;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEFUIItem
extends IPSDEFieldObject,
IPSModelObject {
    public static final int OUTPUTCODELISTCONFIGMODE_NONE = 0;
    public static final int OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final int OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;

    public String getDataItemName();

    public String getCaption(String var1);

    public String getCapLanResTag();

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

    public String getRefMPickupPSDEViewId();

    public String getRefMPickupPSDEViewName();

    public String getRefLinkPSDEViewId();

    public String getRefLinkPSDEViewName();

    public String getValueFormat();

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

    public boolean isEnableUnitName();

    public String getUnitLanResTag();

    public String getPHLanResTag();

    public String getPSAjaxHandlerId();
}

