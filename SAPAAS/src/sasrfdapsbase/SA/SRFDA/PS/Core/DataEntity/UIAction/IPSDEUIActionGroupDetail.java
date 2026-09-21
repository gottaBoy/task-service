/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUAGroupDetail")
public interface IPSDEUIActionGroupDetail
extends IPSUIActionGroupDetail {
    public static final String DETAILTYPE_DEUIACTION = "DEUIACTION";
    public static final String DETAILTYPE_SEPERATOR = "SEPERATOR";
    public static final String DETAILTYPE_DEUIACTIONGROUP = "DEUIACTIONGROUP";
    public static final String BEFOREITEMTYPE_NONE = "NONE";
    public static final String BEFOREITEMTYPE_RAW = "RAW";
    public static final String AFTERITEMTYPE_NONE = "NONE";
    public static final String AFTERITEMTYPE_RAW = "RAW";

    public void init(ISRFDAGlobalHelper var1, IPSDEUIActionGroup var2, PSDEUIActionGroupDetail var3) throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup();

    public IPSDEUIAction getPSDEUIAction();

    public String getDetailType();

    public String getBeforeItemType();

    public String getBeforeContent();

    public String getBeforeOriContent();

    public IPSSysResource getBeforePSSysResource();

    public String getBeforePSSysCssId();

    public IPSLanguageRes getBeforePSLanguageRes();

    public String getAfterItemType();

    public String getAfterContent();

    public String getAfterOriContent();

    public IPSSysResource getAfterPSSysResource();

    public String getAfterPSSysCssId();

    public IPSLanguageRes getAfterPSLanguageRes();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public IPSUIActionGroup getRefPSUIActionGroup();
}

