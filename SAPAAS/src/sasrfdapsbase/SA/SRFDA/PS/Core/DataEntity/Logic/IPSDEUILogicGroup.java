/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCtrlLogicGroup")
public interface IPSDEUILogicGroup
extends IPSDataEntityObject {
    public Iterator<? extends IPSDEUILogicGroupDetail> getPSDEUILogicGroupDetails();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public IPSSystem getPSSystem();

    public String getParentPSDEUILogicGroupId();
}

