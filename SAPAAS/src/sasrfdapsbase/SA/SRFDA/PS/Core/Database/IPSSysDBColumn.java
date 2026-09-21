/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBTableObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDBColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u6570\u636e\u5e93\u5217\u5bf9\u8c61\u63a5\u53e3", model="PSSysDBColumn")
public interface IPSSysDBColumn
extends IPSSysDBTableObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysDBTable var2, PSSysDBColumn var3) throws Exception;

    @Override
    public String getCodeName();

    public String getLogicName();

    public String getCodeName2();

    public int getStdDataType();

    public String getDataType();

    public boolean isPKey();

    public int getLength() throws Exception;

    public int getPrecision() throws Exception;

    public int getScale() throws Exception;

    public String getDefaultValue() throws Exception;

    public boolean isAutoIncrement();

    public boolean isUnsigned();

    public boolean isNullable();

    public String getCreateSql();

    public String getDropSql();

    public boolean isFKey();

    public IPSSysDBTable getRefPSSysDBTable() throws Exception;

    public IPSSysDBColumn getRefPSSysDBColumn() throws Exception;

    public String getNameByDBType(String var1) throws Exception;

    public String getColumnTag();

    public String getColumnTag2();
}

