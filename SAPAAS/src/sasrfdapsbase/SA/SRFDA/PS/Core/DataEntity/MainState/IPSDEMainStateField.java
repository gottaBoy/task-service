/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEMainStateField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMSField")
public interface IPSDEMainStateField
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEMainState var2, PSDEMainStateField var3) throws Exception;

    public IPSDEMainState getPSDEMainState();

    public String getPSDEFieldId();

    public IPSDEField getPSDEField();

    public boolean isAllowMode();

    public String getDefaultValueType();

    public String getDefaultValue();
}

