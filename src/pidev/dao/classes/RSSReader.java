/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gumus
 */
public class RSSReader {

//    public static void main(String[] args) {
//        System.out.println(readRSS("http://rss.cnn.com/rss/edition.rss"));
//    }

    public static Map<String, String> readRSS(String urlAdress) {
        Map<String, String> rss = new HashMap<>();

        try {
            URL rssUrl = new URL(urlAdress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String sourceCode1 = "";
            String temp = "";
            String temp1 = "";

            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("<title>")) {

                    int firstPos = line.indexOf("<title>");
                     temp = line.substring(firstPos);
                    temp = temp.replace("<title>", "");
                    int lastPos = temp.indexOf("</title>");
                    temp = temp.substring(0, lastPos);
//                    sourceCode += temp + "\n";
                }
                if (line.contains("<link>")) {

                    int firstPosLink = line.indexOf("<link>");
                     temp1 = line.substring(firstPosLink);
                    temp1 = temp1.replace("<link>", "");
                    int lastPosLink = temp1.indexOf("</link>");
                    temp1 = temp1.substring(0, lastPosLink);
//                    sourceCode1 += temp1 + "\n";
//                    System.out.println(temp1);

                }

                rss.put(temp, temp1);

            }
            in.close();
            return rss;

        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException ex) {
            System.out.println("something went wrong reading the contents");
        }
        return null;
    }

}
