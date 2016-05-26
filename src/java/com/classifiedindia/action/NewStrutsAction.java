
package com.classifiedindia.action;

/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class NewStrutsAction extends org.apache.struts.action.Action {

    private static final String SUCCESS = "success";

    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        
        return mapping.findForward(SUCCESS);
    }

    private Session getJndi() throws NamingException {
        Context c = new InitialContext();
        return (Session) c.lookup("java:comp/env/jndi");
    }

    private void sendMail(String email, String subject, String body) throws NamingException, MessagingException {
        Session jndi = getJndi();
        MimeMessage message = new MimeMessage(jndi);
        message.setSubject(subject);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
        message.setText(body);
        Transport.send(message);
    }
}
*/