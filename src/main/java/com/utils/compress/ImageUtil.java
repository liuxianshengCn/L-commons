package com.utils.compress;

import com.utils.io.StreamUtil;
import com.utils.string.StringUtil;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author liuxi
 * @since 2018-12-25
 */
@Slf4j
public class ImageUtil {

    /**
     * file to base64
     * @param file
     * @return
     */
    public static String image2base64(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

            return image2base64(fileInputStream);
        } finally {
            assert fileInputStream != null;
            fileInputStream.close();
        }
    }

    /**
     * inputstream to base64
     * @param is
     * @return
     * @throws IOException
     */
    public static String image2base64(InputStream is) throws IOException {

        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            StreamUtil.copy(is, outputStream);

            BASE64Encoder base64Encoder = new BASE64Encoder();
            byte[] b = outputStream.toByteArray();

            return base64Encoder.encode(b);
        } finally {
            assert outputStream != null;
            outputStream.close();
        }
    }

    /**
     * path to base64
     * @param path
     * @return
     * @throws IOException
     */
    public static String image2base64(String path) throws IOException {

        if (StringUtil.isEmpty(path)) return null;

        if (path.startsWith("http")){
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            try {
                URL url = new URL(path);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                inputStream = connection.getInputStream();
                return image2base64(inputStream);
            } finally {
                assert connection != null;
                connection.disconnect();

                assert inputStream != null;
                inputStream.close();
            }
        }else{
            File file = new File(path);
            return image2base64(file);
        }
    }

}
