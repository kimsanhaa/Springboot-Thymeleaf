package hello.springmvc.sha256;

import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

public class shaTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        sha256 sha256 = new sha256();
        //비밀번호 입력
        String password = "sanha";

        String cryptogram = sha256.encrypt(password);
        System.out.println("암호화 완료");
        System.out.println(cryptogram);


        System.out.println(cryptogram.equals(sha256.encrypt(password)));
    }
}
