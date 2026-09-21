/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEActionGroup", description="\u5b9e\u4f53\u884c\u4e3a\u7ec4\u5305\u542b\u5b9e\u4f53\u884c\u4e3a\u3001\u6570\u636e\u96c6\u5bf9\u8c61")
public interface IPSDEActionGroup
extends IPSDataEntityObject {
    public Iterator<IPSDEAction> getPSDEActions();

    public Iterator<IPSDEDataSet> getPSDEDataSets();

    public Iterator<IPSDEActionGroupDetail> getPSDEActionGroupDetails();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public boolean contains(IPSDEAction var1);

    public boolean contains(IPSDEDataSet var1);

    public String getGroupTag();

    public String getGroupTag2();
}

