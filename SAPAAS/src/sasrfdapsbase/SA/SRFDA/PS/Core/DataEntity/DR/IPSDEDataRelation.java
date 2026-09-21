/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataRelation")
public interface IPSDEDataRelation
extends IPSDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDataRelation var3) throws Exception;

    public Iterator<IPSDEDRDetail> getPSDEDRDetails();

    public Iterator<IPSDEDRGroup> getPSDEDRGroups();

    @Override
    public String getCodeName();

    public String getPSSysCounterId();

    public String getFormPSDEViewBaseId();

    public String getFormCaption();

    public IPSLanguageRes getFormCapPSLanguageRes();

    public IPSSysImage getFormPSSysImage();

    public boolean isHideEditItem();

    public String getPSDEUILogicGroupId();

    public boolean isEnableCustomized();

    public IPSSysCounter getPSSysCounter();
}

