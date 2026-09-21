/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDELogic
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginSupportable;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import java.util.Iterator;
import net.ibizsys.paas.core.IDELogic;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogic", typefield="logicSubType", implement="PSDELogicImpl")
public interface IPSDELogic
extends IPSDataEntityObject,
IPSDELogicBase,
IDELogic,
IPSSysSFPluginSupportable {
    public static final String LOGICSUBTYPE_NONE = "NONE";
    public static final String LOGICSUBTYPE_DEFIELD = "DEFIELD";
    public static final String LOGICSUBTYPE_ATTACHTODEACTION = "ATTACHTODEACTION";
    public static final String LOGICSUBTYPE_ATTACHTODEDATASET = "ATTACHTODEDATASET";
    public static final String LOGICSUBTYPE_WEBHOOK = "WEBHOOK";
    public static final String LOGICSUBTYPE_EVENTHOOK = "EVENTHOOK";
    public static final String LOGICSUBTYPE_DEFIELDHOOK = "DEFIELDHOOK";
    public static final String LOGICSUBTYPE_USER = "USER";
    public static final String LOGICSUBTYPE_USER2 = "USER2";
    public static final int DEBUGMODE_NONE = 0;
    public static final int DEBUGMODE_INFO = 1;

    public String getLogicSubType();

    public IPSDELogicNode getStartPSDELogicNode();

    public Iterator<? extends IPSDELogicNode> getPSDELogicNodes();

    public Iterator<? extends IPSDELogicParam> getPSDELogicParams();

    public IPSDELogicParam getPSDELogicParam(String var1) throws Exception;

    public IPSDELogicNode getPSDELogicNode(String var1) throws Exception;

    public Iterator<? extends IPSDELogicLink> getPSDELogicLinks();

    @Override
    public int getExtendMode();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public boolean isCustomCode();

    public String getScriptCode();

    @Override
    public String getDefaultParamName();

    @Override
    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public int getDebugMode();

    public IPSDELogicParam getDefaultPSDELogicParam();

    public boolean isPrepareLast();

    public IPSDEAction getAttachToPSDEAction();

    public IPSDEDataSet getAttachToPSDEDataSet();

    public String getAttachMode();

    public String getTimerPolicy();

    public String getEvents();

    public String getEventModel();

    public boolean isIgnoreException();

    public int getThreadMode();

    public boolean isValid();

    public boolean isTemplate();
}

