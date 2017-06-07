package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;


public class SoapClientHandlerLog implements SOAPHandler<SOAPMessageContext> {
    private static final Logger LOG = LogManager.getLogger(SoapClientHandlerLog.class);

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        SOAPMessage message = context.getMessage();
        String str = "";

        boolean isOutboundMessage = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (isOutboundMessage) {
            str = "Request:\n";
        } else {
            str = "Response:\n";
        }

        try {
            message.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        str = str + XmlFormatter.prettyPrint(new String(out.toByteArray()));
        LOG.info(str);
        out.reset();
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        SOAPMessage message = context.getMessage();
        String str = "";

        boolean isOutboundMessage = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (isOutboundMessage) {
            str = "Request:\n";
        } else {
            str = "Response:\n";
        }

        try {
            message.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        str = str + XmlFormatter.prettyPrint(new String(out.toByteArray()));
        LOG.error(str);
        out.reset();
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
