/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDRItem", typefield="itemType")
public interface IPSDEDRItem
extends IPSModelObject,
IPSNavigateParamContainer {
    public static final String DRITEMTYPE_DER1N = "DER1N";
    public static final String DRITEMTYPE_SYSDER1N = "SYSDER1N";
    public static final String DRITEMTYPE_DER11 = "DER11";
    public static final String DRITEMTYPE_SYSDER11 = "SYSDER11";
    public static final String DRITEMTYPE_CUSTOM = "CUSTOM";
    public static final String ENABLEMODE_ALL = "ALL";
    public static final String ENABLEMODE_INWF = "INWF";
    public static final String ENABLEMODE_ALLWF = "ALLWF";
    public static final String ENABLEMODE_CUSTOM = "CUSTOM";
    public static final String ENABLEMODE_DEOPPRIV = "DEOPPRIV";
    public static final String ENABLEMODE_DELOGIC = "DELOGIC";
    public static final String ENABLEMODE_SCRIPT = "SCRIPT";
    public static final String ENABLEMODE_UNIRES = "UNIRES";
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDRItem var3) throws Exception;

    public String getCaption(String var1);

    public String getItemType();

    public String getPSDEDRGroupId();

    public String getPSDEViewId();

    public IPSSysImage getPSSysImage();

    public String getEnableMode();

    public String getCounterId();

    public IPSDEAction getTestPSDEAction();

    public IPSDEOPPriv getTestPSDEOPPriv();

    public IPSSysUniRes getTestPSSysUniRes();

    public JSONObject getViewParamJO();

    public IPSLanguageRes getCapPSLanguageRes();

    public JSONObject getParentDataJO(boolean var1);

    public JSONObject getParentDataJO();

    @Override
    public String getCodeName();

    public String getParamJOString();

    public String getContextJOString();

    public IPSDEDRGroup getPSDEDRGroup();

    public IPSDataEntity getViewPSDataEntity() throws Exception;

    public String getViewCodeName();

    public int getCounterMode();

    public IPSDELogic getTestPSDELogic();

    public String getTestScriptCode();

    public IPSSysPFPlugin getHeaderPSSysPFPlugin();
}

