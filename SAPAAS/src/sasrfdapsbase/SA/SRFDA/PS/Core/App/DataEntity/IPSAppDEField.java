/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFLogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u8be5\u6a21\u578b\u7531\u5b9e\u4f53\u5c5e\u6027\u6216\u670d\u52a1\u63a5\u53e3\u5c5e\u6027\u6295\u5c04")
public interface IPSAppDEField
extends IPSModelObject,
IPSAppDataEntityObject,
IPSDEFieldBase {
    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    @Override
    public String getCodeName();

    public IPSDEField getPSDEField();

    public int getOrderValue();

    public String getCodeName2();

    public IPSDEServiceAPIField getPSDEServiceAPIField();

    public boolean isKeyField();

    public boolean isMajorField();

    public int getStdDataType();

    public boolean isEnableQuickSearch();

    public String getValueFormat();

    public Iterator<IPSAppDEFLogic> getAllPSAppDEFLogics() throws Exception;

    public IPSAppDEFLogic getDefaultValuePSAppDEFLogic() throws Exception;

    public IPSAppDEFLogic getOnChangePSAppDEFLogic() throws Exception;

    public IPSAppDEFLogic getComputePSAppDEFLogic() throws Exception;

    public String getLogicName();

    public boolean isDataTypeField();

    public String getDefaultValueType();

    public String getDefaultValue();

    public IPSLanguageRes getLNPSLanguageRes();

    public boolean isEnableFrontOnly();

    public Iterator<IPSAppDEFUIMode> getAllPSAppDEFUIModes() throws Exception;

    public IPSAppDEFUIMode getPSAppDEFUIMode(String var1) throws Exception;

    public IPSAppDEFUIMode getPSAppDEFUIMode(String var1, boolean var2) throws Exception;

    public String getQuickSearchPlaceHolder();

    public IPSLanguageRes getQSPHPSLanguageRes();

    public String getPredefinedType();
}

