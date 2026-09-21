/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQColumn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDQJoin")
public interface IPSDEDQJoin
extends IPSModelObject {
    public static final String JOINTYPE_1N = "1N";
    public static final String JOINTYPE_1NNOT = "1NNOT";
    public static final String JOINTYPE_1N_LEFTOUT = "1NLEFTOUT";
    public static final String JOINTYPE_N1 = "N1";
    public static final String JOINTYPE_N1RIGHT = "N1RIGHT";
    public static final String JOINTYPE_11 = "11";
    public static final String JOINTYPE_11M = "11M";
    public static final String JOINTYPE_INDEX = "INDEX";
    public static final String JOINTYPE_INDEXM = "INDEXM";
    public static final String JOINTYPE_CUSTOMN1 = "CUSTOMN1";
    public static final String JOINTYPE_CUSTOM1N = "CUSTOM1N";
    public static final String JOINTYPE_CUSTOM1NNOT = "CUSTOM1NNOT";

    public void init(ISRFDAGlobalHelper var1, IPSDEDataQuery var2, IPSDEDQJoin var3, PSDEDataQueryJoin var4) throws Exception;

    public IPSDEDataQuery getPSDEDataQuery();

    public String getJoinType();

    public IPSDataEntity getJoinPSDataEntity();

    public String getAlias();

    public Iterator<IPSDEDQJoin> getChildPSDEDQJoins();

    public String getDERId();

    public IPSDEDQGroupCondition getPSDEDQGroupCondition();

    public Iterator<IPSDEDQColumn> getSelectedPSDEDQColumns();

    public IPSDERBase getJoinPSDER() throws Exception;

    public IPSDataEntity getDERPSDataEntity() throws Exception;

    public String getJoinTag();

    public String getJoinTag2();
}

