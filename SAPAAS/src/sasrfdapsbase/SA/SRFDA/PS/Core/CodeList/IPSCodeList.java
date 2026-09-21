/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.codelist.ICodeList
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;

@PSModelInterfaceMeta(title="\u4ee3\u7801\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCodeList")
public interface IPSCodeList
extends IPSSystemObject,
ICodeList,
IPSSFCodeObject,
IPSSysSFPubObject,
IPSPFLogicCodeObject {
    public static final String PREDEFINEDTYPE_OPERATOR = "OPERATOR";
    public static final String PREDEFINEDTYPE_RUNTIME = "RUNTIME";
    public static final String PREDEFINEDTYPE_MODULEINST = "MODULEINST";
    public static final String PREDEFINEDTYPE_DEMAINSTATE = "DEMAINSTATE";
    public static final int INCBEGINVALUEMODE_NO = 0;
    public static final int INCBEGINVALUEMODE_YES = 1;
    public static final int INCBEGINVALUEMODE_FIRST = 2;
    public static final int INCBEGINVALUEMODE_LAST = 3;
    public static final int INCENDVALUEMODE_NO = 0;
    public static final int INCENDVALUEMODE_YES = 1;
    public static final int INCENDVALUEMODE_FIRST = 2;
    public static final int INCENDVALUEMODE_LAST = 3;

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSCodeList var3) throws Exception;

    public String getPSCodeListTemplId();

    public Iterator<IPSCodeItem> getPSCodeItems() throws Exception;

    @Override
    public String getCodeName();

    public IPSDataEntity getPSDataEntity() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public boolean getRefFlag();

    public boolean isCodeItemValueNumber();

    public String getPredefinedType();

    public boolean isSubSysCodeList();

    public IPSSystemModule getPSSystemModule();

    public IPSDEField getTextPSDEField() throws Exception;

    public IPSDEField getValuePSDEField() throws Exception;

    public IPSDEField getMinorSortPSDEField() throws Exception;

    public String getMinorSortDir();

    public IPSDEField getIconClsPSDEField() throws Exception;

    public IPSDEField getIconClsXPSDEField() throws Exception;

    public IPSDEField getIconPathPSDEField() throws Exception;

    public IPSDEField getIconPathXPSDEField() throws Exception;

    public boolean isUserRef();

    public void markSysRef(Object var1, String var2);

    public String getFetchCondition();

    public IPSDEField getPValuePSDEField() throws Exception;

    public int getExtendMode();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public boolean isEnableDynaSys();

    public IPSDEField getDisablePSDEField() throws Exception;

    public String getSystemTag();

    public IPSSysRef getPSSysRef();

    public Iterator<IPSCodeItem> getAllPSCodeItems();

    public boolean isSubSysAsCloud();

    public String getLinkPSDEViewId();

    public boolean isEnableCache();

    public int getCacheTimeout();

    public IPSDEField getDataPSDEField() throws Exception;

    public boolean isModuleInstCodeList();

    @Override
    public int getDynaInstMode();

    @Override
    public String getDynaInstTag();

    @Override
    public String getDynaInstTag2();

    public String getCodeListType();

    public String getHandler();

    public boolean isUserScope();

    public String getOrMode();

    public String getValueSeparator();

    public String getTextSeparator();

    public String getEmptyText();

    public String getCustomCond();

    public boolean isThresholdGroup();

    public IPSDEField getBeginValuePSDEField() throws Exception;

    public IPSDEField getEndValuePSDEField() throws Exception;

    public int getIncBeginValueMode();

    public int getIncEndValueMode();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public String getCodeListTag();

    public IPSDEMSLogic getPSDEMSLogic() throws Exception;

    public int getDynaSysMode();

    public IPSDEField getClsPSDEField() throws Exception;

    public IPSDEField getColorPSDEField() throws Exception;

    public IPSDEField getBKColorPSDEField() throws Exception;

    public String getAllText();

    public IPSLanguageRes getAllTextPSLanguageRes();
}

