/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEUniState
 */
package SA.SRFDA.PS.Core.DataEntity.UniState;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEUniState;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysUniState")
public interface IPSDEUniState
extends IPSDataEntityObject,
IDEUniState {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSSysUniState var3) throws Exception;

    public boolean isDefault();

    public IPSSysUniState getPSSysUniState();

    @Override
    public String getCodeName();
}

