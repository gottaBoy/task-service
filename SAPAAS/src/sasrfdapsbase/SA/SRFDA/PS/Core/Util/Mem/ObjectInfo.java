/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Util.Mem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectInfo {
    public final String name;
    public final String type;
    public final String contents;
    public final int offset;
    public final int length;
    public final int arrayBase;
    public final int arrayElementSize;
    public final int arraySize;
    public final List<ObjectInfo> children;
    long size = 0L;

    public ObjectInfo(String name, String type, String contents, int offset, int length, int arraySize, int arrayBase, int arrayElementSize) {
        this.name = name;
        this.type = type;
        this.contents = contents;
        this.offset = offset;
        this.length = length;
        this.arraySize = arraySize;
        this.arrayBase = arrayBase;
        this.arrayElementSize = arrayElementSize;
        this.children = new ArrayList<ObjectInfo>(1);
    }

    public void addChild(ObjectInfo info) {
        if (info != null) {
            this.children.add(info);
        }
    }

    public long getDeepSize() {
        return this.addPaddingSize((long)this.arraySize + this.getUnderlyingSize(this.arraySize != 0));
    }

    private long getUnderlyingSize(boolean isArray) {
        for (ObjectInfo child : this.children) {
            this.size += (long)child.arraySize + child.getUnderlyingSize(child.arraySize != 0);
        }
        if (!isArray && !this.children.isEmpty()) {
            int tempSize = this.children.get((int)(this.children.size() - 1)).offset + this.children.get((int)(this.children.size() - 1)).length;
            this.size += this.addPaddingSize(tempSize);
        }
        return this.size;
    }

    public void sort() {
        Collections.sort(this.children, new OffsetComparator());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.toStringHelper(sb, 0);
        return sb.toString();
    }

    private void toStringHelper(StringBuilder sb, int depth) {
        this.depth(sb, depth).append("name=").append(this.name).append(", type=").append(this.type).append(", contents=").append(this.contents).append(", offset=").append(this.offset).append(", length=").append(this.length);
        if (this.arraySize > 0) {
            sb.append(", arrayBase=").append(this.arrayBase);
            sb.append(", arrayElemSize=").append(this.arrayElementSize);
            sb.append(", arraySize=").append(this.arraySize);
        }
        for (ObjectInfo child : this.children) {
            sb.append('\n');
            child.toStringHelper(sb, depth + 1);
        }
    }

    private StringBuilder depth(StringBuilder sb, int depth) {
        int i = 0;
        while (i < depth) {
            sb.append("\t");
            ++i;
        }
        return sb;
    }

    private long addPaddingSize(long size) {
        if (size % 8L != 0L) {
            return (size / 8L + 1L) * 8L;
        }
        return size;
    }

    private static final class OffsetComparator
    implements Comparator<ObjectInfo> {
        private OffsetComparator() {
        }

        @Override
        public int compare(ObjectInfo o1, ObjectInfo o2) {
            return o1.offset - o2.offset;
        }
    }
}

