///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.netizen.eduman.api.common.utils;
//
//import java.io.IOException;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPReply;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author nasir
// */
//
//@Service
//public class FTPFileTransfer {
//
//    private static void showServerReply(FTPClient ftpClient) {
//       
//        String[] replies = ftpClient.getReplyStrings();
//        if (replies != null && replies.length > 0) {
//            for (String aReply : replies) {
//                System.out.println("SERVER: " + aReply);
//            }
//        }
//    }
//
//    
//    public boolean getFtpAccess() {
//     
//        String server = "192.168.31.215";
//        int port = 21;
//        String user = "eduman";
//        String pass = "eduman1234";
//        FTPClient ftpClient = new FTPClient();
//      
//        try {
//            ftpClient.connect(server, port);
//           
//            showServerReply(ftpClient);
//            int replyCode = ftpClient.getReplyCode();
//            if (!FTPReply.isPositiveCompletion(replyCode)) {
//                System.out.println("Operation failed. Server reply code: " + replyCode);
//                
//            }
//            boolean success = ftpClient.login(user, pass);
//            showServerReply(ftpClient);
//            if (!success) {
//                System.out.println("Could not login to the server");
//               
//            } else {
//                System.out.println("LOGGED IN SERVER");
//            }
//        } catch (IOException ex) {
//            System.out.println("Oops! Something wrong happened");
//            ex.printStackTrace();
//        }
//        return true;
//    }
//}
