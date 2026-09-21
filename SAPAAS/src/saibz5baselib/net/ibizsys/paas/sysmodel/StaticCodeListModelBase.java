/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.lang.annotation.Annotation;
import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.CodeListModelBase;
import net.ibizsys.paas.util.StringHelper;

public abstract class StaticCodeListModelBase
extends CodeListModelBase {
    @Override
    protected void initAnnotation(Class c) {
        super.initAnnotation(c);
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof CodeItems) {
                    this.prepareCodeItems((CodeItems)annotation);
                }
                ++n2;
            }
        }
    }

    protected void prepareCodeItems(CodeItems codeItems) {
        CodeItem[] codeItemArray = codeItems.value();
        int n = codeItemArray.length;
        int n2 = 0;
        while (n2 < n) {
            CodeItem codeItem = codeItemArray[n2];
            CodeItemModel codeItemModel = this.createCodeItemModel(codeItem);
            this.registerCodeItemModel(codeItemModel);
            ++n2;
        }
    }

    protected CodeItemModel createCodeItemModel(CodeItem codeItem) {
        CodeItemModel codeItemModel = new CodeItemModel();
        if (StringHelper.isNullOrEmpty(codeItem.parentvalue())) {
            codeItemModel.init(this, null, codeItem);
        } else {
            codeItemModel.init(this, this.getCodeItemModel(codeItem.parentvalue()), codeItem);
        }
        return codeItemModel;
    }
}

