/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u8fb9\u680f\u90e8\u4ef6\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDRGroup")
public interface IPSDEDRBarGroup
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEDRBar var2, IPSDEDRGroup var3) throws Exception;

    public IPSDEDRBar getPSDEDRBar();

    public String getCaption();

    public Iterator<IPSDEDRBarItem> getPSDEDRBarItems();

    public IPSDEDRGroup getPSDEDRGroup();

    public boolean isHidden();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSSysImage getPSSysImage();

    public IPSSysPFPlugin getHeaderPSSysPFPlugin();
}

