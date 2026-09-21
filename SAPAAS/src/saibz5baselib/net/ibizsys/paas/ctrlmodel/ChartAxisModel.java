/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;

public class ChartAxisModel
extends ModelBaseImpl
implements IChartAxisModel {
    private String strCaption = null;
    private String strAxisType = null;
    private String strAxisPos = null;
    private IChart iChart = null;

    public void init(IChart iChart) {
        this.iChart = iChart;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getAxisType() {
        return this.strAxisType;
    }

    public void setAxisType(String strAxisType) {
        this.strAxisType = strAxisType;
    }

    @Override
    public String getAxisPos() {
        return this.strAxisPos;
    }

    public void setAxisPos(String strAxisPos) {
        this.strAxisPos = strAxisPos;
    }
}

