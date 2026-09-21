/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Data.PSDEFGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFGroup")
@PSModelPFIgnoreMeta
public interface IPSDEFGroup
extends IPSDataEntityObject,
IPSModelSortable {
    public static final String GROUPTYPE_FIELDS = "FIELDS";
    public static final String GROUPTYPE_FORMITEMS = "FORMITEMS";
    public static final String GROUPTYPE_GRIDCOLUMNS = "GRIDCOLUMNS";
    public static final String GROUPTYPE_BASEFIELDS = "BASEFIELDS";
    public static final String GROUPTYPE_AUDITFIELDS = "AUDITFIELDS";
    public static final String LOGICMODE_SORT = "SORT";
    public static final String LOGICMODE_NOTSAME = "NOTSAME";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEFGroup var3) throws Exception;

    public Iterator<IPSDEField> getPSDEFields();

    public Iterator<IPSDEFGroupDetail> getPSDEFGroupDetails();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public String getDTOCodeName();

    public boolean contains(String var1);

    public boolean contains(IPSDEField var1);

    public String getGroupType();

    public IPSDEFGroupDetail getPSDEFGroupDetail(String var1, boolean var2) throws Exception;

    public String getLogicMode();

    public String getGroupTag();

    public String getGroupTag2();

    public String getLogicParam();

    public String getLogicParam2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

