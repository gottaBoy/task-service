/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSPFPluginTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSPFPluginTempl var2) throws Exception;

    public String getCode(String var1);

    public IPSPF getPSPF();

    public String getPSPFPubCodeId();

    public String getPSPFPubCodeName();

    public BaseDataEntity getPSPFPluginTemplData(IPSPFStyle var1) throws Exception;
}

