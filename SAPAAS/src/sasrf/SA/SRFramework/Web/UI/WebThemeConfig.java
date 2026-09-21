/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.UI.ThemeConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.DefaultDFormBuilder;
import SA.SRFramework.Web.Builder.DefaultIconViewBuilder;
import SA.SRFramework.Web.Builder.DefaultMainListBuilder;
import SA.SRFramework.Web.Builder.DefaultMainMenuBuilder;
import SA.SRFramework.Web.Builder.DefaultMainViewBuilder;
import SA.SRFramework.Web.Builder.DefaultSearchFormBuilder;
import SA.SRFramework.Web.Builder.DefaultSearchInfoFormBuilder;
import SA.SRFramework.Web.Builder.DefaultSubListBuilder;
import SA.SRFramework.Web.Builder.DefaultSubMenuBuilder;
import SA.SRFramework.Web.Builder.DefaultSubViewBuilder;
import SA.SRFramework.Web.Builder.DefaultTabViewsBuilder;
import SA.SRFramework.Web.Builder.DefaultTipsBarBuilder;
import SA.SRFramework.Web.Builder.IconViewBuilder;
import SA.SRFramework.Web.Builder.MainListBuilder;
import SA.SRFramework.Web.Builder.MainMenuBuilder;
import SA.SRFramework.Web.Builder.MainViewBuilder;
import SA.SRFramework.Web.Builder.SearchFormBuilder;
import SA.SRFramework.Web.Builder.SearchInfoFormBuilder;
import SA.SRFramework.Web.Builder.SubListBuilder;
import SA.SRFramework.Web.Builder.SubMenuBuilder;
import SA.SRFramework.Web.Builder.SubViewBuilder;
import SA.SRFramework.Web.Builder.TabViewsBuilder;
import SA.SRFramework.Web.Builder.TipsBarBuilder;
import org.w3c.dom.Node;

public class WebThemeConfig
extends ThemeConfig {
    public static String SEARCHFORMBUILDER = "SEARCHFORMBUILDER";
    public static String SEARCHINFOFORMBUILDER = "SEARCHINFOFORMBUILDER";
    public static String MAINLISTBUILDER = "MAINLISTBUILDER";
    public static String DYNAMICFORMBUILDER = "DYNAMICFORMBUILDER";
    public static String MAINMENUBUILDER = "MAINMENUBUILDER";
    public static String SUBMENUBUILDER = "SUBMENUBUILDER";
    public static String MAINVIEWBUILDER = "MAINVIEWBUILDER";
    public static String SUBVIEWBUILDER = "SUBVIEWBUILDER";
    public static String SUBLISTBUILDER = "SUBLISTBUILDER";
    public static String TIPSBARBUILDER = "TIPSBARBUILDER";
    public static String ICONVIEWBUILDER = "ICONVIEWBUILDER";
    public static String TABVIEWSBUILDER = "TABVIEWSBUILDER";
    protected String strSearchFormBuilder = "";
    protected String strMainListBuilder = "";
    protected String strDynamicFormBuilder = "";
    protected String strMainMenuBuilder = "";
    protected String strSubMenuBuilder = "";
    protected String strMainViewBuilder = "";
    protected String strSubViewBuilder = "";
    protected String strSubListBuilder = "";
    protected String strTipsBarBuilder = "";
    protected String strIconViewBuilder = "";
    protected String strTabViewsBuilder = "";
    protected String strSearchInfoFormBuilder = "";

    public SearchFormBuilder GetSearchFormBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strSearchFormBuilder) == 0) {
                return new DefaultSearchFormBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strSearchFormBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultSearchFormBuilder();
            }
        }
        return (SearchFormBuilder)obj;
    }

    public SearchInfoFormBuilder GetSearchInfoFormBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strSearchInfoFormBuilder) == 0) {
                return new DefaultSearchInfoFormBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strSearchInfoFormBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultSearchInfoFormBuilder();
            }
        }
        return (SearchInfoFormBuilder)obj;
    }

    public MainListBuilder GetMainListBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strMainListBuilder) == 0) {
                return new DefaultMainListBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strMainListBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultMainListBuilder();
            }
        }
        return (MainListBuilder)obj;
    }

    public DefaultDFormBuilder GetDynamicFormBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strDynamicFormBuilder) == 0) {
                return new DefaultDFormBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strDynamicFormBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultDFormBuilder();
            }
        }
        return (DefaultDFormBuilder)obj;
    }

    public MainMenuBuilder GetMainMenuBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strMainMenuBuilder) == 0) {
                return new DefaultMainMenuBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strMainMenuBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultMainMenuBuilder();
            }
        }
        return (MainMenuBuilder)obj;
    }

    public SubMenuBuilder GetSubMenuBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strSubMenuBuilder) == 0) {
                return new DefaultSubMenuBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strSubMenuBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultSubMenuBuilder();
            }
        }
        return (SubMenuBuilder)obj;
    }

    public MainViewBuilder GetMainViewBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strMainViewBuilder) == 0) {
                return new DefaultMainViewBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strMainViewBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultMainViewBuilder();
            }
        }
        return (MainViewBuilder)obj;
    }

    public SubViewBuilder GetSubViewBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strSubViewBuilder) == 0) {
                return new DefaultSubViewBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strSubViewBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultSubViewBuilder();
            }
        }
        return (SubViewBuilder)obj;
    }

    public SubListBuilder GetSubListBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strSubListBuilder) == 0) {
                return new DefaultSubListBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strSubListBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultSubListBuilder();
            }
        }
        return (SubListBuilder)obj;
    }

    public TipsBarBuilder GetTipsBarBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strTipsBarBuilder) == 0) {
                return new DefaultTipsBarBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strTipsBarBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultTipsBarBuilder();
            }
        }
        return (TipsBarBuilder)obj;
    }

    public IconViewBuilder GetIconViewBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strIconViewBuilder) == 0) {
                return new DefaultIconViewBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strIconViewBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultIconViewBuilder();
            }
        }
        return (IconViewBuilder)obj;
    }

    public TabViewsBuilder GetTabViewsBuilder() {
        Object obj;
        block4: {
            if (StringHelper.Length(this.strTabViewsBuilder) == 0) {
                return new DefaultTabViewsBuilder();
            }
            try {
                obj = this.InternalCreateObject(this.strTabViewsBuilder);
                if (obj != null) break block4;
                return null;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new DefaultTabViewsBuilder();
            }
        }
        return (TabViewsBuilder)obj;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, SEARCHFORMBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strSearchFormBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, SEARCHINFOFORMBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strSearchInfoFormBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, MAINLISTBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strMainListBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, DYNAMICFORMBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strDynamicFormBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, MAINMENUBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strMainMenuBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, SUBMENUBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strSubMenuBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, MAINVIEWBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strMainViewBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, SUBVIEWBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strSubViewBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, SUBLISTBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strSubListBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, TIPSBARBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strTipsBarBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, ICONVIEWBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strIconViewBuilder = xmlConfig.getID();
            }
            return;
        }
        if (StringHelper.Compare(strName, TABVIEWSBUILDER, true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                this.strTabViewsBuilder = xmlConfig.getID();
            }
            return;
        }
    }

    private Object InternalCreateObject(String strType) {
        try {
            return Class.forName(strType).newInstance();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }
}

