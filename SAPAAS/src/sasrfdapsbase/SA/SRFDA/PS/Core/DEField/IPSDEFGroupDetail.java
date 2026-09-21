/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(implement="PSDEFGroupDetailImpl", title="\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFGroupDetail")
public interface IPSDEFGroupDetail
extends IPSModelSortable,
IPSModelObject,
IPSDEFieldBase {
    public IPSDEFGroup getPSDEFGroup();

    public IPSDEField getPSDEField();

    @Override
    public String getCodeName();

    @Override
    public int getOrderValue();

    public String getCodeName2();

    public boolean isAllowEmpty();

    @Override
    public int getStringLength();

    public IPSCodeList getPSCodeList() throws Exception;

    @Override
    public IPSSysValueRule getPSSysValueRule() throws Exception;

    public boolean isEnableUserInsert();

    public boolean isEnableUserUpdate();

    public boolean testUserInput(int var1);

    public int getUserInputMode();

    public String getLogicName();

    public String getDefaultValueType();

    public String getDefaultValue();

    public String getDetailParam();

    public String getDetailParam2();

    public IPSLanguageRes getLNPSLanguageRes();

    public String getJsonFormat();

    public Properties getSearchModes();

    public String getServiceCodeName();
}

