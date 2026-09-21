/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroupDetail;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUIActionGroup")
public interface IPSDEUIActionGroup
extends IPSDataEntityObject,
IPSUIActionGroup,
IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, IPSDataEntity var3, PSDEUIActionGroup var4) throws Exception;

    public Iterator<IPSDEUIAction> getPSDEUIActions();

    public Iterator<IPSDEUIActionGroupDetail> getPSDEUIActionGroupDetails();
}

