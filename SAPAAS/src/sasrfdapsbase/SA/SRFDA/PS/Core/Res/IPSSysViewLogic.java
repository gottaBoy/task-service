/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogicParam;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u89c6\u56fe\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysViewLogic")
public interface IPSSysViewLogic
extends IPSSystemObject,
IPSViewLogic {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysViewLogic var3) throws Exception;

    public String getPSViewLogicTypeId();

    public IPSDEViewLogic getPSDEViewLogic();

    public IPSViewLogicType getPSViewLogicType();

    public Iterator<? extends IPSSysViewLogicParam> getPSSysViewLogicParams();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getPSDEId();

    public String getPSDEUILogicId();

    public String getPSSysPFPluginId();
}

