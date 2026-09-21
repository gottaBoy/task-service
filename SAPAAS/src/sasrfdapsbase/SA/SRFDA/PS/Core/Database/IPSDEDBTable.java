/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u8868\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDBTable")
public interface IPSDEDBTable
extends IPSDataEntityObject {
    public static final String TABLETYPE_MAIN = "MAIN";

    public String getTableType();

    public IPSSysDBTable getPSSysDBTable();

    @Override
    public String getCodeName();

    public Iterator<IPSDEField> getAllPSDEFields() throws Exception;

    public String getPSSysDBTableId();
}

