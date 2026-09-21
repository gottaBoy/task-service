/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.ProxyList;

public final class ProxyListEditor
extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ArrayList<String[]> proxyChains;
        block12: {
            BufferedReader reader = new BufferedReader(new StringReader(text));
            proxyChains = new ArrayList<String[]>();
            try {
                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!CommonUtils.isNotBlank(line)) continue;
                        proxyChains.add(line.trim().split(" "));
                    }
                }
                catch (IOException iOException) {
                    try {
                        reader.close();
                    }
                    catch (IOException iOException2) {}
                    break block12;
                }
            }
            catch (Throwable throwable) {
                try {
                    reader.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                throw throwable;
            }
            try {
                reader.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.setValue(new ProxyList(proxyChains));
    }
}

