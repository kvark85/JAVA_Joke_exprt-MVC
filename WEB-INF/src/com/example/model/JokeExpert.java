package com.example.model;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

public class JokeExpert {
    public static String getJoke(String type) {
        String inputLine;
        String res = "";
        URLConnection connection;
        BufferedReader bufferedReader;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc;

        try {
            connection = new URL("http://rzhunemogu.ru/Rand.aspx?CType=" + type).openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "windows-1251"));

            while ((inputLine = bufferedReader.readLine()) != null) {
                res += inputLine;
            }

            bufferedReader.close();

            builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(res));
            doc = builder.parse(is);

            res = doc.getElementsByTagName("content").item(0).getFirstChild().getNodeValue();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return res;
    }
}