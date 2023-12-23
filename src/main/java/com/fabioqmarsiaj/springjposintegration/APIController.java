package com.fabioqmarsiaj.springjposintegration;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping("")
    public boolean checkIfMuxIsConnected() throws NameRegistrar.NotFoundException {
        MUX mux = QMUX.getMUX("agent-mux");
        return mux.isConnected();
    }
}
