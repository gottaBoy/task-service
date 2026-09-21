/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSequence;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.math.BigInteger;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u503c\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysSequence")
public interface IPSSysSequence
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String SEQUENCETYPE_DB = "DB";
    public static final String SEQUENCETYPE_DE = "DE";
    public static final String SEQUENCETYPE_USER = "USER";
    public static final String SEQUENCETYPE_USER2 = "USER2";
    public static final String SEQUENCETYPE_USER3 = "USER3";
    public static final String SEQUENCETYPE_USER4 = "USER4";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysSequence var3) throws Exception;

    public String getSequenceType();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public IPSDataEntity getPSDataEntity();

    public IPSXCodeObject getRender();

    public String getSequenceTag();

    public String getSequenceTag2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public String getSequenceFormat();

    public BigInteger getMaxValue();

    public BigInteger getMinValue();

    public IPSDEField getKeyPSDEField();

    public IPSDEField getValuePSDEField();

    public String[] getExtFormatParams();

    public IPSDEField getTimePSDEField();

    public IPSDEField getTypePSDEField();

    public String getTimeFormat();

    public Properties getSequenceParams();
}

