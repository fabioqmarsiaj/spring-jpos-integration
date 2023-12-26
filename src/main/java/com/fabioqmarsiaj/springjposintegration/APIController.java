package com.fabioqmarsiaj.springjposintegration;

import org.jpos.iso.*;
import org.jpos.iso.channel.BASE24TCPChannel;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.header.BASE1Header;
import org.jpos.iso.packager.Base1Packager;
import org.jpos.q2.iso.QMUX;
import org.jpos.q2.iso.QServer;
import org.jpos.util.NameRegistrar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping("")
    public void sendAndReceiveIsoMsg() throws IOException, ISOException {
        ISOPackager packager = new CustomPackager();
        ISOChannel channel = new BASE24TCPChannel("127.0.0.1", 10000, packager);

        channel.connect();

        ISOMsg request = new ISOMsg();

        request.set(0, "0100");
        request.set(1, "0000000000000000");

        System.out.println("CHANNEL CONNECTION: " + channel.isConnected());

        channel.send(request);
        System.out.println("REQUEST: " + request);

        ISOMsg response = channel.receive();
        System.out.println("RESPONSE " + response);

    }
}
