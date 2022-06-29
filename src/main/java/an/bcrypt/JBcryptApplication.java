package an.bcrypt;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JBcryptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JBcryptApplication.class, args);
		String password_Not_encryption="1234";
		String password_Encryption=encryptionPassword(password_Not_encryption);
		
		System.out.println("Verification password: "+ verification_password(password_Not_encryption,password_Encryption));
		
		password_Not_encryption="1234";
		
		System.out.println("Verification password: "+ verification_password(password_Not_encryption,password_Encryption));
		
	}

	public static String encryptionPassword(String password) {
		String password_Encryption= BCrypt.hashpw(password, BCrypt.gensalt(12));
		return password_Encryption;
	}
	
	public static Boolean verification_password(String password_Not_Encryption,String password_Encryption){
		if(BCrypt.checkpw(password_Not_Encryption, password_Encryption)) {
			return true;
		}
		
		return false;
	}
}
