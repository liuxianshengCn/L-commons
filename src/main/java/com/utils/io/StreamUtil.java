package com.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author liuxi
 * @since 2018-12-25
 */
public final class StreamUtil {


    public static int copy(InputStream in, OutputStream out) throws IOException {
        int byteCount = 0;
        if (null == in || out == null) return byteCount;

        byte[] buffer = new byte[4096];

        int bytesRead;
        for(boolean var4 = true; (bytesRead = in.read(buffer)) != -1; byteCount += bytesRead) {
            out.write(buffer, 0, bytesRead);
        }

        out.flush();
        return byteCount;
    }

}
