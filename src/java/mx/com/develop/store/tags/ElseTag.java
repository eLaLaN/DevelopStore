package mx.com.develop.store.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ElseTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        boolean test = ((IfTag) findAncestorWithClass(this, IfTag.class)).isTest();
        JspFragment jspBody = getJspBody();
        if (!test) {
            jspBody.invoke(null);
        }
    }
}
