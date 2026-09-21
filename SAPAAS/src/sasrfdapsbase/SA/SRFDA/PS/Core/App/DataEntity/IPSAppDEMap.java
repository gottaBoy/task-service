/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMapField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6620\u5c04\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMap")
public interface IPSAppDEMap
extends IPSDEMap {
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDataEntity getDstPSAppDataEntity();

    public Iterator<? extends IPSAppDEMapField> getPSAppDEMapFields();

    public Iterator<? extends IPSAppDEMapAction> getPSAppDEMapActions();

    public Iterator<? extends IPSAppDEMapDataSet> getPSAppDEMapDataSets();
}

