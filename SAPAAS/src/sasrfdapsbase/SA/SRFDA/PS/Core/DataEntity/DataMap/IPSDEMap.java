/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapAction;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSysRefDE;
import SA.SRFDA.PS.Data.PSDEMap;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6620\u5c04\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMap")
public interface IPSDEMap
extends IPSDataEntityObject {
    public static final String MAPGROUP_DEFAULT = "DEFAULT";
    public static final String MAPGROUP_GROUP2 = "GROUP2";
    public static final String MAPGROUP_GROUP3 = "GROUP3";
    public static final String MAPGROUP_GROUP4 = "GROUP4";
    public static final int LOGICHOLDER_NONE = 0;
    public static final int LOGICHOLDER_BACKEND = 1;
    public static final int LOGICHOLDER_FRONT = 2;
    public static final int LOGICHOLDER_BACKENDANDFRONT = 3;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEMap var3) throws Exception;

    public Iterator<IPSDEMapField> getPSDEMapDetails();

    public Iterator<IPSDEMapField> getPSDEMapFields();

    public Iterator<IPSDEMapAction> getPSDEMapActions();

    public Iterator<IPSDEMapDataQuery> getPSDEMapDataQueries();

    public Iterator<IPSDEMapDataSet> getPSDEMapDataSets();

    @Override
    public String getCodeName();

    public String getMapTarget();

    public String getPSSysRefId();

    public String getDstPSSysRefDEId();

    public IPSSysRef getPSSysRef();

    public IPSSysRefDE getDstPSSysRefDE();

    public String getLogicName();

    public boolean testMapGroup(String var1);

    public IPSDataEntity getDstPSDE();

    public boolean isAutoDEFieldMap();

    public boolean isAutoDEActionMap();

    public boolean isAutoDEDataQueryMap();

    public boolean isAutoDEDataSetMap();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public Properties getMapParams();

    public String getMapMode();

    public boolean isValid();

    public int getLogicHolder();

    public boolean isEnableBackend();

    public boolean isEnableFront();
}

