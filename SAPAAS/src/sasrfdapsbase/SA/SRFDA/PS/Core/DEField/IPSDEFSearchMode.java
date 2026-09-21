/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEFSearchMode
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEFSearchMode;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFSFItem")
public interface IPSDEFSearchMode
extends IPSDEFieldObject,
IDEFSearchMode,
IPSModelObject {
    public static final String CONDOP_EXISTS = "EXISTS";
    public static final String CONDOP_NOTEXISTS = "NOTEXISTS";

    public void init(ISRFDAGlobalHelper var1, IPSDEField var2, PSDEFSearchMode var3) throws Exception;

    public String getPSDEFId();

    public String getPSSysDBVFId();

    public String getPSDBValueOPId();

    public String getValueOP();

    public IPSDEFFormItem getPSDEFFormItem(String var1);

    public IPSSysDBValueFunc getPSSysDBValueFunc();

    public int getExtendMode();

    public String getPSCodeListId();

    public boolean isDefault();

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public String getMode();

    @Override
    public String getCodeName();

    public String getServiceCodeName();

    public IPSDEDataQueryCodeExp getPSDEDataQueryCodeExp(String var1) throws Exception;

    public String getValueFunc();

    public int getStdDataType();

    public String getValueFormat();

    public String getPlaceHolder();

    public IPSLanguageRes getPHPSLanguageRes();

    public String getPHLanResTag();

    public String getJsonFormat();

    public IPSDERBase getPSDER() throws Exception;

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEField getDstPSDEField() throws Exception;

    public IPSDEFSearchMode getDstPSDEFSearchMode() throws Exception;

    public boolean isArray();

    public String getItemTag();

    public String getItemTag2();

    public String getValueSeparator();

    public IPSSysTranslator getPSSysTranslator() throws Exception;

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

