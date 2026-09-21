/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.PF.IPSPFAppDataEntityTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppObjectTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFTempl;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFVerTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSPFStyle2
extends IPSPFStyle {
    public static final String TARGET_PSAPPCOUNTER = "PSAPPCOUNTER";
    public static final String TARGET_PSAPPCODELIST = "PSAPPCODELIST";
    public static final String TARGET_PSAPPDELOGIC = "PSAPPDELOGIC";
    public static final String TARGET_PSAPPDEUILOGIC = "PSAPPDEUILOGIC";
    public static final String TARGET_PSAPPDEMETHODDTO = "PSAPPDEMETHODDTO";
    public static final String TARGET_PSAPPUTIL = "PSAPPUTIL";
    public static final String TARGET_PSAPPMSGTEMPL = "PSAPPMSGTEMPL";
    public static final String TARGET_PSAPPVIEWMSG = "PSAPPVIEWMSG";
    public static final String TARGET_PSAPPVIEWMSGGROUP = "PSAPPVIEWMSGGROUP";
    public static final String TARGET_PSAPPPFPLUGINREF = "PSAPPPFPLUGINREF";
    public static final String TARGET_PSAPPEDITORSTYLEREF = "PSAPPEDITORSTYLEREF";
    public static final String TARGET_PSAPPSUBVIEWTYPEREF = "PSAPPSUBVIEWTYPEREF";
    public static final String TARGET_PSAPPLAN = "PSAPPLAN";

    public String getRealLocalPath();

    public String getRealResLocalPath();

    public IPSPFPubCode getPSPFPubCode(String var1, String var2, boolean var3) throws Exception;

    public IPSPFViewLogicTempl getPSPFViewLogicTempl(IPSPFLogicCodeObject var1, IPSPFPubCode var2) throws Exception;

    @Override
    public boolean isAutoNameOrCode();

    @Override
    public boolean isSystemFieldReadonlyDefault();

    @Override
    public boolean isEnableEditorStyleCode();

    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControl var1, IPSPFPubCode var2) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorContainer var1, IPSPFPubCode var2) throws Exception;

    public Iterator<IPSPFAppDataEntityTempl> getPSPFAppDataEntityTempls(IPSAppDataEntity var1) throws Exception;

    public Iterator<IPSPFAppWFTempl> getPSPFAppWFTempls(IPSAppWF var1) throws Exception;

    public Iterator<IPSPFAppWFVerTempl> getPSPFAppWFVerTempls(IPSAppWFVer var1) throws Exception;

    public Iterator<IPSPFAppObjectTempl> getPSPFAppObjectTempls(String var1) throws Exception;
}

