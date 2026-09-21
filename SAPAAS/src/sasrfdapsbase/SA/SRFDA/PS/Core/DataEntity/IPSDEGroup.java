/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDEGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEGroupImpl", model="PSDEGroup")
public interface IPSDEGroup
extends IPSDataEntityObject,
IPSModelSortable {
    public static final String LOGICMODE_INITMODEL = "INITMODEL";
    public static final String LOGICMODE_SAMESTORAGE = "SAMESTORAGE";

    public Iterator<IPSDataEntity> getPSDataEntities();

    public Iterator<IPSDEGroupDetail> getPSDEGroupDetails();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public IPSSystem getPSSystem();

    public boolean contains(String var1);

    public boolean contains(IPSDataEntity var1);

    public IPSDEGroupDetail getPSDEGroupDetail(String var1, boolean var2) throws Exception;

    public String getLogicMode();

    public String getLogicParam();

    public String getLogicParam2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public String getGroupTag();

    public String getGroupTag2();
}

