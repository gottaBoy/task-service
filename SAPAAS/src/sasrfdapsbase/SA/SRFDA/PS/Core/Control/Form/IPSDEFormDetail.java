/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.IPSThickness;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u6210\u5458\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="detailType", model="PSDEFormDetail")
public interface IPSDEFormDetail
extends IPSModelObject,
IPSControlItem {
    public static final String DETAILTYPE_FORMPAGE = "FORMPAGE";
    public static final String DETAILTYPE_TABPANEL = "TABPANEL";
    public static final String DETAILTYPE_TABPAGE = "TABPAGE";
    public static final String DETAILTYPE_FORMITEM = "FORMITEM";
    public static final String DETAILTYPE_USERCONTROL = "USERCONTROL";
    public static final String DETAILTYPE_FORMPART = "FORMPART";
    public static final String DETAILTYPE_GROUPPANEL = "GROUPPANEL";
    public static final String DETAILTYPE_DRUIPART = "DRUIPART";
    public static final String DETAILTYPE_BUTTON = "BUTTON";
    public static final String DETAILTYPE_RAWITEM = "RAWITEM";
    public static final String DETAILTYPE_IFRAME = "IFRAME";
    public static final String DETAILTYPE_FORMITEMEX = "FORMITEMEX";
    public static final String DETAILTYPE_MDCTRL = "MDCTRL";
    public static final String DETAILTYPE_BUTTONLIST = "BUTTONLIST";
    public static final String DETAILSTYLE_DEFAULT = "DEFAULT";
    public static final String DETAILSTYLE_STYLE2 = "STYLE2";
    public static final String DETAILSTYLE_STYLE3 = "STYLE3";
    public static final String DETAILSTYLE_STYLE4 = "STYLE4";
    public static final String BORERLAYOUTPOS_NORTH = "NORTH";
    public static final String BORERLAYOUTPOS_WEST = "WEST";
    public static final String BORERLAYOUTPOS_EAST = "EAST";
    public static final String BORERLAYOUTPOS_SOUTH = "SOUTH";
    public static final String BORERLAYOUTPOS_CENTER = "CENTER";
    public static final int SHOWMOREMODE_NONE = 0;
    public static final int SHOWMOREMODE_CONTENT = 1;
    public static final int SHOWMOREMODE_MANAGE = 2;
    public static final int COUNTERMODE_NONE = 0;
    public static final int COUNTERMODE_HIDEZERO = 1;

    public void init(ISRFDAGlobalHelper var1, IPSDEForm var2, IPSDEFormDetail var3, PSDEFormDetail var4) throws Exception;

    @Override
    public String getCodeName();

    public void layout() throws Exception;

    public String getUniqueId();

    public IPSDEFormDetail getParentPSDEFormDetail();

    public String getCaption();

    public boolean isShowCaption();

    public IPSThickness getPadding();

    public IPSThickness getMargin();

    public IPSDEForm getPSDEForm();

    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> var1);

    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> var1);

    public String getDetailType();

    public double getContentWidth();

    public double getContentHeight();

    public double getWidth();

    public double getHeight();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillEmbeddedPSAppViewRefs(String var1, ArrayList<IPSAppViewRef> var2) throws Exception;

    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> var1);

    public String getParentLayoutMode();

    public IPSDEFDCatGroupLogic getPSDEFDGroupLogic(String var1) throws Exception;

    public String getCssStyle();

    public int getColSpan() throws Exception;

    public int getRowSpan() throws Exception;

    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public String getColCssClass();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSSysCounter getPSSysCounter();

    public String getCounterId();

    public int getCounterMode();

    public IPSAppCounterRef getPSAppCounterRef();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysCss getLabelPSSysCss();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public int getColWidth();

    public IPSDEFormDetail getRootPSDEFormDetail();

    public String getDetailStyle();

    public String getBorderLayoutPos();

    public Iterator<IPSDEFDCatGroupLogic> getPSDEFDGroupLogics();

    public IPSLayoutPos getPSLayoutPos();

    public Iterator<IPSDEFDLogic> getAllPSDEFDLogics();

    public IPSLayout getPSLayout();

    public IPSPFXCodeObject getRender();

    public boolean isRepeatContent();

    public int getShowMoreMode();

    public IPSDEFormDetail getShowMoreMgrPSDEFormDetail();

    public String getDynaClass();

    public String getColumnAlign();

    public String getLabelCssStyle();

    public String getLabelDynaClass();

    public int getModelState();
}

