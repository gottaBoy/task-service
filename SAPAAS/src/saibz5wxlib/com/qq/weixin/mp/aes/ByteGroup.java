/*
 * Decompiled with CFR 0.152.
 */
package com.qq.weixin.mp.aes;

import java.util.ArrayList;

class ByteGroup {
    ArrayList<Byte> byteContainer = new ArrayList();

    ByteGroup() {
    }

    public byte[] toBytes() {
        byte[] bytes = new byte[this.byteContainer.size()];
        int i = 0;
        while (i < this.byteContainer.size()) {
            bytes[i] = this.byteContainer.get(i);
            ++i;
        }
        return bytes;
    }

    public ByteGroup addBytes(byte[] bytes) {
        byte[] byArray = bytes;
        int n = bytes.length;
        int n2 = 0;
        while (n2 < n) {
            byte b = byArray[n2];
            this.byteContainer.add(b);
            ++n2;
        }
        return this;
    }

    public int size() {
        return this.byteContainer.size();
    }
}

