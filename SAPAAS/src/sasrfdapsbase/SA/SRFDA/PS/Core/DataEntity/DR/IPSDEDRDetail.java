/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDRDetail")
public interface IPSDEDRDetail
extends IPSModelObject {
    public static final String DETAILTYPE_DRITEM = "DRITEM";
    public static final String DETAILTYPE_PDTVIEW = "PDTVIEW";
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    public void init(ISRFDAGlobalHelper var1, IPSDEDataRelation var2, PSDEDRDetail var3) throws Exception;

    public IPSDEDataRelation getPSDEDR();

    public String getCaption();

    public String getCaption(String var1);

    public String getDetailType();

    public String getPSDEDRGroupId();

    public String getPSDEViewId();

    public String getPSDEDRItemId();

    public IPSDEDRItem getPSDEDRItem();

    public IPSSysPDTView getPSSysPDTView();

    public IPSSysImage getPSSysImage();

    public String getEnableMode();

    public String getCounterId();

    public IPSDEAction getTestPSDEAction();

    public IPSDEOPPriv getTestPSDEOPPriv();

    public IPSSysUniRes getTestPSSysUniRes();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getPSDETreeId();

    public IPSDEDRGroup getPSDEDRGroup();

    public String getOriginCaption();

    public int getOrderValue();

    public int getCounterMode();

    public IPSDELogic getTestPSDELogic();

    public String getTestScriptCode();

    public String getDetailTag();

    public String getDetailTag2();

    public String getData();

    public IPSSysPFPlugin getHeaderPSSysPFPlugin();
}

