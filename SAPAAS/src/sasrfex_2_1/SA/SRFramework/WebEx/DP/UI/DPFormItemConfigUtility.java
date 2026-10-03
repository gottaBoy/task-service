/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.UI.CheckBoxConfig;
import SA.SRFramework.WebEx.UI.CheckBoxListConfig;
import SA.SRFramework.WebEx.UI.DatePickerConfig;
import SA.SRFramework.WebEx.UI.DatePickerExConfig;
import SA.SRFramework.WebEx.UI.DropDownListConfig;
import SA.SRFramework.WebEx.UI.FileUploaderConfig;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorExConfig;
import SA.SRFramework.WebEx.UI.IPAddressTextBoxConfig;
import SA.SRFramework.WebEx.UI.ListBoxConfig;
import SA.SRFramework.WebEx.UI.ListBoxPickupConfig;
import SA.SRFramework.WebEx.UI.MultiPickerConfig;
import SA.SRFramework.WebEx.UI.PickerConfig;
import SA.SRFramework.WebEx.UI.PickerExConfig;
import SA.SRFramework.WebEx.UI.PictureConfig;
import SA.SRFramework.WebEx.UI.RadioButtonListConfig;
import SA.SRFramework.WebEx.UI.RawConfig;
import SA.SRFramework.WebEx.UI.SpanConfig;
import SA.SRFramework.WebEx.UI.SpanExConfig;
import SA.SRFramework.WebEx.UI.TextAreaConfig;
import SA.SRFramework.WebEx.UI.TextBoxConfig;
import SA.SRFramework.WebEx.UI.UserControlConfig;
import java.util.Hashtable;

public class DPFormItemConfigUtility {
    protected Hashtable<String, ObjectCreator> objectCreatorMap = new Hashtable(25);

    public DPFormItemConfigUtility() {
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.TextBoxConfig", new ObjectCreator(){

            @Override
            public Object Create() {
                return new TextBoxConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.RawConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new RawConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.PickerExConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new PickerExConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.SpanExConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new SpanExConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.DatePickerExConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new DatePickerExConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.DatePickerConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new DatePickerConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.ListBoxConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new ListBoxConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.CheckBoxListConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new CheckBoxListConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.CheckBoxConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new CheckBoxConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.RadioButtonListConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new RadioButtonListConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.PickerConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new PickerConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.HiddenConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new HiddenConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.DropDownListConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new DropDownListConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.TextAreaConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new TextAreaConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.FormImageLinkConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new FormImageLinkConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.ListBoxPickupConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new ListBoxPickupConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.HtmlEditorConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new HtmlEditorConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.HtmlEditorExConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new HtmlEditorExConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.SpanConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new SpanConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.UserControlConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new UserControlConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.FileUploaderConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new FileUploaderConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.PictureConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new PictureConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.MultiPickerConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new MultiPickerConfig();
            }
        });
        this.objectCreatorMap.put("SA.SRFramework.WebEx.UI.IPAddressTextBoxConfig", new ObjectCreator(){

            @Override
            public final Object Create() {
                return new IPAddressTextBoxConfig();
            }
        });
    }

    public final Object CreateObject(String strObject) {
        ObjectCreator objectCreator = this.objectCreatorMap.get(strObject);
        if (objectCreator == null) {
            return ObjectHelper.Create(strObject);
        }
        return objectCreator.Create();
    }

    public abstract class ObjectCreator {
        public abstract Object Create();
    }
}
