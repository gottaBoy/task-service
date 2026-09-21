/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSControlParamImpl", model="PSDEViewCtrl")
public interface IPSControlParam
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSAppView var2, PSDEViewCtrl var3) throws Exception;

    public PSDEViewCtrl getPSDEViewCtrlData();

    public IPSAppView getPSAppView();

    public Object getCtrlParam(String var1);

    public boolean containsCtrlParam(String var1);

    public String getCtrlParam(String var1, String var2);

    public boolean getCtrlParam(String var1, boolean var2);

    public int getCtrlParam(String var1, int var2);

    public Iterator<String> getCtrlParamNames();

    public Double getWidth();

    public Double getHeight();

    public Integer getOrderValue();

    public String getCtrlParam();

    public String getCtrlParam2();

    public String getPSSysPFPluginId();

    public String getPSSysCssId();

    public String getPSCtrlMsgId();

    public Boolean isDefaultCtrl();

    @Override
    public String getUserTag();

    @Override
    public String getUserTag2();

    public String getPSDEUILogicGroupId();

    public String getPSDynaModelId();

    public Properties getCtrlParams();

    public String getRefCtrlName();

    public String getRefCtrl2Name();

    public String getInstallUIEngine();

    public String getInstallUIEngine2();

    public String getPredefinedType();

    public String getPSDEId();

    public Integer getDynaSysMode();

    public Integer getPriority();
}

