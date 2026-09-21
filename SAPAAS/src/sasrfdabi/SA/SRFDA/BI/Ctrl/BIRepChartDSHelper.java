/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepChartDS;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIRepChartDSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepChartHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class BIRepChartDSHelper
extends BaseBIObject
implements IBIRepChartDSHelper {
    protected BIRepChartDS biRepChartDS = null;
    protected IBIRepChartHelper iBIRepChartHelper = null;
    protected String strCatalogField = "";
    protected String strAxisXField = "";
    protected String strValueField = "";
    protected String strValue2Field = "";
    protected String strValue3Field = "";
    protected String strValue4Field = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepChartHelper iBIRepChartHelper, BIRepChartDS biRepChartDS) throws Exception {
        IBICubeMeasureHelper iBICubeMeasureHelper;
        IBIDimensionHelper iBIDimensionHelper;
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepChartDS = biRepChartDS;
        this.iBIRepChartHelper = iBIRepChartHelper;
        if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getCATALOGDMID())) {
            iBIDimensionHelper = iBIRepChartHelper.getBICube().FindBIDimension(biRepChartDS.getCATALOGDMID());
            this.strCatalogField = iBIDimensionHelper.getShortId();
        }
        if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getAXISXDMID())) {
            iBIDimensionHelper = iBIRepChartHelper.getBICube().FindBIDimension(biRepChartDS.getAXISXDMID());
            this.strAxisXField = iBIDimensionHelper.getShortId();
        }
        if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUEMSID())) {
            iBICubeMeasureHelper = iBIRepChartHelper.getBICube().FindBICubeMeasure(biRepChartDS.getVALUEMSID());
            this.strValueField = iBICubeMeasureHelper.getShortId();
            if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUEDMTEXT())) {
                this.strValueField = String.valueOf(biRepChartDS.getVALUEDMTEXT()) + ";" + this.strValueField;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUE2MSID())) {
            iBICubeMeasureHelper = iBIRepChartHelper.getBICube().FindBICubeMeasure(biRepChartDS.getVALUE2MSID());
            this.strValue2Field = iBICubeMeasureHelper.getShortId();
            if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUE2DMTEXT())) {
                this.strValue2Field = String.valueOf(biRepChartDS.getVALUE2DMTEXT()) + ";" + this.strValue2Field;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUE3MSID())) {
            iBICubeMeasureHelper = iBIRepChartHelper.getBICube().FindBICubeMeasure(biRepChartDS.getVALUE3MSID());
            this.strValue3Field = iBICubeMeasureHelper.getShortId();
            if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUE3DMTEXT())) {
                this.strValue3Field = String.valueOf(biRepChartDS.getVALUE3DMTEXT()) + ";" + this.strValue3Field;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUE4MSID())) {
            iBICubeMeasureHelper = iBIRepChartHelper.getBICube().FindBICubeMeasure(biRepChartDS.getVALUE4MSID());
            this.strValue4Field = iBICubeMeasureHelper.getShortId();
            if (!StringHelper.IsNullOrEmpty((String)biRepChartDS.getVALUE4DMTEXT())) {
                this.strValue4Field = String.valueOf(biRepChartDS.getVALUE4DMTEXT()) + ";" + this.strValue4Field;
            }
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getCatalogField() {
        return this.strCatalogField;
    }

    @Override
    public String getAxisXField() {
        return this.strAxisXField;
    }

    @Override
    public String getValueField() {
        return this.strValueField;
    }

    @Override
    public String getValue2Field() {
        return this.strValue2Field;
    }

    @Override
    public String getValue3Field() {
        return this.strValue3Field;
    }

    @Override
    public String getValue4Field() {
        return this.strValue4Field;
    }

    @Override
    public String getValueCaption() {
        return this.biRepChartDS.getVALUECAPTION();
    }

    @Override
    public String getValue2Caption() {
        return this.biRepChartDS.getVALUE2CAPTION();
    }

    @Override
    public String getValue3Caption() {
        return this.biRepChartDS.getVALUE3CAPTION();
    }

    @Override
    public String getValue4Caption() {
        return this.biRepChartDS.getVALUE4CAPTION();
    }

    @Override
    public String getChartType() {
        return this.biRepChartDS.getCHARTTYPE();
    }
}

