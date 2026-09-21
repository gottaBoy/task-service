/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="logicNodeType", implement="PSDEUserLogicImpl", model="PSDELogicNode")
public interface IPSDELogicNode
extends IPSDELogicNodeBase {
    public static final String LOGICNODETYPE_BEGIN = "BEGIN";
    public static final String LOGICNODETYPE_END = "END";
    public static final String LOGICNODETYPE_MEMO = "MEMO";
    public static final String LOGICNODETYPE_DECISION = "DECISION";
    public static final String LOGICNODETYPE_DEACTION = "DEACTION";
    public static final String LOGICNODETYPE_PREPAREPARAM = "PREPAREPARAM";
    public static final String LOGICNODETYPE_RAWSQLCALL = "RAWSQLCALL";
    public static final String LOGICNODETYPE_RAWSQLANDLOOPCALL = "RAWSQLANDLOOPCALL";
    public static final String LOGICNODETYPE_STARTWF = "STARTWF";
    public static final String LOGICNODETYPE_THROWEXCEPTION = "THROWEXCEPTION";
    public static final String LOGICNODETYPE_SFPLUGIN = "SFPLUGIN";
    public static final String LOGICNODETYPE_RAWSFCODE = "RAWSFCODE";
    public static final String LOGICNODETYPE_SYSLOGIC = "SYSLOGIC";
    public static final String LOGICNODETYPE_SYSUTIL = "SYSUTIL";
    public static final String LOGICNODETYPE_DEDATASET = "DEDATASET";
    public static final String LOGICNODETYPE_DENOTIFY = "DENOTIFY";
    public static final String LOGICNODETYPE_DELOGIC = "DELOGIC";
    public static final String LOGICNODETYPE_COMMIT = "COMMIT";
    public static final String LOGICNODETYPE_ROLLBACK = "ROLLBACK";
    public static final String LOGICNODETYPE_DEDATAQUERY = "DEDATAQUERY";
    public static final String LOGICNODETYPE_DEBUGPARAM = "DEBUGPARAM";
    public static final String LOGICNODETYPE_SUBSYSSAMETHOD = "SUBSYSSAMETHOD";
    public static final String LOGICNODETYPE_SYSDATASYNCAGENTOUT = "SYSDATASYNCAGENTOUT";
    public static final String LOGICNODETYPE_SYSDBTABLEACTION = "SYSDBTABLEACTION";
    public static final String LOGICNODETYPE_CANCELWF = "CANCELWF";
    public static final String LOGICNODETYPE_DEPRINT = "DEPRINT";
    public static final String LOGICNODETYPE_DEREPORT = "DEREPORT";
    public static final String LOGICNODETYPE_DEDTSQUEUE = "DEDTSQUEUE";
    public static final String LOGICNODETYPE_RESETPARAM = "RESETPARAM";
    public static final String LOGICNODETYPE_COPYPARAM = "COPYPARAM";
    public static final String LOGICNODETYPE_BINDPARAM = "BINDPARAM";
    public static final String LOGICNODETYPE_APPENDPARAM = "APPENDPARAM";
    public static final String LOGICNODETYPE_SORTPARAM = "SORTPARAM";
    public static final String LOGICNODETYPE_RENEWPARAM = "RENEWPARAM";
    public static final String LOGICNODETYPE_FILTERPARAM = "FILTERPARAM";
    public static final String LOGICNODETYPE_FILTERPARAM2 = "FILTERPARAM2";
    public static final String LOGICNODETYPE_MERGEPARAM = "MERGEPARAM";
    public static final String LOGICNODETYPE_AGGREGATEPARAM = "AGGREGATEPARAM";
    public static final String LOGICNODETYPE_SYSBDTABLEACTION = "SYSBDTABLEACTION";
    public static final String LOGICNODETYPE_SYSSEARCHDOCACTION = "SYSSEARCHDOCACTION";
    public static final String LOGICNODETYPE_SYSBIREPORT = "SYSBIREPORT";
    public static final String LOGICNODETYPE_DEDATASYNC = "DEDATASYNC";
    public static final String LOGICNODETYPE_RAWWEBCALL = "RAWWEBCALL";
    public static final String LOGICNODETYPE_LOOPSUBCALL = "LOOPSUBCALL";
    public static final String LOGICNODETYPE_USER = "USER";
    public static final String LOGICNODETYPE_DEDATAFLOW = "DEDATAFLOW";
    public static final String LOGICNODETYPE_SUBMITWF = "SUBMITWF";
    public static final String LOGICNODETYPE_SYSAICHATAGENT = "SYSAICHATAGENT";
    public static final String LOGICNODETYPE_SYSAIPIPELINEAGENT = "SYSAIPIPELINEAGENT";

    public void init(ISRFDAGlobalHelper var1, IPSDELogic var2, PSDELogicNode var3) throws Exception;

    public IPSDELogic getPSDELogic();

    public Iterator<IPSDELogicLink> getPSDELogicLinks();

    public Iterator<IPSDELogicNodeParam> getPSDELogicNodeParams();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public Properties getNodeParams();
}

