/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSampleValue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u793a\u4f8b\u503c\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysSampleValue")
public interface IPSSysSampleValue
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysSampleValue var3) throws Exception;

    public boolean isNullValue();

    public String getSampleValue(boolean var1);

    public String getValue();

    public String getRandomValue();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public String[] getValues();
}

