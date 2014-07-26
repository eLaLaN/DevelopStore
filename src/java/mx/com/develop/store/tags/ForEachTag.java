package mx.com.develop.store.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import mx.com.develop.store.model.Producto;

public class ForEachTag extends SimpleTagSupport {

    private List<Producto> items;
    private int begin;
    private String var;
    private String varStatus;

    @Override
    public void doTag() throws JspException, IOException {
        JspContext pageContext = getJspContext();

        for (int step = begin; step < items.size(); step++) {
            Producto producto = items.get(step);
            pageContext.setAttribute(var, producto);
            pageContext.setAttribute(varStatus, step, PageContext.PAGE_SCOPE);

            getJspBody().invoke(null);
        }
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setVarStatus(String varStatus) {
        this.varStatus = varStatus;
    }
}
