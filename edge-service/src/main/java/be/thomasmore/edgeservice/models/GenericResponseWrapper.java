package be.thomasmore.edgeservice.models;

import java.util.LinkedHashMap;
import java.util.List;

public class GenericResponseWrapper {
    private LinkedHashMap _embedded;

    public LinkedHashMap get_embedded() {
        return _embedded;
    }

    public void set_embedded(LinkedHashMap _embedded) {
        this._embedded = _embedded;
    }
}
