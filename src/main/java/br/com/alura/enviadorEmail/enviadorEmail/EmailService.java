package br.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void enviar(String nome, String emailConvidado) {
		try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.ifsc.edu.br");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("paulo.soares@ifsc.edu.br", Password.senhazimbra));
            email.setSSLOnConnect(true);

            email.setFrom("paulo.soares@ifsc.edu.br");
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP do projeto SpringBoot Alura.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
	}

}
