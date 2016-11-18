/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.utilidades;

import no.vianett.sms.SmsEventListener;
import no.vianett.sms.Sms;
import no.vianett.sms.SmsEvent;
import no.vianett.sms.component.SmsTransceiver;
import no.vianett.sms.log.SmsScreenLogger;
import no.vianett.sms.event.SmsDeliveredEvent;
import no.vianett.sms.event.SmsSendingFailedEvent;
import no.vianett.sms.event.SmsDeliveryFailedEvent; 

public class SmsSender {
    

    private SmsTransceiver transceiver = SmsTransceiver.getInstance(); // Get the transceiver object.  
    private int counter = 0;
    private String tipoEvento;
    private int ddd;
    private int numeroCelular;

    public SmsTransceiver getTransceiver() {
        return transceiver;
    }

    public void setTransceiver(SmsTransceiver transceiver) {
        this.transceiver = transceiver;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }
    
    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
           
    public void SmsSender()
    {   
        String mensagem = "Ola,\n\n" +
        "Esta mensagem foi enviada para lembra-lo(a) da confirmacao de evento.\n\n" +
        "Tipo de Evento: "+getTipoEvento()+"\n\n"+
        "Esta mensagem foi enviada por um sistema automatico, por favor nao responda!";
       
        // Initialize transceiver.
        String smsHost = "cpa.vianett.no";
        String smsPort = "31337";
        String smsUsername = "rafael.sds@live.com";
        String smsPassword = "90gww";
        this.transceiver.initialize( smsHost, Integer.parseInt( smsPort ), smsUsername, smsPassword, new SmsScreenLogger() );
        
        this.transceiver.addSmsEventListener( new SmsEventListener() {
            @Override
            public void eventHappened(SmsEvent se) {
                System.out.println("se = " + se);
            }
        } ); // Registrer this class as listener for SMS events.
        
        // Send message
        Sms sms = new Sms();
        sms.setId( ++this.counter );
        sms.setReplyPath( 100 );
        sms.setSender( "1963" ); // Set the sender number.
        sms.setMessage(mensagem);
        sms.setRecipient( "55"+getDdd()+getNumeroCelular()); // The recipients phone number.
 
        this.transceiver.send( sms );
    } 
} 