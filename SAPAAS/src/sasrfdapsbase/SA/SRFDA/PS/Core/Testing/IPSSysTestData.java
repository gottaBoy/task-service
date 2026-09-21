/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataItem;
import SA.SRFDA.PS.Data.PSSysTestData;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysTestData")
public interface IPSSysTestData
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String TESTDATATYPE_DATA = "DATA";
    public static final String TESTDATATYPE_CUSTOMCODE = "CUSTOMCODE";
    public static final String TESTDATATYPE_USER = "USER";
    public static final String TESTDATATYPE_USER2 = "USER2";
    public static final String TESTDATATYPE_USER3 = "USER3";
    public static final String TESTDATATYPE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysTestData var3) throws Exception;

    public IPSDataEntity getPSDataEntity();

    public Iterator<IPSSysTestDataInst> getPSSysTestDataInsts() throws Exception;

    public IPSSysTestDataInst getPSSysTestDataInst(int var1) throws Exception;

    public Iterator<IPSSysTestDataItem> getPSSysTestDataItems();

    public boolean isBaseMode();

    public int getInstCount();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getData();

    public String getTestDataType();

    public String getScriptCode();
}

