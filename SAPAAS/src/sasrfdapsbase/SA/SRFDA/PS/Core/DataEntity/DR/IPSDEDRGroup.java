/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEDRGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDRGroup")
public interface IPSDEDRGroup
extends IPSDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDRGroup var3) throws Exception;

    public String getCaption();

    public String getCaption(String var1);

    public IPSSysImage getPSSysImage();

    public IPSLanguageRes getCapPSLanguageRes();

    public boolean isHidden();

    @Override
    public String getCodeName();

    public IPSSysPFPlugin getHeaderPSSysPFPlugin();
}

