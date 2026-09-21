/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBSchemeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDBTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u6570\u636e\u5e93\u8868\u5bf9\u8c61\u63a5\u53e3", model="PSSysDBTable")
public interface IPSSysDBTable
extends IPSSysDBSchemeObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysDBScheme var2, PSSysDBTable var3) throws Exception;

    @Override
    public String getCodeName();

    public String getLogicName();

    public Iterator<IPSSysDBColumn> getAllPSSysDBColumns() throws Exception;

    public IPSSysDBColumn getPSSysDBColumn(String var1) throws Exception;

    public IPSSysDBColumn getPSSysDBColumn(String var1, boolean var2) throws Exception;

    public void resetPSSysDBColumn(String var1) throws Exception;

    public void resetAllPSSysDBColumns();

    public void load(int var1) throws Exception;

    public int getLoadingLevel();

    public int getLoadedLevel();

    public boolean isExistingModel();

    public boolean isAutoExtendModel();

    public String getCreateSql();

    public String getDropSql();

    public String getNameByDBType(String var1) throws Exception;

    public Iterator<IPSSysDBIndex> getAllPSSysDBIndices() throws Exception;

    public String getTableTag();

    public String getTableTag2();
}

