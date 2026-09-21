/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="logicNodeType", implement="PSDEUILogicNodeImpl", model="PSDELogicNode")
public interface IPSDEUILogicNode
extends IPSDELogicNodeBase {
    public static final String LOGICNODETYPE_BEGIN = "BEGIN";
    public static final String LOGICNODETYPE_MEMO = "MEMO";
    public static final String LOGICNODETYPE_PREPAREJSPARAM = "PREPAREJSPARAM";
    public static final String LOGICNODETYPE_VIEWCTRLINVOKE = "VIEWCTRLINVOKE";
    public static final String LOGICNODETYPE_VIEWCTRLFIREEVENT = "VIEWCTRLFIREEVENT";
    public static final String LOGICNODETYPE_RAWJSCODE = "RAWJSCODE";
    public static final String LOGICNODETYPE_PFPLUGIN = "PFPLUGIN";
    public static final String LOGICNODETYPE_MSGBOX = "MSGBOX";
    public static final String LOGICNODETYPE_DEACTION = "DEACTION";
    public static final String LOGICNODETYPE_DEUIACTION = "DEUIACTION";
    public static final String LOGICNODETYPE_THROWEXCEPTION = "THROWEXCEPTION";
    public static final String LOGICNODETYPE_RESETPARAM = "RESETPARAM";
    public static final String LOGICNODETYPE_COPYPARAM = "COPYPARAM";
    public static final String LOGICNODETYPE_BINDPARAM = "BINDPARAM";
    public static final String LOGICNODETYPE_APPENDPARAM = "APPENDPARAM";
    public static final String LOGICNODETYPE_SORTPARAM = "SORTPARAM";
    public static final String LOGICNODETYPE_RENEWPARAM = "RENEWPARAM";
    public static final String LOGICNODETYPE_DEDATASET = "DEDATASET";
    public static final String LOGICNODETYPE_DELOGIC = "DELOGIC";
    public static final String LOGICNODETYPE_DEBUGPARAM = "DEBUGPARAM";
    public static final String LOGICNODETYPE_END = "END";
    public static final String LOGICNODETYPE_DECISION = "DECISION";
    public static final String LOGICNODETYPE_LOOPSUBCALL = "LOOPSUBCALL";

    public void init(ISRFDAGlobalHelper var1, IPSDEUILogic var2, PSDELogicNode var3) throws Exception;

    public Iterator<IPSDEUILogicLink> getPSDEUILogicLinks();

    public Iterator<IPSDEUILogicNodeParam> getPSDEUILogicNodeParams();

    public IPSDEUILogic getPSDEUILogic();

    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception;

    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception;
}

