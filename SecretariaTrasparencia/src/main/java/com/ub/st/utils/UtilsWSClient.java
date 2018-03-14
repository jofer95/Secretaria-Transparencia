/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author ulises
 */
public class UtilsWSClient {

    private static final Client CLIENT = Client.create();
    public static final String TURNED_ON = "http://192.168.10.10:8383/turnOn/api/services/isTurnedOn";
//    public static final String TURNED_ON = "http://201.165.0.142:8383/turnOn/api/services/isTurnedOn";

    public static WebResource wr() {
        return CLIENT.resource(TURNED_ON);
    }

    public static WebResource wr(String path) {
        return CLIENT.resource(path);
    }

}
