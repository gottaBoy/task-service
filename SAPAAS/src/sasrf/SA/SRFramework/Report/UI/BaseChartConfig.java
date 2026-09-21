/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.entity.EntityCollection
 *  org.jfree.chart.entity.StandardEntityCollection
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Report.ChartImage;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;

public abstract class BaseChartConfig
extends XMLConfig
implements Cloneable {
    private String strImageType = "";
    static final String IMAGETYPE = "IMAGETYPE";
    private Hashtable chartImageHashtable = new Hashtable();
    private JFreeChart curJFreeChart = null;

    protected void OnClone(Object destObj) {
    }

    public Object GetDefineObject() {
        return null;
    }

    public void setImageType(String value) {
        this.strImageType = value;
    }

    public String getImageType() {
        return this.strImageType;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, IMAGETYPE, true) == 0) {
            this.strImageType = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public synchronized JFreeChart GetJFreeChart() {
        if (this.curJFreeChart == null) {
            this.curJFreeChart = this.CreateChartObject();
        }
        return this.curJFreeChart;
    }

    public synchronized ChartImage getChartImage(int nWidth, int nHeigth, String strMimeStyle) {
        if (this.curJFreeChart == null) {
            this.curJFreeChart = this.CreateChartObject();
        }
        if (this.curJFreeChart == null) {
            return null;
        }
        String strChartImageId = String.format("IMGID_%1$d_%2$d_%3$s", nWidth, nHeigth, strMimeStyle);
        if (this.chartImageHashtable.containsKey(strChartImageId)) {
            return (ChartImage)this.chartImageHashtable.get(strChartImageId);
        }
        ChartImage chartImage = BaseChartConfig.RenderChart(this.curJFreeChart, strMimeStyle, nWidth, nHeigth);
        if (chartImage != null) {
            this.chartImageHashtable.put(strChartImageId, chartImage);
        }
        return chartImage;
    }

    protected JFreeChart CreateChartObject() {
        return null;
    }

    protected void OnFillChartInfo(JFreeChart freeChart) {
    }

    public synchronized void ResetChartImages() {
        this.curJFreeChart = null;
        this.chartImageHashtable.clear();
    }

    private static ChartImage RenderChart(JFreeChart chart, String strMimeStyle, int nWidth, int nHeight) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ChartRenderingInfo info = new ChartRenderingInfo((EntityCollection)new StandardEntityCollection());
            if (StringHelper.Compare(strMimeStyle, "image/png", true) == 0) {
                BaseChartConfig.handlePNG(baos, chart, nWidth, nHeight, info);
            } else if (StringHelper.Compare(strMimeStyle, "image/jpeg", true) == 0) {
                BaseChartConfig.handleJPEG(baos, chart, nWidth, nHeight, info);
            } else {
                throw new Exception("Mime type " + strMimeStyle + " is unsupported.");
            }
            baos.close();
            return new ChartImage(baos.toByteArray(), strMimeStyle, nWidth, nHeight);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }

    private static synchronized void handlePNG(ByteArrayOutputStream baos, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
        ChartUtilities.writeChartAsPNG((OutputStream)baos, (JFreeChart)chart, (int)width, (int)height, (ChartRenderingInfo)info);
    }

    private static synchronized void handleJPEG(ByteArrayOutputStream baos, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
        ChartUtilities.writeChartAsJPEG((OutputStream)baos, (JFreeChart)chart, (int)width, (int)height, (ChartRenderingInfo)info);
    }
}

