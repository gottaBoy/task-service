/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSPFPubCode
extends IPSPFObject {
    public static final String TARGETTYPE_NONE = "NONE";
    public static final String TARGETTYPE_VIEW = "VIEW";
    public static final String TARGETTYPE_APP = "APP";
    public static final String TARGETTYPE_VIEWCTRL = "VIEWCTRL";
    public static final String TARGETTYPE_DATAENTITY = "DATAENTITY";
    public static final String TARGETTYPE_COUNTER = "COUNTER";
    public static final String TARGETTYPE_CODELIST = "CODELIST";
    public static final String TARGETTYPE_WF = "WF";
    public static final String TARGETTYPE_WFVER = "WFVER";
    public static final String TARGETTYPE_DELOGIC = "DELOGIC";
    public static final String TARGETTYPE_DEUILOGIC = "DEUILOGIC";
    public static final String TARGETTYPE_DEMETHODDTO = "DEMETHODDTO";
    public static final String TARGETTYPE_UTIL = "UTIL";
    public static final String TARGETTYPE_LAN = "LAN";
    public static final String TARGETTYPE_MSGTEMPL = "MSGTEMPL";
    public static final String TARGETTYPE_VIEWMSG = "VIEWMSG";
    public static final String TARGETTYPE_VIEWMSGGROUP = "VIEWMSGGROUP";
    public static final String TARGETTYPE_PFPLUGINREF = "PFPLUGINREF";
    public static final String TARGETTYPE_EDITORSTYLEREF = "EDITORSTYLEREF";
    public static final String TARGETTYPE_SUBVIEWTYPEREF = "SUBVIEWTYPEREF";

    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFPubCode var3, PSPFPubCode var4) throws Exception;

    public String getTargetType();

    public String getPKGCodeName();

    public String getClassNameExt();

    public String getFileNameExt();

    public String getCodeFolder();

    public IPSPFCodeFolder getPSPFCodeFolder();

    public String getPreviewCode();

    public String getPluginTemplCode();

    public IPSPFPubCode getParentPSPFPubCode();

    public Iterator<IPSPFPubCode> getChildPSPFPubCodes();
}

