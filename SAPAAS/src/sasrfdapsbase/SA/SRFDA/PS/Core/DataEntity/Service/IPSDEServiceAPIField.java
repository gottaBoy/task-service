/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;

@PSModelInterfaceMeta(title="\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEServiceAPIField
extends IPSModelObject,
IPSDEFieldBase {
    public IPSDEServiceAPI getPSDEServiceAPI();

    @Override
    public String getCodeName();

    public IPSDEField getPSDEField();

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

    public boolean isKeyField();

    public boolean isMajorField();

    public int getStdDataType();

    public boolean isEnableCreate();

    public boolean isEnableModify();

    public String getLogicName();

    public IPSLanguageRes getLNPSLanguageRes();
}

