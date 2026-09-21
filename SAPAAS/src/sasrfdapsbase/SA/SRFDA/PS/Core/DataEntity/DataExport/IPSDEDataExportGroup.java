/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataExport;

import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDataExportGroup
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataExport var2, PSDEGridColumn var3) throws Exception;

    public IPSDEDataExport getPSDEDataExport();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCaption();

    public String getCapLanResTag();

    public IPSDEDataExportGroup getParentPSDEDataExportGroup() throws Exception;

    public int getGroupLevel() throws Exception;

    public String getAlign();
}

