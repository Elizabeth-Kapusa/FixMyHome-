//package com.example.image;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.google.ar.core.Session;
//import com.google.ar.core.exceptions.UnavailableApkTooOldException;
//import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
//import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
//import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
////import com.sabo.javamailapis.Helpers.Credentials;
//
//import java.net.PasswordAuthentication;
//import java.security.Security;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.Properties;
//import java.util.Set;
//
//import javax.activation.DataHandler;
//import javax.mail.Message;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.util.ByteArrayDataSource;
//
//public class GMailSender extends javax.mail.Authenticator implements Set<Session.Feature> {
//    private String mailhost = "smtp.gmail.com";
//    private Session session;
//    final String username = "yourname@yourcompany.com";
//    final String password = "yourpassword";
//
//    static {
//        Security.addProvider(new JSSEProvider());
//    }
//
//    public GMailSender() throws UnavailableDeviceNotCompatibleException, UnavailableSdkTooOldException, UnavailableArcoreNotInstalledException, UnavailableApkTooOldException {
//
//        Properties props = new Properties();
//        props.setProperty("mail.transport.protocol", "smtp");
//        props.setProperty("mail.host", mailhost);
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        props.setProperty("mail.smtp.quitwait", "false");
//
//        session = new Session(this,new javax.mail.Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//    }
//
//    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//        return new PasswordAuthentication(Credentials.EMAIL_SENDER, Credentials.PASSWORD_SENDER);
//    }
//
//    public synchronized void sendMail(String subject, String body,
//                                      String recipients) throws Exception {
//        MimeMessage message = new MimeMessage(session);
//        DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/html"));
//        message.setSender(new InternetAddress(Credentials.EMAIL_SENDER));
//        message.setSubject(subject);
//        message.setDataHandler(handler);
//
//        if (recipients.indexOf(',') > 0)
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
//        else
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
//
//        Transport.send(message);
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean contains(@Nullable Object o) {
//        return false;
//    }
//
//    @NonNull
//    @Override
//    public Iterator<Session.Feature> iterator() {
//        return null;
//    }
//
//    @NonNull
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    @NonNull
//    @Override
//    public <T> T[] toArray(@NonNull T[] ts) {
//        return null;
//    }
//
//    @Override
//    public boolean add(Session.Feature feature) {
//        return false;
//    }
//
//    @Override
//    public boolean remove(@Nullable Object o) {
//        return false;
//    }
//
//    @Override
//    public boolean containsAll(@NonNull Collection<?> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(@NonNull Collection<? extends Session.Feature> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(@NonNull Collection<?> collection) {
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(@NonNull Collection<?> collection) {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//}
