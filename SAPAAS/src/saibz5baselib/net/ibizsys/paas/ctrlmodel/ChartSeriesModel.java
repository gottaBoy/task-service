/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;

public class ChartSeriesModel
extends ModelBaseImpl
implements IChartSeriesModel {
    private String strCaption = null;
    private String strSeriesType = null;
    private String strTimeGroupMode = null;
    private String strCatalogField = null;
    private String strCatalogFieldCodeListId = null;
    private String strValueField = null;
    private String strValue2Field = null;
    private String strValue3Field = null;
    private String strValue4Field = null;
    private String strSeriesField = null;
    private String strSeriesFieldCodeListId = null;
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
    public String getSeriesType() {
        return this.strSeriesType;
    }

    public void setSeriesType(String strSeriesType) {
        this.strSeriesType = strSeriesType;
    }

    @Override
    public String getCatalogField() {
        return this.strCatalogField;
    }

    public void setCatalogField(String strCatalogField) {
        this.strCatalogField = strCatalogField;
    }

    @Override
    public String getCatalogFieldCodeListId() {
        return this.strCatalogFieldCodeListId;
    }

    public void setCatalogFieldCodeListId(String strCatalogFieldCodeListId) {
        this.strCatalogFieldCodeListId = strCatalogFieldCodeListId;
    }

    @Override
    public String getValueField() {
        return this.strValueField;
    }

    public void setValueField(String strValueField) {
        this.strValueField = strValueField;
    }

    @Override
    public String getValue2Field() {
        return this.strValue2Field;
    }

    public void setValue2Field(String strValue2Field) {
        this.strValue2Field = strValue2Field;
    }

    @Override
    public String getValue3Field() {
        return this.strValue3Field;
    }

    public void setValue3Field(String strValue3Field) {
        this.strValue3Field = strValue3Field;
    }

    @Override
    public String getValue4Field() {
        return this.strValue4Field;
    }

    public void setValue4Field(String strValue4Field) {
        this.strValue4Field = strValue4Field;
    }

    @Override
    public String getSeriesField() {
        return this.strSeriesField;
    }

    public void setSeriesField(String strSeriesField) {
        this.strSeriesField = strSeriesField;
    }

    @Override
    public String getSeriesFieldCodeListId() {
        return this.strSeriesFieldCodeListId;
    }

    public void setSeriesFieldCodeListId(String strSeriesFieldCodeListId) {
        this.strSeriesFieldCodeListId = strSeriesFieldCodeListId;
    }

    @Override
    public String getTimeGroupMode() {
        return this.strTimeGroupMode;
    }

    public void setTimeGroupMode(String strTimeGroupMode) {
        this.strTimeGroupMode = strTimeGroupMode;
    }
}

