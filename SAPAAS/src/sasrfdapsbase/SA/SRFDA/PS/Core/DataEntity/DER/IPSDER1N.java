/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDER1N
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2ManyDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupObjectDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.Iterator;
import net.ibizsys.paas.core.IDER1N;

@PSModelExtendMeta(title="\u5b9e\u4f531\uff1aN\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DER1N"})
public interface IPSDER1N
extends IPSDERBase,
IPSDER1NBase,
IDER1N {
    public static final int EXPORTMAJORMODEL_SIMPLE = 1;

    public boolean isCloneRS();

    @Override
    public int getMasterRS();

    public boolean isEnableExtRestrict();

    public String getERMajorPSDEFId();

    public String getERMajorPSDEFName() throws Exception;

    public IPSDEField getERMajorPSDEF() throws Exception;

    public String getERMinorPSDEFId();

    public String getERMinorPSDEFName() throws Exception;

    public IPSDEField getERMinorPSDEF() throws Exception;

    @Override
    public int getRemoveOrder();

    @Override
    public int getRemoveActionType();

    @Override
    public String getRemoveRejectMsg();

    @Override
    public IPSLanguageRes getRRMPSLanguageRes();

    @Override
    public String getRRMLanResTag();

    @Override
    public String getRefPSDEDataSetId();

    @Override
    public String getRefPSDEDataSetName() throws Exception;

    @Override
    public String getRefPSDEACModeId();

    public String getRefPSDEACModeName() throws Exception;

    public IPSDEACMode getRefPSDEACMode() throws Exception;

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public boolean isEnableFKey();

    public int getTempDataOrder();

    @Override
    public String getRefPickupPSDEViewId();

    @Override
    public String getRefPickupPSDEViewName();

    @Override
    public String getRefMPickupPSDEViewId();

    @Override
    public String getRefMPickupPSDEViewName();

    public boolean isEnablePDEREQ();

    public IPSDER1N getMajorPPSDER1N() throws Exception;

    public IPSDER1N getMinorPPSDER1N() throws Exception;

    public IPSPickupDEField getPSPickupDEField() throws Exception;

    public int getExportModelOrder();

    public int getSyncExportModelMode();

    public String getFKeyName();

    @Override
    public String getRefLinkPSDEViewId();

    @Override
    public String getRefLinkPSDEViewName();

    public String getMinorXmlTagName();

    public Iterator<IPSDER1NDEFieldMap> getPSDER1NDEFieldMaps();

    public IPSDER1NDEFieldMap getCountPSDER1NDEFieldMap();

    public Iterator<String> getPSDER1NDEFieldMapQueryNames();

    public int getExportMajorModel();

    public IPSLinkDEField getPSPickupTextDEField() throws Exception;

    public IPSOne2ManyDataDEField getPSOne2ManyDataDEField() throws Exception;

    public boolean isNestedRS();

    public String getOriLinkPSDEViewId();

    public String getOriPickupPSDEViewId();

    public String getOriMPickupPSDEViewId();

    public boolean isRecursiveRS();

    public IPSPickupObjectDEField getPSPickupObjectDEField() throws Exception;

    public String getMobRefPickupPSDEViewId();

    public String getMobRefPickupPSDEViewName();

    public String getMobRefMPickupPSDEViewId();

    public String getMobRefMPickupPSDEViewName();

    public String getMobRefLinkPSDEViewId();

    public String getMobRefLinkPSDEViewName();

    public String getOriMobLinkPSDEViewId();

    public String getOriMobPickupPSDEViewId();

    public String getOriMobMPickupPSDEViewId();

    public boolean isEnableDEFieldWriteBack() throws Exception;

    public boolean isEnableDEFieldWriteBackDefault();

    public boolean isIngoreDEFieldRefreshDefault();

    @Override
    public int getMasterOrder();

    public String getPickupDEFName();

    @Override
    public IPSDEField getPickupPSDEField() throws Exception;

    @Override
    public IPSDEDataSet getNestedPSDEDataSet() throws Exception;

    @Override
    public String getNestedPSDEDataSetId();

    public int getSyncDataMode();

    public boolean isEnablePhysicalDEFieldUpdate();
}

