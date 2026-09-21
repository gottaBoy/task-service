/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Util;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Data.PSDEUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUtil")
public interface IPSDEUtil
extends IPSDataEntityObject {
    public static final String UTILTYPE_DATAAUDIT = "DATAAUDIT";
    public static final String UTILTYPE_DYNASTORAGE = "DYNASTORAGE";
    public static final String UTILTYPE_USER = "USER";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEUtil var3) throws Exception;

    public String getUtilType();

    public String getUtilTag();

    public String getUtilTag2();

    public String getUtilPSDEId();

    public String getUtilPSDE2Id();

    public String getUtilPSDE3Id();

    public String getUtilPSDE4Id();

    public String getUtilPSDE5Id();

    public String getUtilPSDE6Id();

    public String getUtilPSDE7Id();

    public String getUtilPSDE8Id();

    public String getUtilPSDE9Id();

    public String getUtilPSDE10Id();

    public String getUtilPSDE11Id();

    public String getUtilPSDE12Id();

    public String getUtilPSDE13Id();

    public String getUtilPSDE14Id();

    public String getUtilPSDE15Id();

    public String getUtilPSDE16Id();

    public String getUtilPSDE17Id();

    public String getUtilPSDE18Id();

    public String getUtilPSDE19Id();

    public String getUtilPSDE20Id();

    public String getUtilPSDEName();

    public String getUtilPSDE2Name();

    public String getUtilPSDE3Name();

    public String getUtilPSDE4Name();

    public String getUtilPSDE5Name();

    public String getUtilPSDE6Name();

    public String getUtilPSDE7Name();

    public String getUtilPSDE8Name();

    public String getUtilPSDE9Name();

    public String getUtilPSDE10Name();

    public String getUtilPSDE11Name();

    public String getUtilPSDE12Name();

    public String getUtilPSDE13Name();

    public String getUtilPSDE14Name();

    public String getUtilPSDE15Name();

    public String getUtilPSDE16Name();

    public String getUtilPSDE17Name();

    public String getUtilPSDE18Name();

    public String getUtilPSDE19Name();

    public String getUtilPSDE20Name();

    @Override
    public int getExtendMode();

    public IPSDataEntity getUtilPSDE() throws Exception;

    public IPSDataEntity getUtilPSDE2() throws Exception;

    public IPSDataEntity getUtilPSDE3() throws Exception;

    public IPSDataEntity getUtilPSDE4() throws Exception;

    public IPSDataEntity getUtilPSDE5() throws Exception;

    public IPSDataEntity getUtilPSDE6() throws Exception;

    public IPSDataEntity getUtilPSDE7() throws Exception;

    public IPSDataEntity getUtilPSDE8() throws Exception;

    public IPSDataEntity getUtilPSDE9() throws Exception;

    public IPSDataEntity getUtilPSDE10() throws Exception;

    public IPSDataEntity getUtilPSDE11() throws Exception;

    public IPSDataEntity getUtilPSDE12() throws Exception;

    public IPSDataEntity getUtilPSDE13() throws Exception;

    public IPSDataEntity getUtilPSDE14() throws Exception;

    public IPSDataEntity getUtilPSDE15() throws Exception;

    public IPSDataEntity getUtilPSDE16() throws Exception;

    public IPSDataEntity getUtilPSDE17() throws Exception;

    public IPSDataEntity getUtilPSDE18() throws Exception;

    public IPSDataEntity getUtilPSDE19() throws Exception;

    public IPSDataEntity getUtilPSDE20() throws Exception;

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception;

    public Properties getUtilParams();
}

