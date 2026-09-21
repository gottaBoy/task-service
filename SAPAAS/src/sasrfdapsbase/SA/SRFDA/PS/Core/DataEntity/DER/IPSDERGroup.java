/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDERGroupImpl", model="PSDERGroup")
public interface IPSDERGroup
extends IPSDataEntityObject,
IPSModelSortable {
    public Iterator<IPSDERBase> getPSDERs();

    public Iterator<IPSDERGroupDetail> getPSDERGroupDetails();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public IPSSystem getPSSystem();

    public boolean contains(String var1);

    public boolean contains(IPSDERBase var1);

    public String getGroupTag();

    public String getGroupTag2();
}

