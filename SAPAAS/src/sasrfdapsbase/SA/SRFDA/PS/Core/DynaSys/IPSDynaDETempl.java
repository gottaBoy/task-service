/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDEFormTempl;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDEViewTempl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDynaDETempl
extends IPSSystemObject,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSDynaDETempl var3) throws Exception;

    public IPSDataEntity getTemplPSDE();

    public IPSDEField getTypePSDEF();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public Iterator<IPSDynaDEViewTempl> getPSDynaDEViewTempls();

    public Iterator<IPSDynaDEFormTempl> getPSDynaDEFormTempls();
}

