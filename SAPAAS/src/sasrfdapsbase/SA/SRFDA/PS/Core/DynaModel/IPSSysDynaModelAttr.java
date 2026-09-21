/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModelAttr;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDynaModelAttr;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysDynaModelAttr
extends IPSDynaModelAttr,
IPSModelSortable {
    public void init(ISRFDAGlobalHelper var1, IPSSysDynaModel var2, PSSysDynaModelAttr var3) throws Exception;

    public IPSSysDynaModel getPSSysDynaModel();

    @Override
    public String getValueType();

    @Override
    public String getValue();

    public IPSDataEntity getRefPSDataEntity() throws Exception;

    public IPSDEFGroup getRefPSDEFGroup() throws Exception;

    public IPSCodeList getPSCodeList() throws Exception;

    public int getStdDataType();

    public boolean isArray();

    public IPSSysDynaModel getRefPSSysDynaModel() throws Exception;

    public boolean isAllowEmpty();

    public String getJsonFormat();
}

