/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSThreshold;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSThresholdGroup
extends IPSSystemObject,
IPSSysSFPubObject,
IPSPFLogicCodeObject {
    public static final String THRESHOLDGROUPTYPE_STATIC = "STATIC";
    public static final String THRESHOLDGROUPTYPE_DYNAMIC = "DYNAMIC";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSThresholdGroup var3) throws Exception;

    public Iterator<? extends IPSThreshold> getPSThresholds() throws Exception;

    @Override
    public String getCodeName();

    public IPSDataEntity getPSDataEntity() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public IPSDEField getTextPSDEField() throws Exception;

    public IPSDEField getBeginValuePSDEField() throws Exception;

    public IPSDEField getEndValuePSDEField() throws Exception;

    public IPSDEField getIconClsPSDEField() throws Exception;

    public String getCustomCond();

    public IPSDEField getDataPSDEField() throws Exception;

    public String getThresholdGroupType();

    public String getThresholdGroupTag();

    public String getThresholdGroupTag2();
}

