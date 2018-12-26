package test;

import com.utils.compress.ImageUtil;

import java.io.IOException;

/**
 * @author liuxi
 * @since 2018-12-25
 */
public class ImageUtilTest {

    public static void main(String[] args) {
        try {
            String s = ImageUtil.image2base64("https://img5.duitang.com/uploads/item/201411/07/20141107164412_v284V.jpeg");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
