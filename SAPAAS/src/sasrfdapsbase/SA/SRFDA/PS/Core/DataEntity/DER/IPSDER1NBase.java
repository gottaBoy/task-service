/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;

@PSModelInterfaceMeta(title="1\u5bf9\u591a\u5173\u7cfb\u63a5\u53e3\u57fa\u7c7b", util=true)
public interface IPSDER1NBase
extends IPSDERBase {
    public static final int MASTERRS_REFCHECK = 256;
    public static final int MASTERRS_INHERIT = 1024;

    public IPSDEField getPickupPSDEField() throws Exception;

    public int getRemoveOrder();

    public int getRemoveActionType();

    public String getRemoveRejectMsg();

    public IPSLanguageRes getRRMPSLanguageRes();

    public String getRRMLanResTag();

    public int getMasterRS();

    public int getMasterOrder();

    public IPSDEDataSet getNestedPSDEDataSet() throws Exception;

    public String getNestedPSDEDataSetId();

    public String getRefPSDEDataSetId();

    public String getRefPSDEDataSetName() throws Exception;

    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public String getRefPickupPSDEViewId();

    public String getRefPickupPSDEViewName();

    public String getRefMPickupPSDEViewId();

    public String getRefMPickupPSDEViewName();

    public String getRefLinkPSDEViewId();

    public String getRefLinkPSDEViewName();

    public String getRefPSDEACModeId();

    public int getCustomExportOrder();

    public int getCustomExportOrder2();

    public int getCloneOrder();

    public String getRefPSDEFGroupId();

    public String getRefPSDEFGroupName() throws Exception;

    public IPSDEFGroup getRefPSDEFGroup() throws Exception;
}

