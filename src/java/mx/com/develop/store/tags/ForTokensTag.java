package mx.com.develop.store.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ForTokensTag extends BodyTagSupport {

    private String items;
    private String var;
    private String delim;
    private String[] tokens;

    private int index = 0;

    @Override
    public int doStartTag() throws JspException {
        tokens = items.split(delim);

        //pageContext.setAttribute("cupon", valor);
        pageContext.setAttribute(var, tokens[index]);
        index++;

        // return SKIP_BODY; << Default return
        return EVAL_BODY_INCLUDE;
    }

    /* Algo parecido a getJspBody().invoke();  */
    @Override
    public int doAfterBody() throws JspException {
        if (index < tokens.length) {
            pageContext.setAttribute(var, tokens[index]);
            index++;

            return EVAL_BODY_AGAIN;
        }

        return SKIP_BODY; //return por default
    }

    @Override
    public int doEndTag() throws JspException {
        //return SKIP_PAGE;
        return EVAL_PAGE;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setDelim(String delim) {
        this.delim = delim;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }

}
