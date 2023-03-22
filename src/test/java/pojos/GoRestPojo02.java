package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestPojo02 {

    private Object meta;
    private GoRestDataPojo02 data;

    public GoRestPojo02() {
    }

    public GoRestPojo02(Object meta, GoRestDataPojo02 data) {
        this.meta = meta;
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo02 getData() {
        return data;
    }

    public void setData(GoRestDataPojo02 data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestPojo02{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }



}
