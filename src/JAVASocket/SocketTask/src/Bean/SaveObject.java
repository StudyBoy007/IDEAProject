package JAVASocket.SocketTask.src.Bean;

import java.io.Serializable;

public class SaveObject implements Serializable {
    private Object object;

    public SaveObject() {
    }

    public SaveObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
