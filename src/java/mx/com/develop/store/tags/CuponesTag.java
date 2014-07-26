package mx.com.develop.store.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;

public class CuponesTag extends BodyTagSupport implements DynamicAttributes {

    private Map<String, Object> atributos = new HashMap<>();

    @Override
    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();
        for (Map.Entry<String, Object> cupon : atributos.entrySet()) {
            try {
                out.write(cupon.getKey() + ": " + cupon.getValue().toString() + "<br/>");
            } catch (IOException ex) {
            }
        }
        return SKIP_BODY;
    }

    @Override
    public void setDynamicAttribute(String uri, String attrName, Object value) throws JspException {
        atributos.put(attrName, value);
    }

}
