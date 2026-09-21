/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.JIT;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDESampleData;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u793a\u4f8b\u6570\u636e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDESampleData")
public interface IPSDESampleData
extends IPSDataEntityObject {
    public static final String RANDOMMODE_DEFAULT = "DEFAULT";
    public static final String DATATYPE_JSON = "JSON";
    public static final String DATATYPE_XML = "XML";
    public static final String DATATYPE_SCRIPT = "SCRIPT";
    public static final String DATATYPE_USER = "USER";
    public static final String LOGICMODE_INSTALLDATA = "INSTALLDATA";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDESampleData var3) throws Exception;

    public JSONObject getDataJO() throws Exception;

    public String getJOString();

    public String getRandomMode();

    public String getRandomParam();

    public String getRandomParam2();

    public int getRandomParam3();

    public int getRandomParam4();

    public int getRandomCount();

    @Override
    public String getCodeName();

    public IPSDEMainState getPSDEMainState();

    public String getDataType();

    public String getLogicMode();

    public String getData();
}

