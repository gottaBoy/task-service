/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataExportItem
 */
package SA.SRFDA.PS.Core.DataEntity.DataExport;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataExportItem;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGridCol")
public interface IPSDEDataExportItem
extends IPSModelObject,
IDEDataExportItem {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataExport var2, PSDEGridColumn var3) throws Exception;

    public IPSDEDataExport getPSDEDataExport();

    public IPSLanguageRes getCapPSLanguageRes();

    public IPSCodeList getPSCodeList();

    public IPSDEField getPSDEField();

    public String getPrivilegeId();

    public String getCaption();

    public String getFormat();

    public Object getDefaultValue();

    public String getCapLanResTag();

    public IPSDEDataExportGroup getPSDEDataExportGroup() throws Exception;

    public String getAlign();

    public boolean isHidden();

    public IPSAppDEField getPSAppDEField();

    public IPSSysTranslator getPSSysTranslator() throws Exception;
}

