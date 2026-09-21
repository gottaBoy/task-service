/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRCtrl;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDRCtrl
extends IPSDRCtrl {
    public Iterator<IPSDEDRCtrlItem> getPSDEDRCtrlItems();

    public int getPSDEDRCtrlItemCount();

    public IPSAppView getFormPSAppView();

    public IPSDEDataRelation getPSDEDataRelation();

    public String getEditItemCaption();

    public IPSLanguageRes getEditItemCapPSLanguageRes();

    public IPSSysImage getEditItemPSSysImage();

    public boolean isHideEditItem();

    public String getUniqueTag();

    public String getDataRelationTag();

    public boolean isEnableCustomized();
}

