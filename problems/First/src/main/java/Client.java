import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final Logger log = Logger.getLogger(Client.class.getName());
    private SocketChannel socketChannel;
    private ByteBuffer buffer;

    public Client(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
        this.buffer = ByteBuffer.allocate(256);
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public static void main(String[] args) {
        Entity entity = new Entity("a", 2, "b");
        try {
            new Client(SocketChannel.open(new InetSocketAddress("localhost", 7000))).run(entity);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }

    public void run(Entity entity) throws IOException {
        sendEntity(entity);
        respondToClient();
    }

    public void sendEntity(Entity entity) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(entity);
        objectOutputStream.flush();
        buffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        socketChannel.write(buffer);
    }

    public void respondToClient() throws IOException {
        ByteBuffer inputBuffer = ByteBuffer.allocate(256);
        socketChannel.read(inputBuffer);
        log.info("Server response: ");
        String response = new String(inputBuffer.array()).trim();
        log.info(response);
        buffer.clear();
    }
}