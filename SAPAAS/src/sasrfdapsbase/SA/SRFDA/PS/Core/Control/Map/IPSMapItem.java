/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IMapItemModel
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.Control.IPSControlObjectNavigatable;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.Map.IPSMapItemDataItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenu;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.IMapItemModel;

@PSModelInterfaceMeta(title="\u5730\u56fe\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", model="PSSysMapItem")
public interface IPSMapItem
extends IPSModelObject,
IPSControlItem,
IMapItemModel,
IPSControlXDataContainer,
IPSControlMDataContainer,
IPSControlObjectNavigatable,
IPSModelSortable {
    public IPSDataEntity getPSDataEntity();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getPSSysCss();

    public IPSDEContextMenu getPSDEContextMenu();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public String getRemovePSDEActionName();

    public String getRemovePSDEOPPrivName();

    public IPSLanguageRes getNamePSLanguageRes();

    public Iterator<IPSMapItemDataItem> getPSMapItemDataItems();

    public String getModelObj();

    @Override
    public IPSAppDataEntity getPSAppDataEntity();

    public String getItemStyle();

    public String getIconCls();

    public String getIconPath();

    public String getItemType();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getRemoveDataAccessAction();

    public String getTipsField();

    public String getContentField();

    public String getLongitudeField();

    public String getLatitudeField();

    public String getAltitudeField();

    public String getColorField();

    public String getBKColorField();

    public int getMaxSize();

    public String getColor();

    public String getBKColor();

    public String getBorderColor();

    public int getBorderWidth();

    public int getRadius();

    public String getDynaClass();

    public String getShapeDynaClass();

    public IPSSysCss getShapePSSysCss();
}

