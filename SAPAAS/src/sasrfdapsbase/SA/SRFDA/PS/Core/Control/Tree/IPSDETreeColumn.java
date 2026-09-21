/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.tree.ITreeGridColumn
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDETreeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeGridColumn;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8868\u683c\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeCol")
public interface IPSDETreeColumn
extends IPSModelObject,
IPSControlItem,
ITreeGridColumn {
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";

    public void init(ISRFDAGlobalHelper var1, IPSDETree var2, IPSDETreeColumn var3, PSDETreeColumn var4) throws Exception;

    public IPSDETree getPSDETree();

    @Override
    public String getCodeName();

    public String getWidthUnit();

    public int getWidth();

    public String getColumnType();

    public boolean isEnableSort();

    public IPSSysPFPlugin getRenderPSSysPFPlugin();

    public String getWidthString();

    public String getAlign();

    public boolean isHideDefault();

    public int getHideMode();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public boolean isEnableRowEdit();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public IPSLanguageRes getExcelCapPSLanguageRes();

    public String getColumnStyle();

    public IPSDETreeColumn getParentPSTreeColumn();

    public boolean isEnableExpand();

    public IPSSysCss getHeaderPSSysCss();

    public IPSSysCss getCellPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSPFXCodeObject getRender();

    public String getCaption();

    public String getDataItemName();

    public String getExcelCaption();

    public String getExcelCapLanResTag();

    public int getNoPrivDisplayMode();

    public int getEnableLink();
}

