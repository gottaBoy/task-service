/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import SA.SRFDA.PS.Data.PSSysTestDataItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTDItem")
public interface IPSSysTestDataItem
extends IPSModelObject {
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_VALUERANGE = "VALUERANGE";
    public static final String VALUETYPE_PICKUPVALUE = "PICKUPVALUE";
    public static final String VALUETYPE_CODELISTVALUE = "CODELISTVALUE";
    public static final String VALUETYPE_NULLVALUE = "NULLVALUE";

    public void init(ISRFDAGlobalHelper var1, IPSSysTestData var2, PSSysTestDataItem var3) throws Exception;

    public IPSSysTestData getPSSysTestData();

    public IPSSysTestData getRefPSSysTestData();

    public IPSDEField getPSDEField();

    public String getValueType();

    public IPSCodeList getPSCodeList();

    public IPSDataEntity getRefPSDataEntity();

    public IPSDEDataSet getRefPSDEDataSet();

    public void fillEntity(IPSSysTestDataInst var1) throws Exception;

    public int getStdDataType();

    public IPSSysSampleValue getPSSysSampleValue();

    public String getValue();

    public String[] getValues();

    public boolean isNullValue();
}

