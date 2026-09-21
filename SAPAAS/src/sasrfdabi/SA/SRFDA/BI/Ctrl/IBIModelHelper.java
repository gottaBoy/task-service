/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BICubeMeasure;
import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.Data.BIRepChart;
import SA.SRFDA.BI.Ctrl.Data.BIRepChartDS;
import SA.SRFDA.BI.Ctrl.Data.BIRepDM;
import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.Data.BIRepFIType;
import SA.SRFDA.BI.Ctrl.Data.BIRepFilter;
import SA.SRFDA.BI.Ctrl.Data.BIRepMS;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDS;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDSQ;
import SA.SRFDA.BI.Ctrl.Data.BIRepPI;
import SA.SRFDA.BI.Ctrl.Data.BIRepPL;
import SA.SRFDA.BI.Ctrl.Data.BIRepPQ;
import SA.SRFDA.BI.Ctrl.Data.BIRepPT;
import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.Data.BIRepPart;
import SA.SRFDA.BI.Ctrl.Data.BIRepRP;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IBIModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult GetBICatalog(String var1, BICatalog var2);

    public CallResult GetBICube(String var1, BICube var2);

    public CallResult GetBIReportEx(String var1, BIReportEx var2);

    public CallResult GetBIRepDMs(String var1, Vector<BIRepDM> var2);

    public CallResult GetBIRepMSs(String var1, Vector<BIRepMS> var2);

    public CallResult GetBICubeDimensions(String var1, Vector<BICubeDimension> var2);

    public CallResult GetBICubeMeasures(String var1, Vector<BICubeMeasure> var2);

    public CallResult GetBIHierarchies(String var1, Vector<BIHierarchy> var2);

    public CallResult GetBIDimensions(String var1, Vector<BIDimension> var2);

    public CallResult GetBILevels(String var1, Vector<BILevel> var2);

    public CallResult GetBIRepRPs(String var1, Vector<BIRepRP> var2);

    public CallResult GetBIRepPanel(String var1, BIRepPanel var2);

    public CallResult GetBIRepPT(String var1, BIRepPT var2);

    public CallResult GetBIRepPIs(String var1, Vector<BIRepPI> var2);

    public CallResult GetBIRepPQs(String var1, Vector<BIRepPQ> var2);

    public CallResult GetBIRepPDSs(String var1, Vector<BIRepPDS> var2);

    public CallResult GetBIRepPDSQs(String var1, Vector<BIRepPDSQ> var2);

    public CallResult GetBIRepPart(String var1, BIRepPart var2);

    public CallResult GetBIRepChart(String var1, BIRepChart var2);

    public CallResult GetBIRepChartDSs(String var1, Vector<BIRepChartDS> var2);

    public CallResult GetBIRepFIs(String var1, Vector<BIRepFI> var2);

    public CallResult GetBIRepPL(String var1, BIRepPL var2);

    public CallResult GetBIRepFilter(String var1, BIRepFilter var2);

    public CallResult GetBIRepFIType(String var1, BIRepFIType var2);
}

