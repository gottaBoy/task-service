/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDEFType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b\u6269\u5c55\u5b9a\u4e49\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysDEFType")
public interface IPSSysDEFType
extends IPSDEFieldType,
IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDEFType var3) throws Exception;

    public IPSDEFieldType getPSDEFieldType();

    public String getPSCodeListId();

    public String getPSSysValueRuleId();

    public String getPSSysUnitId();
}

