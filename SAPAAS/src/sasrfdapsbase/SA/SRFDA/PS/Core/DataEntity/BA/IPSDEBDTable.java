/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEBATable
 */
package SA.SRFDA.PS.Core.DataEntity.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEBATable;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5927\u6570\u636e\u8868\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBDTableDE")
public interface IPSDEBDTable
extends IPSDataEntityObject,
IPSSFCodeObject,
IDEBATable {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSSysBDTableDE var3) throws Exception;

    public IPSSysBDScheme getPSSysBDScheme() throws Exception;

    @Override
    public String getCodeName();

    public int getBDTableDEType();

    public IPSSysBDTable getPSSysBDTable() throws Exception;
}

