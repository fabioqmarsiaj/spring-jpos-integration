package com.fabioqmarsiaj.springjposintegration;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.BASE24TCPChannel;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class APIController {

	@GetMapping("")
	public void sendAndReceiveIsoMsg() throws ISOException, NameRegistrar.NotFoundException, IOException {

		QMUX mux = NameRegistrar.get("mux.mymux");
		BASE24TCPChannel channelAdaptor = NameRegistrar.get("channel.mychannel");

		ISOMsg request = new ISOMsg();

		request.set(0, "0100");
		request.set(1, "0000000000000000");

		ISOMsg response = mux.request(request, 2000);
//		ISOMsg response2 = channelAdaptor.receive();
		System.out.println(response);
	}
}
