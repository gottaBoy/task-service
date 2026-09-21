/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  de.javawi.jstun.attribute.ChangedAddress
 *  de.javawi.jstun.attribute.MappedAddress
 *  de.javawi.jstun.attribute.MessageAttribute
 *  de.javawi.jstun.attribute.MessageAttributeException
 *  de.javawi.jstun.attribute.MessageAttributeInterface$MessageAttributeType
 *  de.javawi.jstun.attribute.MessageAttributeParsingException
 *  de.javawi.jstun.attribute.ResponseAddress
 *  de.javawi.jstun.attribute.SourceAddress
 *  de.javawi.jstun.attribute.UnknownAttribute
 *  de.javawi.jstun.attribute.UnknownMessageAttributeException
 *  de.javawi.jstun.header.MessageHeader
 *  de.javawi.jstun.header.MessageHeaderInterface$MessageHeaderType
 *  de.javawi.jstun.header.MessageHeaderParsingException
 *  de.javawi.jstun.util.Address
 *  de.javawi.jstun.util.UtilityException
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package SA.IM.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import de.javawi.jstun.attribute.ChangedAddress;
import de.javawi.jstun.attribute.MappedAddress;
import de.javawi.jstun.attribute.MessageAttribute;
import de.javawi.jstun.attribute.MessageAttributeException;
import de.javawi.jstun.attribute.MessageAttributeInterface;
import de.javawi.jstun.attribute.MessageAttributeParsingException;
import de.javawi.jstun.attribute.ResponseAddress;
import de.javawi.jstun.attribute.SourceAddress;
import de.javawi.jstun.attribute.UnknownAttribute;
import de.javawi.jstun.attribute.UnknownMessageAttributeException;
import de.javawi.jstun.header.MessageHeader;
import de.javawi.jstun.header.MessageHeaderInterface;
import de.javawi.jstun.header.MessageHeaderParsingException;
import de.javawi.jstun.util.Address;
import de.javawi.jstun.util.UtilityException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IMStunServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IMStunServer.class);
    Vector<DatagramSocket> sockets;
    Vector<StunServerReceiverThread> list = new Vector();

    public IMStunServer(int primaryPort, InetAddress primary, int secondaryPort, InetAddress secondary) throws SocketException {
        this.sockets = new Vector();
        this.sockets.add(new DatagramSocket(primaryPort, primary));
    }

    public void Start() throws Exception {
        if (this.list.size() != 0) {
            throw new Exception(StringHelper.Format((String)"\u670d\u52a1\u5668\u5df2\u7ecf\u542f\u52a8"));
        }
        for (DatagramSocket socket : this.sockets) {
            socket.setReceiveBufferSize(2000);
            StunServerReceiverThread ssrt = new StunServerReceiverThread(socket);
            ssrt.start();
            this.list.add(ssrt);
        }
    }

    public void Stop() throws Exception {
        for (StunServerReceiverThread ssrt : this.list) {
            ssrt.setStopFlag();
        }
        for (StunServerReceiverThread ssrt : this.list) {
            while (ssrt.isAlive()) {
                Thread.sleep(100L);
            }
        }
        this.list.clear();
    }

    class StunServerReceiverThread
    extends Thread {
        private boolean bRunFlag = true;
        private DatagramSocket receiverSocket;
        private DatagramSocket changedPort;
        private DatagramSocket changedIP;
        private DatagramSocket changedPortIP;

        public void setStopFlag() {
            this.bRunFlag = false;
        }

        StunServerReceiverThread(DatagramSocket datagramSocket) {
            this.receiverSocket = datagramSocket;
            for (DatagramSocket socket : IMStunServer.this.sockets) {
                if (socket.getLocalPort() != this.receiverSocket.getLocalPort() && socket.getLocalAddress().equals(this.receiverSocket.getLocalAddress())) {
                    this.changedPort = socket;
                }
                if (socket.getLocalPort() == this.receiverSocket.getLocalPort() && !socket.getLocalAddress().equals(this.receiverSocket.getLocalAddress())) {
                    this.changedIP = socket;
                }
                if (socket.getLocalPort() == this.receiverSocket.getLocalPort() || socket.getLocalAddress().equals(this.receiverSocket.getLocalAddress())) continue;
                this.changedPortIP = socket;
            }
        }

        @Override
        public void run() {
            while (this.bRunFlag) {
                try {
                    MessageHeader sendMH;
                    DatagramPacket receive = new DatagramPacket(new byte[200], 200);
                    this.receiverSocket.receive(receive);
                    LOGGER.debug(String.valueOf(this.receiverSocket.getLocalAddress().getHostAddress()) + ":" + this.receiverSocket.getLocalPort() + " datagram received from " + receive.getAddress().getHostAddress() + ":" + receive.getPort());
                    MessageHeader receiveMH = MessageHeader.parseHeader((byte[])receive.getData());
                    try {
                        receiveMH.parseAttributes(receive.getData());
                        if (receiveMH.getType() != MessageHeaderInterface.MessageHeaderType.BindingRequest) continue;
                        LOGGER.debug(String.valueOf(this.receiverSocket.getLocalAddress().getHostAddress()) + ":" + this.receiverSocket.getLocalPort() + " Binding Request received from " + receive.getAddress().getHostAddress() + ":" + receive.getPort());
                        ResponseAddress ra = (ResponseAddress)receiveMH.getMessageAttribute(MessageAttributeInterface.MessageAttributeType.ResponseAddress);
                        sendMH = new MessageHeader(MessageHeaderInterface.MessageHeaderType.BindingResponse);
                        sendMH.setTransactionID(receiveMH.getTransactionID());
                        MappedAddress ma = new MappedAddress();
                        ma.setAddress(new Address(receive.getAddress().getAddress()));
                        ma.setPort(receive.getPort());
                        sendMH.addMessageAttribute((MessageAttribute)ma);
                        ChangedAddress ca = new ChangedAddress();
                        ca.setAddress(new Address(this.changedPortIP.getLocalAddress().getAddress()));
                        ca.setPort(this.changedPortIP.getLocalPort());
                        sendMH.addMessageAttribute((MessageAttribute)ca);
                        LOGGER.debug("Nothing received in Change Request attribute");
                        SourceAddress sa = new SourceAddress();
                        sa.setAddress(new Address(this.receiverSocket.getLocalAddress().getAddress()));
                        sa.setPort(this.receiverSocket.getLocalPort());
                        sendMH.addMessageAttribute((MessageAttribute)sa);
                        byte[] data = sendMH.getBytes();
                        DatagramPacket send = new DatagramPacket(data, data.length);
                        if (ra != null) {
                            send.setPort(ra.getPort());
                            send.setAddress(ra.getAddress().getInetAddress());
                        } else {
                            send.setPort(receive.getPort());
                            send.setAddress(receive.getAddress());
                        }
                        this.receiverSocket.send(send);
                        LOGGER.debug(String.valueOf(this.receiverSocket.getLocalAddress().getHostAddress()) + ":" + this.receiverSocket.getLocalPort() + " send Binding Response to " + send.getAddress().getHostAddress() + ":" + send.getPort());
                    }
                    catch (UnknownMessageAttributeException umae) {
                        umae.printStackTrace();
                        sendMH = new MessageHeader(MessageHeaderInterface.MessageHeaderType.BindingErrorResponse);
                        sendMH.setTransactionID(receiveMH.getTransactionID());
                        UnknownAttribute ua = new UnknownAttribute();
                        ua.addAttribute(umae.getType());
                        sendMH.addMessageAttribute((MessageAttribute)ua);
                        byte[] data = sendMH.getBytes();
                        DatagramPacket send = new DatagramPacket(data, data.length);
                        send.setPort(receive.getPort());
                        send.setAddress(receive.getAddress());
                        this.receiverSocket.send(send);
                        LOGGER.debug(String.valueOf(this.changedPortIP.getLocalAddress().getHostAddress()) + ":" + this.changedPortIP.getLocalPort() + " send Binding Error Response to " + send.getAddress().getHostAddress() + ":" + send.getPort());
                    }
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                catch (MessageAttributeParsingException mape) {
                    mape.printStackTrace();
                }
                catch (MessageAttributeException mae) {
                    mae.printStackTrace();
                }
                catch (MessageHeaderParsingException mhpe) {
                    mhpe.printStackTrace();
                }
                catch (UtilityException ue) {
                    ue.printStackTrace();
                }
                catch (ArrayIndexOutOfBoundsException aioobe) {
                    aioobe.printStackTrace();
                }
            }
        }
    }
}

