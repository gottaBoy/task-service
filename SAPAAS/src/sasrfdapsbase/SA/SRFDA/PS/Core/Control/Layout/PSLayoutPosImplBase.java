/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFramework.Utility.StringHelper;

public abstract class PSLayoutPosImplBase
extends PSObjectImpl
implements IPSLayoutPos {
    private IPSModelObject iPSModelObject = null;
    private PSLayout layoutData = null;
    private IPSLayout iPSLayout = null;
    private Integer nWidth = null;
    private Integer nHeight = null;
    private String strHAlignSelf = null;
    private String strVAlignSelf = null;
    private String strSpacingTop = null;
    private String strSpacingBottom = null;
    private String strSpacingLeft = null;
    private String strSpacingRight = null;
    private String strWidthMode = null;
    private String strHeightMode = null;

    @Override
    public void init(IPSModelObject iPSModelObject, IPSLayout iPSLayout, PSLayout layoutData) throws Exception {
        this.layoutData = layoutData;
        this.iPSLayout = iPSLayout;
        this.iPSModelObject = iPSModelObject;
        if (!layoutData.isWIDTHNull()) {
            this.nWidth = layoutData.getWIDTH();
        }
        if (!layoutData.isHEIGHTNull()) {
            this.nHeight = layoutData.getHEIGHT();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getHALIGNSELF())) {
            this.strHAlignSelf = layoutData.getHALIGNSELF();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getVALIGNSELF())) {
            this.strVAlignSelf = layoutData.getVALIGNSELF();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getSPACINGLEFT())) {
            this.strSpacingLeft = layoutData.getSPACINGLEFT();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getSPACINGRIGHT())) {
            this.strSpacingRight = layoutData.getSPACINGRIGHT();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getSPACINGTOP())) {
            this.strSpacingTop = layoutData.getSPACINGTOP();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getSPACINGBOTTOM())) {
            this.strSpacingBottom = layoutData.getSPACINGBOTTOM();
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getWIDTHMODE())) {
            this.strWidthMode = layoutData.getWIDTHMODE();
        } else if (this.getWidth() != null && this.getWidth() > 0) {
            this.strWidthMode = "PX";
        }
        if (!StringHelper.IsNullOrEmpty((String)layoutData.getHEIGHTMODE())) {
            this.strHeightMode = layoutData.getHEIGHTMODE();
        } else if (this.getHeight() != null && this.getHeight() > 0) {
            this.strHeightMode = "PX";
        }
        this.onInit();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected Object getOwner() {
        return this.iPSModelObject;
    }

    protected PSLayout getPSLayoutData() {
        return this.layoutData;
    }

    @Override
    public IPSLayout getParentPSLayout() {
        return this.iPSLayout;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u5bb9\u5668")
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", group="\u4f4d\u7f6e")
    public String getLayout() {
        return this.getPSLayout().getLayout();
    }

    @Override
    public String getModelType() {
        return "PSLAYOUTPOS$" + this.iPSModelObject.getModelType();
    }

    @Override
    public String getModelId() {
        return this.iPSModelObject.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u5bbd\u5ea6", group="\u4f4d\u7f6e", fields={"WIDTH"})
    public Integer getWidth() {
        return this.nWidth;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9ad8\u5ea6", group="\u4f4d\u7f6e", fields={"HEIGHT"})
    public Integer getHeight() {
        return this.nHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u95f4\u9694\u6a21\u5f0f", codelist="SpacingMode", group="\u4f4d\u7f6e", fields={"SPACINGLEFT"})
    public String getSpacingLeft() {
        return this.strSpacingLeft;
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u95f4\u9694\u6a21\u5f0f", codelist="SpacingMode", group="\u4f4d\u7f6e", fields={"SPACINGRIGHT"})
    public String getSpacingRight() {
        return this.strSpacingRight;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u95f4\u9694\u6a21\u5f0f", codelist="SpacingMode", group="\u4f4d\u7f6e", fields={"SPACINGTOP"})
    public String getSpacingTop() {
        return this.strSpacingTop;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u65b9\u95f4\u9694\u6a21\u5f0f", codelist="SpacingMode", group="\u4f4d\u7f6e", fields={"SPACINGBOTTOM"})
    public String getSpacingBottom() {
        return this.strSpacingBottom;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u8eab\u5782\u76f4\u5bf9\u9f50\u6a21\u5f0f", codelist="TextVAlign", group="\u4f4d\u7f6e", fields={"VALIGNSELF"})
    public String getVAlignSelf() {
        return this.strVAlignSelf;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u8eab\u6c34\u5e73\u5bf9\u9f50\u6a21\u5f0f", codelist="TextAlign", group="\u4f4d\u7f6e", fields={"HALIGNSELF"})
    public String getHAlignSelf() {
        return this.strHAlignSelf;
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6\u6a21\u5f0f", codelist="WidthMode", group="\u4f4d\u7f6e", fields={"WIDTHMODE"})
    public String getWidthMode() {
        return this.strWidthMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6\u6a21\u5f0f", codelist="HeightMode", group="\u4f4d\u7f6e", fields={"HEIGHTMODE"})
    public String getHeightMode() {
        return this.strHeightMode;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

