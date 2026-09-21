/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEACMode
 */
package SA.SRFDA.PS.Core.DataEntity.AC;

import SA.SRFDA.PS.Core.AI.IPSSysAIChatAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACModeDataItem;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEACMode;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u81ea\u52a8\u586b\u5145\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEACMode")
public interface IPSDEACMode
extends IPSDataEntityObject,
IDEACMode {
    public static final String ACTYPE_AUTOCOMPLETE = "AUTOCOMPLETE";
    public static final String ACTYPE_CHATCOMPLETION = "CHATCOMPLETION";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEACMode var3) throws Exception;

    public String getACType();

    public boolean isDefaultMode();

    @Override
    public String getCodeName();

    public boolean isEnablePagingBar();

    public int getPagingMode();

    public int getPagingSize();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public IPSDEField getValuePSDEF();

    public IPSDEField getTextPSDEF();

    public IPSSysPFPlugin getItemsPSSysPFPlugin();

    public IPSSysPFPlugin getItemPSSysPFPlugin();

    public String getLogicName();

    public IPSLanguageRes getEmptyTextPSLanguageRes();

    public String getEmptyText();

    @Override
    public int getExtendMode();

    public IPSPFXCodeObject getItemRender();

    public IPSDEUIActionGroup getPSDEUIActionGroup();

    public String getPickupPSDEViewId();

    public String getPickupPSDEViewName();

    public String getLinkPSDEViewId();

    public String getLinkPSDEViewName();

    public Iterator<IPSDEACModeDataItem> getPSDEACModeDataItems();

    public String getItemPSLayoutPanelId();

    public IPSDEDataSet getPSDEDataSet();

    public int getActionHolder();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public IPSXCodeObject getRender();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public String getACTag();

    public String getACTag2();

    public String getACTag3();

    public String getACTag4();

    public int getScriptMode();

    public String getScriptCode();

    public IPSSysMsgTempl getHistoryPSSysMsgTempl() throws Exception;

    public IPSSysAIFactory getPSSysAIFactory() throws Exception;

    public IPSSysAIChatAgent getPSSysAIChatAgent() throws Exception;

    public Properties getACParams();
}

