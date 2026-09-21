/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataImportItem
 */
package SA.SRFDA.PS.Core.DataEntity.DataImport;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEDataImportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataImportItem;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataImpItem")
public interface IPSDEDataImportItem
extends IPSModelObject,
IDEDataImportItem,
IPSModelSortable {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataImport var2, PSDEDataImportItem var3) throws Exception;

    public IPSDEDataImport getPSDEDataImport();

    public IPSDEField getPSDEField();

    public IPSLanguageRes getCapPSLanguageRes();

    public boolean isHiddenDataItem();

    public String getCreateDVT();

    public String getCreateDV();

    public String getUpdateDVT();

    public String getUpdateDV();

    public IPSCodeList getPSCodeList();

    public String getCaption();

    public boolean isUniqueItem();

    public IPSSysTranslator getPSSysTranslator() throws Exception;
}

