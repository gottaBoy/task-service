/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.FromNativeContext
 *  com.sun.jna.Pointer
 *  com.sun.jna.PointerType
 *  com.sun.jna.win32.StdCallLibrary
 *  com.sun.jna.win32.W32APIFunctionMapper
 *  com.sun.jna.win32.W32APITypeMapper
 */
package SA.SRFDA.PS.Core.Util.JNA;

import SA.SRFDA.PS.Core.Util.JNA.W32Errors;
import com.sun.jna.FromNativeContext;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;
import java.util.HashMap;
import java.util.Map;

public interface W32API
extends StdCallLibrary,
W32Errors {
    public static final Map UNICODE_OPTIONS = new HashMap(){
        {
            this.put("type-mapper", W32APITypeMapper.UNICODE);
            this.put("function-mapper", W32APIFunctionMapper.UNICODE);
        }
    };
    public static final Map ASCII_OPTIONS = new HashMap(){
        {
            this.put("type-mapper", W32APITypeMapper.ASCII);
            this.put("function-mapper", W32APIFunctionMapper.ASCII);
        }
    };
    public static final Map DEFAULT_OPTIONS = Boolean.getBoolean("w32.ascii") ? ASCII_OPTIONS : UNICODE_OPTIONS;
    public static final HANDLE INVALID_HANDLE_VALUE = new HANDLE(){

        public void setPointer(Pointer p) {
            throw new UnsupportedOperationException("Immutable reference");
        }
    };

    public static class HANDLE
    extends PointerType {
        public Object fromNative(Object nativeValue, FromNativeContext context) {
            Object o = super.fromNative(nativeValue, context);
            if (INVALID_HANDLE_VALUE.equals(o)) {
                return INVALID_HANDLE_VALUE;
            }
            return o;
        }
    }
}

