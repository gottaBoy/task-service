/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.codelist;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IModelBase;

public interface ICodeItem
extends IModelBase {
    public ICodeList getCodeList();

    public ICodeItem getParentCodeItem();

    public Iterator<ICodeItem> getCodeItems() throws Exception;

    public String getRealText();

    public String getText();

    public String getValue();

    public String getColor();

    public String getIconPath();

    public String getIconPathX();

    public String getIconPath(int var1);

    public String getMemo();

    public String getIconCls();

    public String getIconClsX();

    public String getIconCls(int var1);

    public String getTextCls();

    public ICodeItem getCodeItemByText(String var1, boolean var2) throws Exception;

    public ICodeItem getCodeItem(String var1, boolean var2) throws Exception;

    public ICodeItem getCodeItemByText(String var1) throws Exception;

    public ICodeItem getCodeItem(String var1) throws Exception;

    public String getParentValue();

    public String getUserData();

    public String getUserData2();

    public boolean isDisableSelect();

    public String getTextLanResTag();
}

