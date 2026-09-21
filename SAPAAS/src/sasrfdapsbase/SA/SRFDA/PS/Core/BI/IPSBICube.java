/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSBISchemeObject;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBICube
extends IPSBISchemeObject {
    @Override
    public String getCodeName();

    public IPSDataEntity getPSDataEntity();

    public IPSDEField getKeyPSDEField();

    public IPSDEField getTypePSDEField();

    public String getCubeTag();

    public String getCubeTag2();

    public Iterator<? extends IPSBICubeDimension> getAllPSBICubeDimensions() throws Exception;

    public IPSBICubeDimension getPSBICubeDimension(String var1) throws Exception;

    public IPSBICubeDimension getPSBICubeDimension(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSBICubeMeasure> getAllPSBICubeMeasures() throws Exception;

    public IPSBICubeMeasure getPSBICubeMeasure(String var1) throws Exception;

    public IPSBICubeMeasure getPSBICubeMeasure(String var1, boolean var2) throws Exception;

    public IPSDEDataSet getPSDEDataSet();

    public IPSSysUniRes getPSSysUniRes();

    public String getDrillDownPSDEViewId();

    public String getPortletPSDEUIActionGroupId();

    public String getDrillDetailPSDEViewId();

    public int getCubeOption();
}

