/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Data.PSSubSysSADEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSubSysSADEField")
public interface IPSSubSysServiceAPIDEField
extends IPSModelObject {
    public static final String FIELDTYPE_SIMPLE = "SIMPLE";
    public static final String FIELDTYPE_SUBSYSSADE = "SUBSYSSADE";

    public void init(ISRFDAGlobalHelper var1, IPSSubSysServiceAPIDE var2, PSSubSysSADEField var3) throws Exception;

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE();

    @Override
    public String getCodeName();

    public String getLogicName();

    public int getOrderValue();

    public String getCodeName2();

    public int getStdDataType();

    public boolean isKeyDEField();

    public boolean isMajorDEField();

    public String getDataType();

    public int getLength();

    public int getPrecision();

    public boolean isAllowEmpty();

    public IPSCodeList getPSCodeList();

    public String getFieldTag();

    public String getFieldTag2();

    public String getFieldType();

    public boolean isArray();

    public String getPredefinedType();

    public IPSSubSysServiceAPIDE getRefPSSubSysServiceAPIDE() throws Exception;
}

