package com.keymanage.validata;

import com.keymanage.utils.CertificateUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-1-25 Time: 上午10:28 To change this template use File |
 * Settings | File Templates.
 * key验证类
 */
public class ValidataKey {

    /**
     * <p>验证方法</p>
     * author:tc
     */
    public  void Validata() {
        try {
            InputStream is=this.getClass()
                    .getClassLoader().getResourceAsStream("key");//因打成jar包，所以用此方法才能找到jar内的key文件。
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[1024];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();

            boolean illegal = CertificateUtils.verifySign(buffer.toByteArray(),
                    "EomSCUihKzKPdEwB9oWXsUJH0gNMUXgG77oMo9JdkQDlvD7MO2/qt1iIurLMfZRCQKQknlPGrkjJxgQ6bsCd42JzW2DGSe" +
                            "ELAhw4J442YPSyFop4xUAGeHgckEIe7gHfScS7SYg/XiMThJLN76JGbhpwtlKUgdGJ+fkdhq7AhGk=",
                    "d:/cysoft.cer");//certificatePath可以根需求修改
            if (!illegal) {
                System.out.println("非法授权文件！请联系产品开发商！");
                System.exit(0);
            }
            boolean expired = CertificateUtils.verifyCertificate("d:/cysoft.cer");//certificatePath可以根需求修改
            if (!expired) {
                System.out.println("授权已过期！请联系产品开发商！");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("非法授权文件！请联系产品开发商！");
            System.exit(0);
        }
    }
}
