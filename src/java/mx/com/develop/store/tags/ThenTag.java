package mx.com.develop.store.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ThenTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        boolean test = ((IfTag) getParent()).isTest();
        JspFragment jspBody = getJspBody();
        if (test) {
            jspBody.invoke(null);
        }
    }

}
