package Entity;

import java.io.Serializable;

/**
 * @author y1881
 * @date 2020.3.28 9:16
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private Object obj;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
