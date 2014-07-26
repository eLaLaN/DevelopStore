package mx.com.develop.store.tags;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FormatearMonedaTag extends SimpleTagSupport {

    private double moneda;

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write(formatearMoneda(moneda));
    }

    private String formatearMoneda(double moneda) {
        Locale locale = new Locale("es", "MX");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(moneda);
    }

    public void setMoneda(double moneda) {
        this.moneda = moneda;
    }

}
