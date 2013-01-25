import com.keymanage.validata.ValidataKey;
import org.junit.Test;
import com.keymanage.utils.CertificateUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-1-25 Time: 上午9:03 To change this template use File |
 * Settings | File Templates.
 */
public class TestCertificateUtils {
    @Test
    public void testFileSign() throws Exception {
        String filePath=URLDecoder.decode(this.getClass()
                .getClassLoader().getResource("/").getPath(), "utf-8")
                + "key";
        String sign = CertificateUtils.signFileToBase64(filePath, "d:/cysoft.keystore", "cysoft", "123456");
        System.out.println("生成的签名：" + sign);
    }

    @Test
    public void testValidataFile() throws Exception {
        boolean expired = CertificateUtils.verifyCertificate("d:/cysoft.cer");
        System.out.println(expired);
    }
}
